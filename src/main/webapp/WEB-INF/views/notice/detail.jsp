<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<c:import url="../template/header_css.jsp"></c:import>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<a href="./update?num=${dto.num}">update</a>
<table>
	<thead>
		<tr>
			<td>글번호</td><td>제목</td><td>내용</td><td>작성자</td><td>작성일</td><td>조회수</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${dto.num}</td>
			<td>${dto.title}</td>
			<td>${dto.contents}</td>
			<td>${dto.writer}</td>
			<td>${dto.regDate}</td>
			<td>${dto.hit}</td>
			
		</tr>
	</tbody>
</table>
</body>
</html>