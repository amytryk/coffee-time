<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-Product">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Products</div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="col-md-1">Action</th>
                            <th class="col-md-1">Id</th>
                            <th class="col-md-2">Name</th>
                            <th>Description</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="product" items="${products}">
                            <tr>
                                <td><a href="/admin/product/${product.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                                <td><a href="/admin/product/${product.id}/details">${product.id}</a></td>
                                <td>${product.name}</td>
                                <td>${product.description}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>


