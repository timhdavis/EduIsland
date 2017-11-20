<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>Login</head>
<Body>


<form:form id=" contactInfoForm" modelAttribute = "editContactInfoForm" action = "updateContactInfoProcess" method = "post">

    <div class="container">

        <label><b>First name: </b></label>
        <%--NOTE: "name" attribute corresponds to field "firstName" of new contactInfo object passed in:--%>
        <input type="text" placeholder="Enter first name" name="firstName" required>

        <label><b>Middle name: </b></label>
        <input type="text" placeholder="Enter middle name" name="middleName" >

        <label><b>Last name: </b></label>
        <input type="text" placeholder="Enter last name" name="lastName" required>


        <label><b>Phone number: </b></label>
        <input type="text" placeholder="Enter phone number" name="phoneNumber" >

        <label><b>Email address: </b></label>
        <input type="text" placeholder="Enter email address" name="emailAddress" >


        <label><b>Street: </b></label>
        <input type="text" placeholder="Enter street" name="street" >

        <label><b>City: </b></label>
        <input type="text" placeholder="Enter city" name="city" >

        <label><b>State: </b></label>
        <input type="text" placeholder="Enter state" name="state" >

        <label><b>zip code: </b></label>
        <input type="text" placeholder="Enter zip code" name="zipCode" >


        <button type="submit">Update</button>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
    </div>

    <table align="bottom">
        <tr>
            <td style ="font-style: italic; color: red;">${Error}</td>
        </tr>
    </table>
</form:form>


</Body>
</html>