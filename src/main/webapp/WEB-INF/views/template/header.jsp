<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--header 시작 -->
<header class="header">
	<nav class="nav_main">
		<ul>
			<!-- <a>메서드 형식 : GET -->
			<li><a href="/s1">HOME</a></li>
			<li><a href="/s1/notice/list">Notice</a></li>
			<li><a href="/s1/qna/list">QnA</a></li>
			<li><a href="/s1/bankbook/list">Product</a></li>
		</ul>
	</nav>

	<nav class="nav_sub">
		<ul>
			<c:choose>
				<c:when test="${not empty member}">
					<li><a href="/s1/member/mypage">마이페이지</a></li>
					<li><a href="/s1/member/logout">로그아웃</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/s1/member/login">로그인<span 
							class="material-icons icon"> login </span></a></li>
					<li><a href="/s1/member/joinCheck">회원가입<span
							class="material-icons icon"> perm_identity </span></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</header>
<!--header 끝 -->