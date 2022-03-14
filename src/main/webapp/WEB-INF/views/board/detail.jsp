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
<h1>${board} detail page</h1>

<a href="./update">수정</a>
<a href="./delete?num=${dto.num}">삭제</a>
<a href="./update?num=${dto.num}">update</a>
<!-- qna에만 보이도록  -->
<c:if test="${board ne 'notice'}">
<a href="./reply?num=${dto.num}">Reply</a>
<!--parameter : 부모에 대한 정보  -->
</c:if>
<div>
	<c:forEach items="${dto.fileDTOs}" var="f">
		<a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a>
	</c:forEach> 
</div>
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