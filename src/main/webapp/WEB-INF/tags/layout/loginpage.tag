<%@taglib prefix="t" tagdir="/WEB-INF/tags/layout" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@attribute name="title" type="java.lang.String" required="true" %>
<%@attribute name="js" fragment="true" %>
<%@attribute name="css" fragment="true" %>

<t:genericpage title="${title}">
    <jsp:attribute name="css">
        <link rel="stylesheet" href="/_ui/css/loginpage.css">
        <jsp:invoke fragment="css"/>
    </jsp:attribute>

    <jsp:attribute name="js">
        <jsp:invoke fragment="js"/>
    </jsp:attribute>

    <jsp:body>
        <div class="container">
            <jsp:doBody/>
        </div>
    </jsp:body>
</t:genericpage>