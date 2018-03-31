<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-Cart">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Carts</div>

                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="col-md-1">Action</th>
                            <th class="col-md-1">Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Date</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="cart" items="${carts}">
                            <tr>
                                <td><a href="/admin/cart/${cart.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                                <td><a href="/admin/cart/${cart.id}/details">${cart.id}</a></td>
                                <td> ${cart.customer.firstName}</td>
                                <td> ${cart.customer.lastName}</td>
                                <td> ${cart.date}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>
