<%@taglib prefix="t" tagdir="/WEB-INF/tags/layout" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@attribute name="title" type="java.lang.String" required="true" %>

<t:genericpage title="${title}">
    <jsp:attribute name="header">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                        <%--<a class="navbar-brand" href="#">Brand</a>--%>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav">

                        <li class="active"><a href="/admin">Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Customer <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/admin/customer">All Customers</a></li>
                                <li><a href="/admin/customer/add">Add Customer</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Cart<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/admin/cart">All Carts</a></li>
                                <li><a href="/admin/cart/add">Add Cart</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Product<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/admin/product">All Products</a></li>
                                <li><a href="/admin/product/add">Add Product</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Supplier<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/admin/supplier">All Suppliers</a></li>
                                <li><a href="/admin/supplier/add">Add Supplier</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Shipping<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/admin/shipping">All Shipping</a></li>
                                <li><a href="/admin/shipping/add">Add Shipping</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Category<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/admin/category">All Categories</a></li>
                                <li><a href="/admin/category/add">Add Category</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false">Country<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/admin/country">All Countries</a></li>
                                <li><a href="/admin/country/add">Add Country</a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                               aria-haspopup="true" aria-expanded="false"><security:authentication property="name"/> <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/logout">Logout</a></li>
                            </ul>
                        </li>
                    </ul>

                </div>
                <!-- /.navbar-collapse -->
            </div>   <!-- /.container-fluid -->
        </nav>
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody/>
    </jsp:body>
</t:genericpage>