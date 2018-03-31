<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-Category">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Categories</div>
                <div class="panel-body">

                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="col-md-1">Action</th>
                            <th>Id</th>
                            <th>Name</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="category" items="${categories}">
                            <tr>
                                <td><a href="/admin/category/${category.id}/delete/"
                                       class="glyphicon glyphicon-trash text-danger"></a></td>
                                <td><a href="/admin/category/${category.id}/details">${category.id}</a></td>
                                <td>${category.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
        </div>
    </div>

</layout:adminpage>

