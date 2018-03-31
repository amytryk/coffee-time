<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<layout:adminpage title="Admin-Category Details">
    <div class="container">

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">General</div>
            <div class="panel-body">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label for="categoryName" class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <input id="categoryName" value="${category.name}" type="text" class="form-control" disabled>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading"><a href="/admin/category/${category.id}/supercategories/add" class="glyphicon glyphicon-plus text-success"></a> Super Categories</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="col-md-1">Action</th>
                        <th>Name</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="superCat" items="${category.supercategories}">
                        <tr>
                            <td><a href="/admin/category/${category.id}/supercategories/${superCat.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                            <td> ${superCat.name}</td>
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
            <div class="panel-heading"><a href="/admin/category/${category.id}/subcategories/add" class="glyphicon glyphicon-plus text-success"></a> Sub Categories</div>
            <div class="panel-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="col-md-1">Action</th>
                        <th>Name</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="subCat" items="${category.subcategories}">
                        <tr>
                            <td><a href="/admin/category/${category.id}/subcategories/${subCat.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                            <td> ${subCat.name}</td>
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
                        <th>Product name</th>
                        <th>Description</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="product" items="${category.products}">
                        <tr>
                            <td><a href="/admin/category/${category.id}/products/${product.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
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
