<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<layout:customerpage title="Home">
     <jsp:attribute name="css">
         <link rel="stylesheet" href="/_ui/css/product.css"/>
    </jsp:attribute>

    <jsp:attribute name="js">
        <script src="/_ui/js/product.js"></script>
    </jsp:attribute>

    <jsp:body>
        <div id="add-to-cart-alert" class="alert alert-success" role="alert" style="display: none">Product was successfully added to cart</div>

        <div id="products" class="row list-group">
            <c:forEach var="product" items="${products}">
                <div class="item  col-xs-4 col-lg-4">
                    <div class="thumbnail">
                        <img class="group list-group-image" src="${product.imageUrl}" alt=""/>
                        <div class="caption">
                            <h4 class="group inner list-group-item-heading">${product.name}</h4>
                            <p class="group inner list-group-item-text">${product.description}</p>
                            <div class="row">
                                <div class="col-xs-12 col-md-6">
                                    <p class="lead"><fmt:formatNumber value="${product.price}" type="currency" currencyCode="${product.currency}"/></p>
                                </div>
                            </div>
                            <security:authorize access="hasRole('CUSTOMER')">
                                <div class="row">
                                    <form name="cartForm" class="add_to_cart" action="/cart/product/add" method="post">
                                        <div class="col-xs-12 col-md-6">
                                            <input name="quantity" type="text">
                                            <input name="productId" value="${product.id}" type="number" hidden>
                                        </div>
                                        <div class="col-xs-12 col-md-6">
                                            <input type="submit" value="Add To Cart" class="btn btn-success" style="width: 100%">
                                        </div>
                                    </form>
                                </div>
                            </security:authorize>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </jsp:body>
</layout:customerpage>
