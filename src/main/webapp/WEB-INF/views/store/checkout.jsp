<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:customerpage title="Checkout">
    <form:form modelAttribute="checkoutForm" action="/checkout/submit" method="post" class="form-horizontal">
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">Shipping</div>
                <div class="panel-body">
                    <div class="form-group">
                        <label for="shippingId" class="col-sm-2 control-label">Shipping Method</label>
                        <div class="col-sm-10">
                            <form:select path="shippingId" type="text" items="${shippingList}" itemLabel="name" itemValue="id" class="form-control">
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="shippingAddressId" class="col-sm-2 control-label">Shipping Address</label>
                        <div class="col-sm-10">
                            <form:select path="shippingAddressId" type="text" items="${addressList}" itemLabel="fullAddress" itemValue="id" class="form-control">
                            </form:select>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-12 col-md-6">
                <a href="/cart" class="btn btn-warning"><i class="glyphicon glyphicon-chevron-left"></i> Back To Cart</a>
            </div>
            <div class="col-xs-12 col-md-6">
                <button type="submit" class="btn btn-success pull-right">Submit <i class="glyphicon glyphicon-chevron-right"></i></button>
            </div>
        </div>
    </form:form>

</layout:customerpage>