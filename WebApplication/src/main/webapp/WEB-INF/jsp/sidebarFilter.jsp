<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="filter" scope="request" class="com.epam.bean.FilterBean"/>
<form method="POST" action="main">
    <div class="card">
        <article class="card-group-item">
            <header class="card-header">
                <div class="md-form mt-0">
                    <input name="keyWord" class="form-control" type="text" placeholder="Search" aria-label="Search"
                           value="${filter.keyWord}">
                </div>
            </header>

            <div class="filter-content">
                <div class="card-body">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Min</label>
                            <input name="minCost" value="${filter.minCost}" type="number" class="form-control"
                                   id="inputEmail4" placeholder="$">
                        </div>
                        <div class="form-group col-md-6">
                            <label>Max</label>
                            <input name="maxCost" value="${filter.maxCost}" type="number" class="form-control"
                                   placeholder="$">
                        </div>
                    </div>
                </div>
            </div>
        </article>

        <article class="card-group-item">
            <header class="card-header">
                <h6 class="title">Selection </h6>
            </header>
            <div class="filter-content">
                <div class="card-body">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Order By</label>
                            <select name="order" class="browser-default custom-select">
                                <option value="${filter.sortBy}" selected>${filter.sortBy}</option>
                                <option value="price, low to high">price, low to high</option>
                                <option value="price, high to low">price, high to low</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label>Items per page</label>
                            <select name="items" class="browser-default custom-select">
                                <option value="${filter.productNum}" selected>${filter.productNum}</option>
                                <option value="3">3</option>
                                <option value="5">5</option>
                                <option value="10">10</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </article> <!-- card-group-item.// -->

        <article class="card-group-item">
            <header class="card-header">
                <h6 class="title">Category </h6>
            </header>

            <div class="filter-content">

                <div class="card-body">
                    <c:forEach items="${filter.categories}" var="category">
                        <div class="custom-control custom-checkbox">
                            <input name="category" value="${category.key}" type="checkbox" class="custom-control-input"
                                   id="${category.key}" ${category.value}>
                            <label class="custom-control-label" for="${category.key}">${category.key}</label>
                        </div>
                        <!-- form-check.// -->
                    </c:forEach>
                </div> <!-- card-body.// -->
            </div>
        </article> <!-- card-group-item.// -->
        <button style="font-size: x-large;" type="submit" class="btn btn-light">Search</button>
    </div>
    <!-- card.// -->
</form>