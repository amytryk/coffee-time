<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-New Supplier Product">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">New Product</div>
                <div class="panel-body">
                    <form:form modelAttribute="product" action="/admin/supplier/product/save" method="post"
                               class="form-horizontal">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Name</label>
                            <div class="col-sm-10">
                                <form:input path="name" type="text" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="description" class="col-sm-2 control-label">Description</label>
                            <div class="col-sm-10">
                                <form:input path="description" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="categories" class="col-sm-2 control-label">Categories</label>
                            <div class="col-sm-10">
                                <form:select path="categories" multiple="true" type="text" items="${categories}"
                                             itemLabel="name" itemValue="id" class="form-control">
                                </form:select>
                                <form:hidden path="supplier.id"></form:hidden>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Save Product</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

</layout:adminpage>

