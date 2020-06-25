<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/removeDefault.css"/>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>
<%@include file="WEB-INF/jsp/header.jsp" %>
<div class="container containerAddon">
    <div class="row">
        <div class="col-sm-5 col-lg-3 col-md-4">
            <%@include file="WEB-INF/jsp/sidebarFilter.jsp" %>
        </div>

        <div class="col-sm ">
            <div class="row">
                <%@include file="WEB-INF/jsp/products.jsp" %>
            </div>
        </div>

    </div>
    <%@include file="WEB-INF/jsp/pagination.jsp" %>
</div>

<%@include file="WEB-INF/jsp/footer.jsp" %>
<script src="${pageContext.request.contextPath}/webjars/jquery/3.4.0/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/4.1.0/js/bootstrap.bundle.min.js"></script>
</body>
</html>
