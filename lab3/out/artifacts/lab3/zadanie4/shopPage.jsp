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
<%@include  file="menu.html" %>
<h1>Lista produktów:</h1>
<c:import var="partsInfo" url="http://localhost:8080/lab3/zadanie4/data.xml"/>
<x:parse xml="${partsInfo}" var="output"/>
<table>
    <tr>
        <th>Nazwa</th>
        <th>Cena</th>
    </tr>
    <x:forEach select="$output/computer_parts/part" var="item">
        <form method="POST" action="http://localhost:8080/lab3/cart">
            <tr>
                <td><x:out select="$item/name"/></td>
                <td><x:out select="$item/price"/></td>
                <input type="hidden" name="itemId" value=<x:out select="$item/id"/>>
                <td><input type="submit" value="Dodaj do koszyka"></td>
            </tr>
        </form>
    </x:forEach>
</table>
</body>
</html>