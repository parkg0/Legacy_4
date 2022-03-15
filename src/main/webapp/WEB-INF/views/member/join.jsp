<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join page</h1>
	
		<div>
		<form action="./join"  method="post" id="frm" enctype="multipart/form-data">
			<fieldset>
				<legend>아이디</legend>
				<input type="text" name="id" id="id1">
				<div id="idResult"></div>
			</fieldset>

			<fieldset>
				<legend>비밀번호</legend>
				<input type="password" id="pw" name="pw" placeholder="8자 이상 12자 이하">
				<div id="pwResult"></div>
			</fieldset>

			<fieldset>
				<legend>비밀번호 확인</legend>	
				<input type="password" id="pw2" name="pw2" placeholder="8자 이상 12자 이하">
				<div id="pwResult2"></div>
			</fieldset>


			<fieldset>
				<legend>이름</legend>
				<input type="text" name="name" id="name">
			</fieldset>

			<fieldset>
				<legend>전화번호</legend>
				<input type="text" name="phone" id="phone">
			</fieldset>

			<fieldset>
				<legend>이메일</legend>
				<input type="text" name="email" id="email">
			</fieldset>

			<fieldset>
				<legend>Photo</legend>
				<input type="file" name="photo" id="photo">
			</fieldset>

			<fieldset>
			<button type="submit" id="btn">JOIN</button> 
			<!-- 최종완성시 주석해제, 스크립트도 주석해제하기  -->
				<!-- <button type="button" id="btn">JOIN</button> -->
			</fieldset>
	</form>
	</div>
			<!-- <script type="text/javascript" src="../resources/js/join2.js"></script> -->
</body>
</html>