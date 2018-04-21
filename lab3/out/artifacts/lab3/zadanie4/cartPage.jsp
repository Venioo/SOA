<%@ page import="zadanie4.Cart" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<%@include file="menu.html" %>
<h1>Koszyk</h1>
<c:import var="partsInfo" url="http://localhost:8080/lab3/zadanie4/data.xml"/>
<x:parse xml="${partsInfo}" var="item"/>
<table>
    <%
        session = request.getSession(false);
        Cart shoppingCart = (Cart) session.getAttribute("cart");
        if (shoppingCart == null || shoppingCart.getCartItems().isEmpty()) {%>
            <p>Koszyk jest pusty!</p>
    <% } else {%>
    <tr>
        <th>Nazwa</th>
        <th>Cena</th>
        <th>Sztuk</th>
    </tr>
    <%
        for (Object key : shoppingCart.getCartItems().keySet()) {
            request.setAttribute("key", key);
    %>
    <tr>
        <td><x:out select="$item/computer_parts/part[$key]/name"/></td>
        <td><x:out select="$item/computer_parts/part[$key]/price"/></td>
        <td><%=shoppingCart.getQuantity((Integer) key)%>
        </td>
        <form method="POST" action="http://localhost:8080/lab3/cart">
            <input type="hidden" name="itemId" value=<x:out select="$item/computer_parts/part[$key]/id"/>>
            <td><input type="submit" name="action" value="+"></td>
            <td><input type="submit" name="action" value="-"></td>
            <td><input type="submit" name="action" value="X"></td>
        </form>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>