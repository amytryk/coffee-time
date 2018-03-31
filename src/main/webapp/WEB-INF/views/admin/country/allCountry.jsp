<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-country">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Countries</div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th class="col-md-1">Action</th>
                            <th>Id</th>
                            <th>Name</th>
                            <th>ISO Code</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="country" items="${countries}">
                            <tr>
                                <td><a href="/admin/country/${country.id}/delete/"
                                       class="glyphicon glyphicon-trash text-danger"></a></td>
                                <td> ${country.id}</td>
                                <td> ${country.name}</td>
                                <td> ${country.isoCode}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>

