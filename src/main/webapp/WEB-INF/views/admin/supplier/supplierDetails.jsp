<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<layout:adminpage title="Admin-Supplier Details">
    <div class="container">

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">General</div>
            <div class="panel-body">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="supplierName" class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <input id="supplierName" value="${supplier.name}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="contactName" class="col-sm-2 control-label">Contact Name</label>
                        <div class="col-sm-10">
                            <input id="contactName" value="${supplier.contactName}" type="text" class="form-control"
                                   disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="phone" class="col-sm-2 control-label">Phone</label>
                        <div class="col-sm-10">
                            <input id="phone" value="${supplier.phone}" type="text" class="form-control" disabled>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading"><a href="/admin/supplier/${supplier.id}/address/new" class="glyphicon glyphicon-plus text-success"></a> Address
            </div>
            <div class="panel-body">

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="col-md-1">Action</th>
                        <th>Id</th>
                        <th>Country</th>
                        <th>City</th>
                        <th>Street</th>
                        <th>Postal Code</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="address" items="${supplier.addresses}">
                        <tr>
                            <td><a href="/admin/supplier/${supplier.id}/address/${address.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                            <td> ${address.id}</td>
                            <td> ${address.country.name}</td>
                            <td> ${address.city}</td>
                            <td> ${address.street} </td>
                            <td> ${address.postalCode}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


    <br>

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">Products</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="col-md-1">Action</th>
                        <th>Id</th>
                        <th>Product name</th>
                        <th>Description</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="product" items="${supplier.productses}">
                        <tr>
                            <td><a href="/admin/supplier/${supplier.id}/product/${product.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                            <td> ${product.id}</td>
                            <td> ${product.name}</td>
                            <td> ${product.description}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</layout:adminpage>
