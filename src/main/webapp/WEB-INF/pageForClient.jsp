<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            width: 90%;
            border-color: darkslateblue;
        }

        label {
            font: caption;
            font-size: 20px;
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
<body bgcolor="#f0f8ff">
<h2 style="text-align: center">Menu</h2>
<form action="/pageForClient" METHOD="GET">
    <table align="center" bgcolor="aqua">
        <tr>
            <th>Title</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="menuList" items="${menuList}">
            <tr>
                <td>${menuList.titleProduct}</td>
                <td>${menuList.priceProduct}</td>
                <td><a href="addOrder/${menuList.idProduct}" METHOD="GET">Add this product in orders</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
<div style="text-align: center"><a href="<c:url value="/logout"/>">
    <button type="submit"><h3>Log out</h3></button>
</a></div>


</body>
</html>
