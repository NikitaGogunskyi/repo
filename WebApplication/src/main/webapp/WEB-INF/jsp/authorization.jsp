<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="../../css/authorization.css"/>
    <title>Login</title>
</head>
<body>
<div class="main">
    <p class="sign">Sign in</p>
    <form action="signIn" method="POST">
        <input type="text" name="email" placeholder="Login"/>
        <input type="password" name="password" placeholder="Password"/>
        <div>
            <button type="submit" class="login">LOGIN</button>
        </div>
        <div id="signInMessage">${signIn}</div>
    </form>
</div>
</body>
</html>
