<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<c:import url="../template/header_css.jsp"></c:import>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<h1>MyPage</h1>


<h3>${dto.id}</h3>
<h3>${dto.name}</h3>
<h3>${dto.phone}</h3>
<h3>${dto.email}</h3>

<a href="./update">수정하기</a>
</body>
</html>