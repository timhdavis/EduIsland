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
        <td>Welcome ${user.userContactInfo.firstName} / ID: ${user.userId} </td>
    </tr>
    <tr>
    </tr>
    <tr>
    </tr>
    <tr>
        <td><a href="home.jsp">Home</a>
        </td>
    </tr>
</table>
</body>
</html>