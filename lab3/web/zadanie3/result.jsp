<%--
  Created by IntelliJ IDEA.
  User: Tomek
  Date: 21.03.2018
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Zadanie 3</title>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.result == 1}">
        <%@include file="getNumberForm.html" %>
        Twoja liczba ${sessionScope.playerNumber} jest wieksza niz zagadka.
    </c:when>
    <c:when test="${sessionScope.result == -1}">
        <%@include file="getNumberForm.html" %>
        Twoja liczba ${sessionScope.playerNumber} jest mniejsza niz zagadka.
    </c:when>
    <c:when test="${sessionScope.result == 0}">
        <%@include file="getNumberFormDisabled.html" %>
        Brawo, zgadles po ${sessionScope.counter} probach. Sprobuj
        <a href="/lab3/zadanie3/getNumberForm.html">raz jeszcze.</a>
        <% session.setAttribute("startNewGame", true);%>
    </c:when>
</c:choose>
<!-- Proba: ${sessionScope.counter}.-->
</body>
</html>