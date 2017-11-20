package webapp157A;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    ContactInfoDAO contactInfoDAO;

    @Autowired
    StudentDAO studentDAO;

    public User currentUser = null; // TODO: this could be a security issue / be incorrect.

    @RequestMapping(value ="/login", method = RequestMethod.GET)
        public ModelAndView getLoginForm(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("loginForm", new User());

        return mav;
    }

    @RequestMapping(value="/loginProcess", method = RequestMethod.POST)
        public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginForm") User user) {
        ModelAndView mav = null;

        User validUser = userDAO.validateUser(user);

        setUserContactInfo(validUser);
        setUserStudentInfo(validUser);

        if(validUser != null) {
            mav = new ModelAndView("welcome", "user", validUser);//mav = new ModelAndView("welcome", "userId", validUser.getUserId());

            currentUser = validUser;
        } else {
            mav = new ModelAndView("login");
            mav.addObject("Error", "Incorrect UserName or Password");
        }
        return mav;
    }

    //---- TODO: move to UserController:

    @RequestMapping(value ="/editContactInfo", method = RequestMethod.GET) // TODO: FIX
    public ModelAndView editContactInfo(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("editContactInfo"); // name of the JSP file referencing.
        mav.addObject("editContactInfoForm", new ContactInfo()); // attributeName from JSP form's modelAttribute field.

        return mav;
    }

    @RequestMapping(value="/updateContactInfoProcess", method = RequestMethod.POST)
    public ModelAndView updateContactInfo(HttpServletRequest request, HttpServletResponse response,
                                          @ModelAttribute("editContactInfoForm") ContactInfo contactInfo) {
        ModelAndView mav = null;

        if (currentUser != null)
        {
            contactInfoDAO.addContactInfoToUser(currentUser.getUserId(), contactInfo);//TODO: Note this may cause errors - it Adds new record instead of Updating...

            currentUser.setUserContactInfo(contactInfoDAO.getUserContactInfo(currentUser.getUserId())); //TODO: this may be dangerous...

            mav = new ModelAndView("welcome", "user", currentUser);
        }
        else {
            mav = new ModelAndView("login");
            mav.addObject("Error", "Incorrect UserName or Password");
        }

        return mav;
    }

    // Private methods:

    private void setUserContactInfo(User validUser)
    {
        ContactInfo validContactInfo = contactInfoDAO.getUserContactInfo(validUser.getUserId());
        validUser.setUserContactInfo(validContactInfo);
    }

    // adds student info if any exists (null if not a student):
    private void setUserStudentInfo(User validUser)
    {
        StudentInfo validStudentInfo = studentDAO.getStudentInfo(validUser.getUserId());
        validUser.setStudentInfo(validStudentInfo);
    }
}
