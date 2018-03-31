<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-New Customer">

    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">New Address</div>
                <div class="panel-body">
                    <form:form modelAttribute="address" action="/admin/customer/address/save" method="post"
                               class="form-horizontal">
                        <div class="form-group">
                            <label for="city" class="col-sm-2 control-label">City</label>
                            <div class="col-sm-10">
                                <form:input path="city" type="text" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="street" class="col-sm-2 control-label">Street</label>
                            <div class="col-sm-10">
                                <form:input path="street" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="postalCode" class="col-sm-2 control-label">Postal Code</label>
                            <div class="col-sm-10">
                                <form:input path="postalCode" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="country.id" class="col-sm-2 control-label">Country</label>
                            <div class="col-sm-10">
                                <form:select path="country.id" type="text" class="form-control">
                                    <form:options items="${countries}" itemValue="id" itemLabel="name"/>
                                </form:select>
                                <sf:hidden path="customer.id"></sf:hidden>

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
    </div>
</layout:adminpage>

