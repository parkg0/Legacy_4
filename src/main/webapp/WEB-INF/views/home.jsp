<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/header_css.jsp"></c:import>
<style type="text/css">
.jjang{
width:30%;
margin :0 auto;
}
</style>
</script>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	<h1>Home</h1>

	<h3>${member.name}님
		환영합니다. <span class="material-icons-outlined"> account_circle </span>
	</h3>
<div class="jjang">
<img alt="" src="./resources/images/cutejjang.jpg">
</div>
	<div>
		<c:if test="${not empty member}">
			<a href="./member/mypage">MyPage</a>
			<a href="./member/logout">LogOut</a>
		</c:if>
		<c:if test="${empty member}">
			<a href="./member/login">Login</a>
			<a href="./member/join">Join</a>
		</c:if>
	</div>
<img alt="" src="./resources/upload/member/e4bbb0ac-87d2-42e4-9050-3afcf2396a07_cutejjang.jpg">
</body>
</html>