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
		<form class="frm" ,action="./join" , method="post" id="frm">
		
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
				<button type="button" id="btn">JOIN</button>
			</fieldset>
			
			<script src="../resources/js/join2.js"></script>
	</form>
	</div>
</body>
</html>