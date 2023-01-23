<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!--<style><%@include file="/style.css"%></style>  -->

<body>
	<div class="header">
    <h1>MY WEBSITE</h1>
    <p>Logo shoud be insert here</P>

</div>
<div class="topnav">
    <a href="#">Home</a>
    <a href="#">Products</a>
    <a href="#">About us</a>
     <a href="<%=response.encodeURL(request.getContextPath()+"/login.jsp") %>" style="float: right">Login</a>
    <input style="float: right" type="text" placeholder="Search..">
</div>
</body>
</html>