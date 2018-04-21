<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zadanie 5</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1>Lista filmów</h1>
<table>
    <tr>
        <th>Tytuł</th>
        <th>Gatunek</th>
        <th>Rok</th>
        <th>Dochód</th>
    </tr>
    <c:forEach items="${films}" var="film">
        <tr>
            <td>${film.title}</td>
            <c:choose>
                <c:when test = "${film.genre == 'wojenny'}">
                    <td bgcolor="#00ccff">${film.genre}</td>
                </c:when>
                <c:otherwise>
                        <td>${film.genre}</td>
                </c:otherwise>
            </c:choose>
            <td>${film.year}</td>
            <td><fmt:setLocale value="en_US"/>
                <fmt:formatNumber value="${film.revenue}" type="currency"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
