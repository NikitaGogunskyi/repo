<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
    <c:when test="${not empty user}">

        <a href="#" style="margin: 0"><img title="<c:out value="${user.name}"/>" src="<c:url value="/avatar"/>"
                                           style="max-width: 50px"></a>
        <a href="/logout">Logout</a>
    </c:when>
    <c:otherwise>
        <a href="<c:url value="/signIn"/> ">Sign In</a>
        <a href="<c:url value="/signUp"/> ">Sign Up</a>
    </c:otherwise>
</c:choose>