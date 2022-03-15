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
	<form action="./add" method="post" enctype="multipart/form-data">
		작성자 <input type="text" name="writer">	
		제목 <input type="text" name="title">
		내용 <textarea rows="" cols="" type="text" name="contents"></textarea>
		<div>
			<input type="file" name="files">
			<input type="file" name="files">
			<input type="file" name="files">
		</div>
		
		
		<button type="submit">add</button>
	</form>

	 <script src="../resources/js/noticeAdd.js"></script> 
</body>
</html> 