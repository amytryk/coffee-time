<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="js" fragment="true" %>
<%@attribute name="css" fragment="true" %>
<%@attribute name="title" type="java.lang.String" required="true" %>
<html>
<head>
    <title>${title}</title>
    <link rel="stylesheet" href="/_ui/css/bootstrap.css">
    <link rel="stylesheet" href="/_ui/css/jquery.bootstrap-touchspin.min.css">
    <link rel="stylesheet" href="/_ui/css/font-awesome.min.css">
    <jsp:invoke fragment="css"/>
</head>
<body>
<div id="pageheader">
    <jsp:invoke fragment="header"/>
</div>
<div id="body">
    <jsp:doBody/>
</div>
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
</div>
<script src="/_ui/js/jquery-3.1.1.min.js"></script>
<script src="/_ui/js/jquery-ui.min.js"></script>
<script src="/_ui/js/bootstrap.js"></script>
<script src="/_ui/js/jquery.bootstrap-touchspin.min.js"></script>
<jsp:invoke fragment="js"/>
</body>
</html>