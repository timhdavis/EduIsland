<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>Edit Contact Info</head>
<Body>


<form:form id=" contactInfoForm" modelAttribute = "editContactInfoForm" action = "updateContactInfoProcess" method = "post">

    <div class="container">

        <label><b>First name: </b></label>
        <%--NOTE: "name" attribute corresponds to field "firstName" of new contactInfo object passed in:--%>
        <input type="text" placeholder="${user.userContactInfo.firstName}" name="firstName" required>

        <label><b>Middle name: </b></label>
        <input type="text" placeholder="${user.userContactInfo.middleName}" name="middleName" >

        <label><b>Last name: </b></label>
        <input type="text" placeholder="${user.userContactInfo.lastName}" name="lastName" required>


        <label><b>Phone number: </b></label>
        <input type="text" placeholder="${user.userContactInfo.phoneNumber}" name="phoneNumber" >

        <label><b>Email address: </b></label>
        <input type="text" placeholder="${user.userContactInfo.emailAddress}" name="emailAddress" >


        <label><b>Street: </b></label>
        <input type="text" placeholder="${user.userContactInfo.street}" name="street" >

        <label><b>City: </b></label>
        <input type="text" placeholder="${user.userContactInfo.city}" name="city" >

        <label><b>State: </b></label>
        <input type="text" placeholder="${user.userContactInfo.state}" name="state" >

        <label><b>zip code: </b></label>
        <input type="text" placeholder="${user.userContactInfo.zipCode}" name="zipCode" >


        <button type="submit">Update</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <a href="home.jsp">Cancel</a>
    </div>

    <table align="bottom">
        <tr>
            <td style ="font-style: italic; color: red;">${Error}</td>
        </tr>
    </table>
</form:form>


</Body>
</html>