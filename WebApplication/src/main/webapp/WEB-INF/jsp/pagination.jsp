<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="paginator" scope="request" type="com.epam.bean.PageBean"/>
<nav style="display: flex; justify-content: center;" aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item">
            <a class="page-link" href="${pageContext.request.contextPath}/main?page=1">first</a>
        </li>
        <c:forEach items="${paginator.pageNumbers}" var="page">
            <li class="page-item">
                <a class="page-link"
                        <c:if test="${page eq paginator.currentPage}">
                            style="background: #dde4ef;"
                        </c:if>
                   href="${pageContext.request.contextPath}/main?page=${page}">${page}</a>
            </li>
        </c:forEach>
        <li class="page-item">
            <a class="page-link"href="${pageContext.request.contextPath}/main?page=${paginator.lastPage}">last</a>
        </li>
    </ul>
</nav>