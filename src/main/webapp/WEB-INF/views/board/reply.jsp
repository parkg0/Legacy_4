<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${board} Reply page</h1>
	<form action="./reply" method="post">
		<input type="hidden" value="${dto.num}" name="num">
		작성자 <input type="text" name="writer">	
		제목 <input type="text" name="title">
		내용 <textarea rows="" cols="" type="text" name="contents"></textarea>
		<button type="submit">reply</button>
		
	</form>
</body>
</html>