<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:adminpage title="Admin-CartEntry">


    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">New Cart Entry</div>
                <div class="panel-body">
                    <form:form modelAttribute="cartEntry" action="/admin/cart/cartEntry/save" method="post"
                               class="form-horizontal">
                        <div class="form-group">
                            <label for="product.id" class="col-sm-2 control-label">Product</label>
                            <div class="col-sm-10">
                                <form:select path="product.id" class="form-control">
                                    <form:options items="${products}" itemValue="id" itemLabel="name"/>
                                </form:select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="quantity" class="col-sm-2 control-label">Quantity</label>
                            <div class="col-sm-10">
                                <form:input path="quantity" type="text" class="form-control"/>
                                <form:hidden path="cart.id"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-success">Add Cart Entry</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</layout:adminpage>