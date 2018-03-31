<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>

<layout:customerpage title="Profile">
    <jsp:attribute name="css">
        <link rel="stylesheet" href="/_ui/css/profile.css">
    </jsp:attribute>
    <jsp:attribute name="js">
    </jsp:attribute>
    <jsp:body>
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Profile Image</div>
                <div class="panel-body">
                    <img src="${customer.pathImage}" alt="add photo" width="300px" height="300px"
                         class="img-responsive">

                    <form:form action="/profile/image/save" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="file" name="image">
                        </div>
                        <div class="form-group">
                            <button class="btn btn-success">Save Image</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">General</div>
                <div class="panel-body">
                    <form:form modelAttribute="customer" action="/profile/save" method="post"
                               class="form-horizontal">
                        <div class="form-group">
                            <label for="firstName" class="col-sm-2 control-label">First Name</label>
                            <div class="col-sm-10">
                                <form:input path="firstName" type="text" class="form-control" placeholder="First Name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="lastName" class="col-sm-2 control-label">Last Name</label>
                            <div class="col-sm-10">
                                <form:input path="lastName" type="text" class="form-control" placeholder="Last Name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email" class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <form:input path="email" type="text" class="form-control" placeholder="Email"
                                            disabled="true"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="phone" class="col-sm-2 control-label">Phone</label>
                            <div class="col-sm-10">
                                <form:input path="phone" type="text" class="form-control" placeholder="Phone"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Save</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Addresses</div>
                <div class="panel-body">
                    <ul class="list-group">
                        <c:forEach var="address" items="${customer.address}">
                            <li class="list-group-item">
                                <a href="/profile/address/${address.id}/delete" class="btn btn-danger">Delete</a>
                                    ${address.country.name} ${address.city} ${address.street} ${address.postalCode}
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">New Address</div>
                <div class="panel-body">
                    <form:form modelAttribute="newAddress" action="/profile/address/save" method="post"
                               class="form-horizontal">
                        <div class="form-group">
                            <label for="city" class="col-sm-2 control-label">City</label>
                            <div class="col-sm-10">
                                <form:input path="city" type="text" class="form-control" placeholder="City"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="street" class="col-sm-2 control-label">Street</label>
                            <div class="col-sm-10">
                                <form:input path="street" type="text" class="form-control" placeholder="Street"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="postalCode" class="col-sm-2 control-label">Postal Code</label>
                            <div class="col-sm-10">
                                <form:input path="postalCode" type="text" class="form-control"
                                            placeholder="Postal Code"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="country" class="col-sm-2 control-label">Country</label>
                            <div class="col-sm-10">
                                <form:select path="country.id" id="country" class="form-control">
                                    <form:options items="${countries}" itemValue="id" itemLabel="name"/>
                                </form:select>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Save Address</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </jsp:body>
</layout:customerpage>

