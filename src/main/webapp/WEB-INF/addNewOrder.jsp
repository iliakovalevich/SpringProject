<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
<body bgcolor="#f0e68c">


<form action="<c:url value="/add-new-order"/>" method="POST">
    <h2 style="text-align: center">Menu</h2>
    <table align="center" bgcolor="aqua">
        <tr>
            <th>Title</th>
            <th>Price</th>
            <th>Add Order</th>
        </tr>
        <c:forEach var="menu" items="${menuList}">
            <tr>
                <td>${menu.title}</td>
                <td>${menu.price}</td>
                <td><a href="/addMenu/${menu.id}">Add this item in order</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
<br>
<h2 style="color: crimson ; text-align: center">!You can make a special order that is not on the menu!</h2>
<div style="text-align: center"><form class="modal" action="<c:url value="/add-new-order"/>" method="POST">
    <label>Title</label>
    <input type="text" name="title">
    <label>Price</label>
    <input type="text" name="price">
    <input type="submit" value="Add new order">
</form>
</div>

<br>
<div style="text-align: center"><a href="<c:url value="/"/>"><button type="submit"><h3>Go home</h3></button></a></div><br>

</body>
</html>