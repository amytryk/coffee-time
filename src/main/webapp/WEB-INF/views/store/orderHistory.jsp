<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:customerpage title="Order-History">
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">Carts</div>

            <div class="panel-body">
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th class="col-md-1">Id</th>
                        <th>Date</th>
                        <th>Total</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="cart" items="${carts}">
                        <tr>
                            <td><a href="/order/history/${cart.id}/details">${cart.id}</a></td>
                            <td> ${cart.date}</td>
                            <td> ${cart.formattedTotal}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <a href="/" class="btn btn-warning"><i class="glyphicon glyphicon-chevron-left"></i> Continue Shopping</a>
            </div>
        </div>
</layout:customerpage>