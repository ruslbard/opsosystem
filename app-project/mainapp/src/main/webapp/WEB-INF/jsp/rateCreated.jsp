<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Spittr</title>
<link rel="stylesheet"
type="text/css"
href="<c:url value="/resources/style.css" />" >
</head>
<body>
<h1>Creating new tariff</h1>

<c:choose>
    <c:when test="${empty newtariff}">
        <h3>Tariff not created</h3>
    </c:when>
    <c:otherwise>
    <h2>Tariff created successfully</h2>
        <h3>Name: ${newtariff.name}<h3>
        <h3>Price: ${newtariff.price}<h3>
    </div>
</c:otherwise>
</c:choose>
</body>
</html>