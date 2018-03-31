<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:customerpage title="Order-History-Details">

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">Shipping</div>
            <div class="panel-body">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="shippingMethod" class="col-sm-2 control-label">Shipping Method</label>
                        <div class="col-sm-10">
                            <input id="shippingMethod" value="${shippingMethod.name}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="shippingAddress" class="col-sm-2 control-label">Shipping Address</label>
                        <div class="col-sm-10">
                            <input id="shippingAddress" value="${shippingAddress.fullAddress}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">Cart Entry</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>Product Name</th>
                        <th>Quantity</th>
                        <th>Subtotal</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="cartEntry" items="${cart.cartEntries}">
                        <tr>
                            <td> ${cartEntry.product.name}</td>
                            <td> ${cartEntry.quantity}</td>
                            <td> ${cartEntry.formattedSubtotal}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-12 col-md-6">
            <a href="/order/history" class="btn btn-warning"><i class="glyphicon glyphicon-chevron-left"></i> Order History</a>
        </div>
    </div>

</layout:customerpage>