<%@ taglib uri="/tld/UserBarTagDescription.tld" prefix="u" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/font-awesome/5.12.0/css/fontawesome.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/font-awesome/5.12.0/css/all.min.css">
<div class="header">
    <form action="/main" method="POST">
        <div class="logo">CompanyLogo</div>
        <div class="header-right">
            <a href="${pageContext.request.contextPath}/main">Products</a>
            <a class="active" href="${pageContext.request.contextPath}/cart"><i style="color: #ffffff"
                                                                                class="fas fa-shopping-cart fa-2x"></i>
            </a>
            <u:userBar/>
        </div>
    </form>
</div>