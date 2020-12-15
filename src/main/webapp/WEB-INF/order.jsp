<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <style>
        table {
            align-content: center;
            bgcolor: aqua;
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 80%;
            border-color: darkslateblue;
        }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>

<body style="background-color:aliceblue">
<%--<div style="text-align: left"><a href="<c:url value="/add-new-order"/>"><button type="submit"><h3>Add new order</h3></button></a></div><br>--%>
<%--<br>--%>
<h1 style="text-align: center">PIZZERIA</h1>
<div style="text-align: center"><a href="<c:url value="/loginPage"/>"><button type="submit"><h3>Log in</h3></button></a></div><br>
<br>
<form action="<c:url value="/"/>" method="POST">
    <h2 style="text-align: center">Menu</h2>
    <table align="center" bgcolor="aqua">
        <tr>
            <th>Title</th>
            <th>Price</th>
        </tr>
        <c:forEach var="menuList" items="${menuList}">
            <tr>
                <td>${menuList.titleProduct}</td>
                <td>${menuList.priceProduct}</td>
            </tr>
        </c:forEach>
    </table>
</form>

<br>

</body>
</html>