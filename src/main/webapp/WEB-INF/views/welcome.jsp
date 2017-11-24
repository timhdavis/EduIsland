<%--This is the page the user sees once they log into their account.--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
</head>
<body>
<table>
    <tr>
        <td>Welcome ${user.userContactInfo.firstName} ${user.userContactInfo.lastName}</td>
    </tr>
    <tr>
        <td>User ID: ${user.userId} </td>
    </tr>
    <tr>
        <td>
            <c:if test="${user.student}">
                Student Status: ${user.studentInfo.enrollmentStatus}
            </c:if>
        </td>
    </tr>
    <tr>
        <%--<c:choose>--%>
            <%--<c:when test="${user.userId == 'test123'}" >--%>
                <%--Hello, test123.--%>
            <%--</c:when>--%>
            <%--<c:otherwise>--%>
                <%--Hello, other user!--%>
            <%--</c:otherwise>--%>
        <%--</c:choose>--%>
    <tr>
        <td><a href="/eduIsland/showContactInfo">Contact Info</a></td><%--<td><a href="editContactInfo.jsp">Contact Info</a></td>--%>
    </tr>
    <tr>
        <td><a href="home.jsp">Home</a>
        </td>
    </tr>
</table>
</body>
</html>