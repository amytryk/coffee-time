<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin - All Customers">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Customers</div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="col-md-1">Action</th>
                            <th>Id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="customer" items="${customers}">
                            <tr>
                                <td><a href="/admin/customer/${customer.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                                <td> <a href="/admin/customer/${customer.id}/details">${customer.id}</a></td>
                                <td> ${customer.firstName}</td>
                                <td> ${customer.lastName}</td>
                                <td> ${customer.email}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>
