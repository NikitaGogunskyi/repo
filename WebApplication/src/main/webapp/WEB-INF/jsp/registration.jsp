<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tld/CaptchaTagDescriptor.tld" prefix="m" %>
<jsp:useBean id="form" scope="request" class="com.epam.bean.FormBean"/>
<c:set var="errors" scope="request" value="${form.errors}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>registration</title>
    <link rel="stylesheet" href="../../css/removeDefault.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/register.css"/>
    <script src="../../jQuery/jQuery.min.js"></script>
</head>

<body>

<form id="registrationForm" action="signUp" enctype="multipart/form-data" method="POST">
    <div class="container">
        <h1>Register</h1>
        <hr/>
        <p>Please fill in this form to create an account.</p>
        <hr/>
        <label><b>Full Name</b></label>
        <input class="in" value="${form.name}" type="text" placeholder="Enter Name" name="name"/>
        <div class="error" id="tooltipName">${errors['name']}</div>
        <label><b>Email</b></label>
        <input class="in" value="${form.email}" type="text" placeholder="Enter Email" name="email"/>
        <div class="error" id="tooltipEmail">${errors['email']}</div>
        <label><b>Password</b></label>
        <input class="in" type="password" placeholder="Enter Password" name="password"/>
        <div class="error" id="tooltipPassword">${errors['password']}</div>
        <label><b>Repeat Password</b></label>
        <input class="in" type="password" placeholder="Repeat Password" name="repeatedPassword"/>
        <div class="error" id="tooltipRepeatedPassword">${errors['repeatedPassword']}</div>
        <hr/>
        <input type="checkbox" name="agreement"/>
        <label style="${errors['agreement']}">I agree to have my personal data processed</label>
        <hr/>
        <div class="captcha">
            <m:captcha/>
            <input style="${errors['captcha']}" autocomplete="off" type="text" name="captcha"/>
        </div>
        <button type="submit" class="registerbtn">Register</button>
        <label>Upload your photo</label>
        <input name="avatar" accept="image/jpeg" type="file"/>
        <div style="color: red">${errors['avatar']}</div>
    </div>
</form>
<script src="../../js/const.js"></script>
<script src="../../jQuery/jQueryValidation.js"></script>
</body>
</html>
