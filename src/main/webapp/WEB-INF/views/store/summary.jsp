<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:customerpage title="Summary">
    <div class="row">
        <div class="alert alert-success" role="alert">Order is successfully placed</div>
    </div>
    <div class="row">
        <div class="col-xs-12 col-md-6">
            <a href="/" class="btn btn-warning"><i class="glyphicon glyphicon-chevron-left"></i> Continue Shopping</a>
        </div>
        <div class="col-xs-12 col-md-6">
            <a href="/order/history" class="btn btn-success pull-right">Order History <i class="glyphicon glyphicon-chevron-right"></i></a>
        </div>
    </div>
</layout:customerpage>