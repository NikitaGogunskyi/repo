<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/removeDefault.css"/>
    <title>Cart</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.1.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="/WEB-INF/jsp/header.jsp" %>
<div class="container containerAddon">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-borderless">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">Product</th>
                        <th scope="col">Available</th>
                        <th scope="col" class="text-center">Quantity</th>
                        <th scope="col" class="text-right">Price</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td><img src="https://dummyimage.com/50x50/55595c/fff"/></td>
                        <td>Product Name</td>
                        <td>In stock</td>
                        <td><input class="form-control" type="text" value="1"/></td>
                        <td class="text-right">124,90 €</td>
                        <td class="text-right">
                            <button class="btn btn-sm btn-info"><i class="fa fa-trash"></i></button>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Sub-Total</td>
                        <td class="text-right">124,90 €</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Shipping</td>
                        <td class="text-right">4,10 €</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><strong>Total</strong></td>
                        <td class="text-right"><strong>130,00 €</strong></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12 col-md-6 float-right">
                    <button class="btn btn-block btn-light">Continue Shopping</button>
                </div>
            </div>
        </div>

    </div>
</div>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>