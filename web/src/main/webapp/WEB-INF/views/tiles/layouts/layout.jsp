<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">
    <title><tiles:getAsString name="title" /></title>
     <link href="<c:url value='/static/css/app.css' />" rel="stylesheet">
</head>
<body>
<div class="flex-container">
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="menu" />
    <article class="article">
        <tiles:insertAttribute name="body" />
    </article>
    <tiles:insertAttribute name="footer" />
</div>
</body>
</html>
