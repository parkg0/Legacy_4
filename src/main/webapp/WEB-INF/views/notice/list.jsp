<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>List Page</h1>
<h4><a href="./add">글 작성</a></h4>
<table>
	<thead>	
		<tr>
			<td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td><td>조회수</td>
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


</body>
</html>