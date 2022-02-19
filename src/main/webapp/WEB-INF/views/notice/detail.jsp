<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table>
	<thead>
		<tr>
			<td>글번호</td><td>제목</td><td>내용</td><td>작성자</td><td>작성일</td><td>조회수</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${noticeDTO.num}</td>
			<td>${noticeDTO.title}</td>
			<td>${noticeDTO.contents}</td>
			<td>${noticeDTO.writer}</td>
			<td>${noticeDTO.regDate}</td>
			<td>${noticeDTO.hit}</td>
			
		</tr>
	</tbody>
</table>
</body>
</html>