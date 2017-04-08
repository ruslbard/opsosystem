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
<h1>Welcome to Op!System</h1>

<c:choose>
    <c:when test="${empty tariffs}">
        <h3>No tariffs found!</h3>
    </c:when>
    <c:otherwise>
    <h2>Tariffs</h2>
    <div class="scroll-table">
    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <c:forEach var="tariff" items="${tariffs}">
            <tr>
                <td>${tariff.name}</td>
                <td>${tariff.price}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
</c:otherwise>
</c:choose>
</body>
</html>