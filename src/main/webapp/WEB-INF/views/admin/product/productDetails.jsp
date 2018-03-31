<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<layout:adminpage title="Admin-Product Details">
    <div class="container">

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">General</div>
            <div class="panel-body">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="productId" class="col-sm-2 control-label">Id</label>
                        <div class="col-sm-10">
                            <input id="productId" value="${product.id}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <input id="name" value="${product.name}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <input id="description" value="${product.description}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="imageUrl" class="col-sm-2 control-label">Image URL</label>
                        <div class="col-sm-10">
                            <input id="imageUrl" value="${product.imageUrl}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <a href="/admin/product/${product.id}/supplier/change" class="glyphicon glyphicon-pencil text-success"></a>&nbsp;
                <a href="/admin/product/${product.id}/supplier/delete" class="glyphicon glyphicon-trash text-danger"></a>&nbsp;Supplier</div>
            <div class="panel-body">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="supplierId" class="col-sm-2 control-label">Id</label>
                        <div class="col-sm-10">
                            <input id="supplierId" value="${product.supplier.id}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="supplierName" class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <input id="supplierName" value="${product.supplier.name}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="contactName" class="col-sm-2 control-label">Contact Name</label>
                        <div class="col-sm-10">
                            <input id="contactName" value="${product.supplier.contactName}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="supplierPhone" class="col-sm-2 control-label">Phone</label>
                        <div class="col-sm-10">
                            <input id="supplierPhone" value="${product.supplier.phone}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading"><a href="/admin/product/${product.id}/price/new" class="glyphicon glyphicon-plus text-success"></a> Prices</div>
            <div class="panel-body">

                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="col-md-1">Action</th>
                        <th>Id</th>
                        <th>Value</th>
                        <th>Currency</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="price" items="${product.prices}">
                        <tr>
                            <td><a href="/admin/product/${product.id}/price/${price.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                            <td> ${price.id}</td>
                            <td> ${price.value}</td>
                            <td> ${price.currency} </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading"><a href="/admin/product/${product.id}/categories/add" class="glyphicon glyphicon-plus text-success"></a> Categories</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="col-md-1">Action</th>
                        <th>Id</th>
                        <th>Name</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="category" items="${product.categories}">
                        <tr>
                            <td><a href="/admin/product/${product.id}/categories/${category.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                            <td> ${category.id}</td>
                            <td> ${category.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</layout:adminpage>
