<%--This is the page the user sees once they log into their account.--%>
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
        <td>User ID: ${user.userId}</td>
    </tr>
    <tr>
        <td>Is Student: ${user.student}</td>
    </tr>
    <tr>
        <%--<td>Student: <%= out.println("hello") %></td>--%>
    </tr>
    <%--<tr>--%>
        <%--<td><a href="viewContactInfo.jsp">Contact Info</a></td>--%>
    <%--</tr>--%>
    <tr>
        <td><a href="/eduIsland/editContactInfo">Contact Info</a></td><%--<td><a href="editContactInfo.jsp">Contact Info</a></td>--%>
    </tr>
    <tr>
        <td><a href="home.jsp">Home</a>
        </td>
    </tr>
</table>
</body>
</html>