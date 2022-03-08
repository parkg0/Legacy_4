<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${board} ADD page</h1>
	<form action="./add" method="post">
		작성자 <input type="text" name="writer">	
		제목 <input type="text" name="title">
		내용 <textarea rows="" cols="" type="text" name="contents"></textarea>
		<input type="submit" value="저장">
	</form>
</body>
</html>