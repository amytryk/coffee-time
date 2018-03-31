<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-New Supplier Address">

    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">New Country</div>
                <div class="panel-body">
                    <form:form modelAttribute="price" action="/admin/product/price/save" method="post"
                               class="form-horizontal">
                        <div class="form-group">
                            <label for="value" class="col-sm-2 control-label">Value</label>
                            <div class="col-sm-10">
                                <form:input path="value" type="text" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="currency" class="col-sm-2 control-label">Currency</label>
                            <div class="col-sm-10">
                                <form:select path="currency" class="form-control">
                                    <form:options items="${currencies}"/>
                                </form:select>
                                <form:hidden path="product.id"></form:hidden>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Save Price</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>