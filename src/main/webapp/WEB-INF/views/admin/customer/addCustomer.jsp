<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin - Customer">
    <div class="container">
        <div class="row">
            <div class="panel panel-primary">
                <div class="panel-body">
                    <form:form modelAttribute="customer" action="/admin/customer/save" method="post" role="form">
                        <div class="form-group">
                            <h2>Create account</h2>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="firstName">First name *</label>
                            <form:input path="firstName" id="firstName" type="text" maxlength="50" class="form-control"/>
                            <div class="has-error">
                                <form:errors path="firstName" class="text-danger"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="lastName">Last Name *</label>
                            <form:input path="lastName" id="lastName" type="text" maxlength="50" class="form-control"/>
                            <div class="has-error">
                                <form:errors path="lastName" class="text-danger"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="email">Email *</label>
                            <form:input path="email" id="email" type="email" maxlength="50" class="form-control"/>
                            <div class="has-error">
                                <form:errors path="email" class="text-danger"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="phone">Phone</label>
                            <form:input path="phone" id="phone" type="text" maxlength="25" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="password">Password *</label>
                            <form:input path="password" id="password" type="password" maxlength="25" class="form-control" placeholder="at least 6 characters"/>
                            <div class="has-error">
                                <form:errors path="password" class="text-danger"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="confirmPassword">Confirm Password *</label>
                            <form:input path="confirmPassword" id="confirmPassword" type="password" maxlength="25" class="form-control" placeholder="at least 6 characters"/>
                            <div class="has-error">
                                <form:errors path="confirmPassword" class="text-danger"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success">Save</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>
