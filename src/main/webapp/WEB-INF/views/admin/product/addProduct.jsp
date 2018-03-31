<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-Product">

    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">New Product</div>
                <div class="panel-body">
                    <form:form modelAttribute="product" action="/admin/product/save" method="post"
                               enctype="multipart/form-data"
                               class="form-horizontal">
                        <div class="form-group">
                            <label for="productImage" class="col-sm-2 control-label">Image</label>
                            <div class="col-sm-10">
                                <img id="productImage" alt="add photo" width="300px" height="300px" class="img-responsive">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="productImageSelect" class="col-sm-2 control-label"></label>
                            <div class="col-sm-10">
                                <input id="productImageSelect" type="file" name="image" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">Name *</label>
                            <div class="col-sm-10">
                                <form:input path="name" type="text" class="form-control"/>
                                <div class="has-error">
                                    <form:errors path="name" class="text-danger"/>
                                </div>
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
                                             itemLabel="name" itemValue="id" class="form-control" style="height: 200px">
                                </form:select>
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


