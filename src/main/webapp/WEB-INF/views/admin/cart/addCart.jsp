<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-Cart">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">New Cart</div>
                <div class="panel-body">
                    <form:form modelAttribute="cart" action="/admin/cart/save" method="post"  class="form-horizontal">
                        <div class="form-group">
                            <label for="date" class="col-sm-2 control-label">Date *</label>
                            <div class="col-sm-10">
                                <form:input path="date" type="date" class="form-control"/>
                                <div class="has-error">
                                    <form:errors path="date" class="text-danger"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="customer" class="col-sm-2 control-label">Customer Email *</label>
                            <div class="col-sm-10">
                                <form:input path="customer" type="text" class="form-control"/>
                                <div class="has-error">
                                    <form:errors path="customer" class="text-danger"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Save Cart</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>


</layout:adminpage>
