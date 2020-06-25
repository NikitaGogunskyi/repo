<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty products}">
    <p>No results...</p>
</c:if>

<c:forEach items="${products}" var="product">
    <div style="margin-bottom: 25px" class="col-lg-4 col-md-10">
        <div class="card h-100">
            <a href="main?item=${product.id}"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
            <div class="card-body">
                <h4 class="card-title">
                    <a href="main?item=${product.id}">${product.title}</a>
                </h4>
                <h5>${product.cost}</h5>
                <p class="card-text"></p>
            </div>
            <div class="card-footer">
                Category: ${product.category}
            </div>
        </div>
    </div>
</c:forEach>