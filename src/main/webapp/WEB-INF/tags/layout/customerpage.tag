<%@taglib prefix="t" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@attribute name="title" type="java.lang.String" required="true" %>
<%@attribute name="js" fragment="true" %>
<%@attribute name="css" fragment="true" %>

<t:genericpage title="${title}">

    <jsp:attribute name="css">
        <link rel="stylesheet" href="/_ui/css/common.css">
        <jsp:invoke fragment="css"/>
    </jsp:attribute>

    <jsp:attribute name="js">
        <security:authorize access="hasRole('CUSTOMER')">
            <script src="/_ui/js/cart-badge-update.js"></script>
        </security:authorize>
        <script src="/_ui/js/category-menu.js"></script>
        <jsp:invoke fragment="js"/>
    </jsp:attribute>

    <jsp:attribute name="header">
         <nav class="navbar navbar-default">
             <div class="container">
                 <!-- Brand and toggle get grouped for better mobile display -->
                 <div class="navbar-header">
                     <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                         <span class="sr-only">Toggle navigation</span>
                         <span class="icon-bar"></span>
                         <span class="icon-bar"></span>
                         <span class="icon-bar"></span>
                     </button>
                     <a class="navbar-brand" href="/">CoffeeTime</a>
                 </div>

                 <!-- Collect the nav links, forms, and other content for toggling -->
                 <div class="collapse navbar-collapse" id="navbar-collapse">
                     <ul id="category-menu" class="nav navbar-nav">
                         <%--<li><a href="/">Home</a></li>--%>
                     </ul>

                     <security:authorize access="hasRole('CUSTOMER')">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="/cart" style="height: 50px">
                                    <i class="fa fa-2x fa-shopping-cart"></i>
                                    <label id="cart-badge" class="badge badge-warning">4</label>
                                </a>
                            </li>
                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                                   aria-haspopup="true" aria-expanded="false">
                                    <security:authentication property="name"/>
                                    <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/profile">Profile</a></li>
                                    <li><a href="/order/history">Order History</a></li>
                                    <li><a href="/logout">Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </security:authorize>
                     <security:authorize access="hasRole('ANONYMOUS')">
                         <ul class="nav navbar-nav navbar-right">
                             <li><a href="/login" class="navbar-link">Sign In</a></li>
                         </ul>
                    </security:authorize>
                 </div>
                 <!-- /.navbar-collapse -->
             </div>   <!-- /.container-fluid -->
         </nav>
    </jsp:attribute>

    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <jsp:doBody/>
        </div>
    </jsp:body>
</t:genericpage>