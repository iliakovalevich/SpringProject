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
<div style="text-align: center"><a href="<c:url value="/"/>">
    <h3>Go home</h3>
</a></div>
<form action="/pageForAdmin" METHOD="GET">
    <h2 style="text-align: center">Menu</h2>
    <table align="center" bgcolor="aqua">
        <tr>
            <th>Title</th>
            <th>Price</th>
            <th>Id product</th>
            <th>Action</th>
        </tr>
        <c:forEach var="menuList" items="${menuList}">
            <tr>
                <td>${menuList.titleProduct}</td>
                <td>${menuList.priceProduct}</td>
                <td>${menuList.idProduct}</td>
                <td><a href="deleteProduct/${menuList.idProduct}" METHOD="GET">Delete product</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
<br>
<br>
<h3 style="text-align: center">Update product in menu</h3>
<div style="text-align: center">
    <form class="modal" action="<c:url value="/updateProduct"/>" method="POST">
        <label>id</label>
        <input type="text" name="idProduct">
        <br><br>
        <label>Title</label>
        <input type="text" name="title">
        <br><br>
        <label>Price</label>
        <input type="text" name="price">
        <br><br>
        <input type="submit" value="Add new order">
    </form>
</div>
<br>
<br>
<h3 style="text-align: center">Add product in menu</h3>
<div style="text-align: center">
    <form class="modal" action="<c:url value="/addNewProduct"/>" method="POST">
        <label>Title</label>
        <input type="text" name="title">
        <br><br>
        <label>Price</label>
        <input type="text" name="price">
        <br><br>
        <input type="submit" value="Add new product">
    </form>
</div>

<br>
<h2 style="text-align: center">Orders</h2>
<table align="center" bgcolor="aqua">
    <tr>
        <th>Title</th>
        <th>Price</th>
        <th>Order number</th>
        <th>Action</th>
    </tr>
    <c:forEach var="orderList" items="${orderList}">
        <tr>
            <td>${orderList.titleOrder}</td>
            <td>${orderList.priceOrder}</td>
            <td>${orderList.idOrder}</td>
            <td><a href="orderIsComplete/${orderList.idOrder}" method="POST">Order is ready</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<div style="text-align: center"><a href="<c:url value="/"/>">
    <button type="submit"><h3>Go home</h3></button>
</a></div>


</body>
</html>
