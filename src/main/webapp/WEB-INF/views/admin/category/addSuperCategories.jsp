<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<layout:adminpage title="Admin-Category Details">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Select Super Categories</div>
                <div class="panel-body">
                    <form:form modelAttribute="category" action="/admin/category/${category.id}/supercategories/add" method="post" class="form-horizontal">
                        <div class="form-group">
                            <label for="supercategories" class="col-sm-2 control-label">Categories</label>
                            <div class="col-sm-10">
                                <form:select path="supercategories" multiple="true" type="text" items="${categoriesToSelect}"
                                             itemLabel="name" itemValue="id"  class="form-control" style="height: 300px">
                                </form:select>
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
    </div>
</layout:adminpage>