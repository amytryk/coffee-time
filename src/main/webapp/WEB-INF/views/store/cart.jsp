<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:customerpage title="Cart">
    <jsp:attribute name="css">
        <link rel="stylesheet" href="/_ui/css/cart.css"/>
    </jsp:attribute>
    <jsp:attribute name="js">
        <script src="/_ui/js/cart.js"></script>
    </jsp:attribute>
    <jsp:body>
        <table id="cart" class="table table-hover table-condensed">
            <thead>
            <tr>
                <th style="width:50%">Product</th>
                <th style="width:10%">Price</th>
                <th style="width:8%">Quantity</th>
                <th style="width:22%" class="text-center">Subtotal</th>
                <th style="width:10%"></th>
            </tr>
            </thead>
            <tbody>
            <c:if test="${empty cart.cartEntries}">
                <td colspan="5" class="text-center">Cart is empty</td>
            </c:if>
            <c:forEach var="cartEntry" items="${cart.cartEntries}">
                <form name="cartForm" class="update_product" action="/cart/product/update" method="post">
                    <tr>
                        <td data-th="Product">
                            <div class="row">
                                <div class="col-sm-2 hidden-xs"><img src="${cartEntry.product.imageUrl}" alt="..." class="img-responsive"/></div>
                                <div class="col-sm-10">
                                    <h4 class="nomargin">${cartEntry.product.name}</h4>
                                </div>
                            </div>
                        </td>
                        <td data-th="Price">
                            <fmt:formatNumber value="${cartEntry.product.price}" type="currency" currencyCode="${cartEntry.product.currency}"/>
                        </td>
                        <td data-th="Quantity">
                            <input name="quantity" value="${cartEntry.quantity}" type="number" min="1" max="100" class="form-control">
                            <input name="productId" value="${cartEntry.product.id}" type="number" hidden>
                        </td>
                        <td data-th="Subtotal" class="text-center">${cartEntry.formattedSubtotal}</td>
                        <td class="actions" data-th="">
                            <button type="submit" class="btn btn-info btn-sm"><i class="glyphicon glyphicon-refresh"></i></button>
                            <a href="/cart/product/${cartEntry.product.id}/delete" class="btn btn-danger btn-sm"><i class="glyphicon glyphicon-trash"></i></a>
                        </td>
                    </tr>
                </form>
            </c:forEach>
            </tbody>
            <tfoot>
            <c:if test="${not empty cart.cartEntries}">
                <tr>
                    <td colspan="3" class="hidden-xs"></td>
                    <td class="hidden-xs text-center"><strong>Total ${cart.formattedTotal}</strong></td>
                    <td class="hidden-xs"></td>
                </tr>
            </c:if>
            </tfoot>
        </table>

        <div class="row">
            <div class="col-xs-12 col-md-6">
                <a href="/" class="btn btn-warning"><i class="glyphicon glyphicon-chevron-left"></i> Continue Shopping</a>
            </div>
            <div class="col-xs-12 col-md-6">
                <c:if test="${not empty cart.cartEntries}">
                    <a href="/checkout" class="btn btn-success pull-right">Checkout <i class="glyphicon glyphicon-chevron-right"></i></a>
                </c:if>
            </div>
        </div>
    </jsp:body>
</layout:customerpage>
