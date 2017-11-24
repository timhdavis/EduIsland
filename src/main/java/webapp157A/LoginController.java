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

    @Autowired
    InstructorDAO instructorDAO;

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
        setUserInstructorInfo(validUser);

        if(validUser != null) {
            mav = new ModelAndView("welcome", "user", validUser);

            currentUser = validUser;
        } else {
            mav = new ModelAndView("login");
            mav.addObject("Error", "Incorrect UserName or Password");
        }
        return mav;
    }

    //---- TODO: move to UserController:

    @RequestMapping(value ="/showContactInfo", method = RequestMethod.GET)
    public ModelAndView showContactInfo(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("showContactInfo", "user", currentUser);

        return mav;
    }

    @RequestMapping(value ="/editContactInfo", method = RequestMethod.GET)
    public ModelAndView editContactInfo(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("editContactInfo"); // name of the JSP file referencing.
        mav.addObject("editContactInfoForm", new ContactInfo()); // attributeName from JSP form's modelAttribute field.
        mav.addObject("user", currentUser);

        return mav;
    }

    @RequestMapping(value="/updateContactInfoProcess", method = RequestMethod.POST)
    public ModelAndView updateContactInfo(HttpServletRequest request, HttpServletResponse response,
                                          @ModelAttribute("editContactInfoForm") ContactInfo contactInfoEntered) {
        ModelAndView mav = null;

        if (currentUser != null) {
            if (currentUser.getUserContactInfo() == null) { // if no contact info entered yet:
                contactInfoDAO.addContactInfoToUser(currentUser.getUserId(), contactInfoEntered);
            }
            else { // update contact info:
                currentUser.getUserContactInfo().update(contactInfoEntered);
                contactInfoDAO.updateContactInfo(currentUser.getUserContactInfo());
            }

            currentUser.setUserContactInfo(contactInfoDAO.getUserContactInfo(currentUser.getUserId()));

            mav = new ModelAndView("welcome", "user", currentUser);
        }
        else {
            mav = new ModelAndView("login");
            mav.addObject("Error", "No current user.");
        }

        return mav;
    }

    //-- edit Instructor info:

    @RequestMapping(value ="/editInstructorInfo", method = RequestMethod.GET)
    public ModelAndView editInstructorInfo(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("editInstructorInfo"); // name of the JSP file referencing.
        mav.addObject("editInstructorInfoForm", new InstructorInfo()); // attributeName from JSP form's modelAttribute field.
        mav.addObject("user", currentUser);

        return mav;
    }

    @RequestMapping(value="/updateInstructorInfoProcess", method = RequestMethod.POST)
    public ModelAndView updateContactInfo(HttpServletRequest request, HttpServletResponse response,
                                          @ModelAttribute("editInstructorInfoForm") InstructorInfo instructorInfoEntered) {
        ModelAndView mav = null;

        if (currentUser != null) {
            currentUser.getInstructorInfo().update(instructorInfoEntered);
            instructorDAO.updateInstructorInfo(currentUser.getInstructorInfo());

            currentUser.setInstructorInfo(instructorDAO.getInstructorInfo(currentUser.getUserId()));

            mav = new ModelAndView("welcome", "user", currentUser);
        }
        else {
            mav = new ModelAndView("login");
            mav.addObject("Error", "No current user.");
        }

        return mav;
    }

    // ---

    // Private methods:

    private void setUserContactInfo(User validUser)
    {
        ContactInfo validContactInfo = contactInfoDAO.getUserContactInfo(validUser.getUserId());
        validUser.setUserContactInfo(validContactInfo);
    }

    // adds student info if any exists in database for this user (null if not a student):
    private void setUserStudentInfo(User validUser)
    {
        StudentInfo validStudentInfo = studentDAO.getStudentInfo(validUser.getUserId());
        validUser.setStudentInfo(validStudentInfo);
    }

    // adds instructor info if any exists in database for this user (null if not a student):
    private void setUserInstructorInfo(User validUser)
    {
        InstructorInfo validInstructorInfo = instructorDAO.getInstructorInfo(validUser.getUserId());
        validUser.setInstructorInfo(validInstructorInfo);
    }
}
