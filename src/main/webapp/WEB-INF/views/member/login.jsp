<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login Page</h1>
	<div>
		<form action="./login" , method="post">
		
			<fieldset>
				<legend>아이디</legend>
				<input type="text" name="id" value="${cookie.remember.value}">
			</fieldset>

			<fieldset>
				<legend>비밀번호</legend>
				<input type="password" name="pw">
			</fieldset>
			
			<fieldset>
				<legend>Remember me</legend>
				<input type="checkbox" name="remember" value="1">
			</fieldset>
			
			<fieldset>
				<legend>Login</legend>	
				<button type="submit">LOGIN</button>
			</fieldset>
			
		</form>
	</div>
</body>
</html>