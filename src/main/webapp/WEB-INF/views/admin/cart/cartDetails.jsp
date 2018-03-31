<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<layout:adminpage title="Admin-Cart Details">

    <div class="container">

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">General</div>
                <div class="panel-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label for="customerName" class="col-sm-2 control-label">First Name</label>
                            <div class="col-sm-10">
                                <input id="customerName" value="${cart.customer.firstName}" type="text" class="form-control" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-sm-2 control-label">Last Name</label>
                            <div class="col-sm-10">
                                <input id="lastName" value="${cart.customer.lastName}" type="text" class="form-control"
                                       disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="date" class="col-sm-2 control-label">Date</label>
                            <div class="col-sm-10">
                                <input id="date" value="${cart.date}" type="text" class="form-control" disabled>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading"><a href="/admin/cart/${cart.id}/shipping/change" class="glyphicon glyphicon-pencil text-success"></a>&nbsp;
                    <a href="/admin/cart/${cart.id}/shipping/delete" class="glyphicon glyphicon-trash text-danger"></a>&nbsp;Shipping Method</div>
                <div class="panel-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label for="shippingName" class="col-sm-2 control-label">Name</label>
                            <div class="col-sm-10">
                                <input id="shippingName" value="${cart.shipping.name}" type="text" class="form-control" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="shippingPhone" class="col-sm-2 control-label">Phone</label>
                            <div class="col-sm-10">
                                <input id="shippingPhone" value="${cart.shipping.phone}" type="text" class="form-control" disabled>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Shipping Address</div>
                <div class="panel-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label for="addressCountry" class="col-sm-2 control-label">Country</label>
                            <div class="col-sm-10">
                                <input id="addressCountry" value="${cart.shippingAddress.country.name}" type="text" class="form-control" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addressCity" class="col-sm-2 control-label">City</label>
                            <div class="col-sm-10">
                                <input id="addressCity" value="${cart.shippingAddress.city}" type="text" class="form-control" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addressStreet" class="col-sm-2 control-label">Street</label>
                            <div class="col-sm-10">
                                <input id="addressStreet" value="${cart.shippingAddress.street}" type="text" class="form-control" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="addressPostal" class="col-sm-2 control-label">Postal Code</label>
                            <div class="col-sm-10">
                                <input id="addressPostal" value="${cart.shippingAddress.postalCode}" type="text" class="form-control" disabled>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading"><a href="/admin/cart/${cart.id}/cartEntry/new" class="glyphicon glyphicon-plus text-success"></a> Cart Entry</div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="col-md-1">Action</th>
                            <th>Id</th>
                            <th>Quantity</th>
                            <th>Product Name</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="cartEntry" items="${cart.cartEntries}">
                            <tr>
                                <td><a href="/admin/cart/${cart.id}/cartEntry/${cartEntry.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                                <td> ${cartEntry.id}</td>
                                <td> ${cartEntry.quantity}</td>
                                <td> ${cartEntry.product.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>


    </div>
</layout:adminpage>
