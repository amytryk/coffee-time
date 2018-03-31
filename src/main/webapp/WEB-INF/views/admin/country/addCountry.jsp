<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-Country">
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">New Country</div>
                <div class="panel-body">
                    <form:form modelAttribute="country" action="/admin/country/save" method="post" class="form-horizontal">
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
                            <label for="isoCode" class="col-sm-2 control-label">ISO Code *</label>
                            <div class="col-sm-10">
                                <form:input path="isoCode" type="text" class="form-control"/>
                                <div class="has-error">
                                    <form:errors path="isoCode" class="text-danger"/>
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Save Country</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>

