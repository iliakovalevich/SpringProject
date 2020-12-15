<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
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
<h2 style="text-align: center">Log In</h2>
<div style="text-align: center">
    <form class="modal" action="<c:url value="/login"/>" method="POST">
        <label>Login</label>
        <input type="text" name="login">
        <br><br>
        <label>Password</label>
        <input type="text" name="password">
        <br><br>
        <input type="submit" value="Log in">
        <br><br>
    </form>
</div>
<br><br>
<h2 style="text-align: center">Registration for clients</h2>
<div style="text-align: center">
    <form class="modal" action="<c:url value="/registration"/>" method="POST">
        <label>Login</label>
        <input type="text" name="login">
        <br><br>
        <label>Password</label>
        <input type="text" name="password">
        <br><br>
        <label>Address</label>
        <input type="text" name="address">
        <br><br>
        <input type="submit" value="Registration">
    </form>
</div>


</body>
</html>
