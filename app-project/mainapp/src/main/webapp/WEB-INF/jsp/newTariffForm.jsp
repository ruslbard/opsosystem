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
<h1>Add new tariff form</h1>

<c:choose>
    <c:when test="${empty options}">
        <h3>No options found.</h3>
    </c:when>
    <c:otherwise>
    <h2>Options:</h2>
    <div class="scroll-table">
    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Add coast</th>
            <th>Active</th>
        </tr>
        <c:forEach var="option" items="${options}">
            <tr>
                <td>${option.name}</td>
                <td>${option.price}</td>
                <td>${option.add_coast}</td>
                <td>${option.active}</td>
            </tr>
        </c:forEach>
    </table>
    </div>
</c:otherwise>
</c:choose>
</body>
</html>