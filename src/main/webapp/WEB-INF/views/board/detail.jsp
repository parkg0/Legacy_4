<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<a href="./reply?num=${dto.num}">Reply</a>

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