<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<layout:adminpage title="Admin-Customer Details">
    <div class="container">

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">General</div>
                <div class="panel-body">
                    <div class="form-horizontal">
                        <div class="form-group">
                            <label for="firstName" class="col-sm-2 control-label">First Name</label>
                            <div class="col-sm-10">
                                <input id="firstName" value="${customer.firstName}" type="text" class="form-control"
                                       disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-sm-2 control-label">Last Name</label>
                            <div class="col-sm-10">
                                <input id="lastName" value="${customer.lastName}" type="text" class="form-control"
                                       disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">Phone</label>
                            <div class="col-sm-10">
                                <input id="phone" value="${customer.phone}" type="text" class="form-control" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <input id="email" value="${customer.email}" type="text" class="form-control" disabled>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading"><a href="/admin/customer/${customer.id}/address/new" class="glyphicon glyphicon-plus text-success"></a> Addresses
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
                        <c:forEach var="address" items="${customer.address}">
                            <tr>
                                <td> <a href="/admin/customer/address/${address.id}/delete" class="glyphicon glyphicon-trash text-danger"></a></td>
                                <td> ${address.id}</td>
                                <td> ${address.country.name}</td>
                                <td> ${address.city}</td>
                                <td> ${address.street}</td>
                                <td> ${address.postalCode}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>
