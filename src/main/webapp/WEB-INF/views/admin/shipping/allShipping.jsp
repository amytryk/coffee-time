<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:adminpage title="Admin-Shipping">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Shipping</div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="col-md-1">Action</th>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Phone</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="shipping" items="${shipping}">
                            <tr>
                                <td><a href="/admin/shipping/${shipping.id}/delete/" class="glyphicon glyphicon-trash text-danger"></a></td>
                                <td> ${shipping.id}</td>
                                <td> ${shipping.name}</td>
                                <td> ${shipping.phone}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>

