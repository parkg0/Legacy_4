<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<h1>Notice Update Page </h1>

<form action="./update" method="post">
<input type ="hidden" name="num" value="${dto.num}">
	title <input type="text" name="title" value="${dto.title}">
	contents <textarea rows="" cols="" name="contents">${dto.contents}</textarea>
	writer <input type="text" name="writer" value="${dto.writer}">
	
	<input type="submit" value="ADD">
	
</form>


</body>
</html>