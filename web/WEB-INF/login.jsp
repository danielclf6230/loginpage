<%-- 
    Document   : login
    Created on : Jun 9, 2023, 9:17:37 AM
    Author     : danielchow
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="post">
        <h1>Login</h1>
        <label>Username: </label>
        <input type ="text" name="Username" value="${name}">
        <br>
        <label>Password: </label>
        <input type ="password" name="Password" value="${pass}">
        <br>
        <input type="submit" value="login">
        <br>
        ${errorMessage}
        <br>
        ${LogoutMessage}
        </form>
    </body>
</html>
