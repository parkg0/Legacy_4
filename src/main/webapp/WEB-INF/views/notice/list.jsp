<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<h1>List Page</h1>



<table>
	<thead>	
		<tr>
			<th>글번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
		</tr>
	</thead>
	<c:forEach items="${list}" var="notice">
	<tbody>
		<tr>
			<td>${notice.num}</td>
			<td><a href="./detail?num=${notice.num}">${notice.title}</a></td>
			<td>${notice.writer}</td>
			<td>${notice.regDate}</td>
			<td>${notice.hit}</td>
		</tr>
	</tbody>
</c:forEach>
</table>
<a href="./add">글 작성</a>

</body>
</html>