<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/detail.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<div class="detail">
	<h1>Detail Page</h1>
	<h3>Name : ${dto.bookName}</h3>
	<h3>Contents : ${dto.bookContents}</h3>


	<a href="./list">List</a>

	<a href="./update?bookNumber=${dto.bookNumber}">Update</a>

	<a href="./delete?bookNumber=${dto.bookNumber}">Delete</a>
	</div>
</body>
</html>