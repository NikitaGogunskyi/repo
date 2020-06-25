<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<img id="captcha" src="<c:url value="/captcha"/>"/>
<c:if test="${not empty hiddenField}">
    <input type="hidden" name="key" value="${hiddenField}"/>
</c:if>