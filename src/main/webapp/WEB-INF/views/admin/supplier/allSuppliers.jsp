<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-Supplier">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Suplliers</div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="col-md-1">Action</th>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Contact Name</th>
                            <th>Phone</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="supplier" items="${suppliers}">
                            <tr>
                                <td><a href="/admin/supplier/${supplier.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                                <td><a href="/admin/supplier/${supplier.id}/details">${supplier.id}</a></td>
                                <td>${supplier.name}</td>
                                <td>${supplier.contactName}</td>
                                <td>${supplier.phone}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>

