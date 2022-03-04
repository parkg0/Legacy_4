<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ADD page</h1>
	<form action="./add" method="post" id="frm">
		작성자 <input type="text" name="writer" id="writer">	
		제목 <input type="text" name="title" id="title">
		내용 <textarea rows="" cols="" type="text" name="contents"></textarea>
		<input type="button" value="저장" id="btn">
	</form>

	<script src="../resources/js/noticeAdd.js"></script>
</body>
</html>