<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>BankBook List Page</h1>

	<!-- bookname,bookrate,bookSale, -->
	<table>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>이자율</th>
			<th>판매</th>
		</tr>
		<c:forEach items="${list}" var="book">
			<tr>
				<td>${book.bookNumber}</td>
				<td><a href="./detail?bookNumber=${book.bookNumber}">${book.bookName}</a></td>
				<td>${book.bookRate}</td>
				<td>${book.bookSale}</td>
			</tr>
		</c:forEach>
	</table>

	<div>
	<c:if test="${pager.pre}">
		<a href="./list?page=${pager.startNum-1}">PREVIEW</a>
	</c:if>
		<!-- controller mv 에 pager  -->

		<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			<a href="./list?page=${i}">${i}</a>
		</c:forEach>

		<c:if test="${pager.next}">
			<a href="./list?page=${pager.lastNum+1}">NEXT</a>
		</c:if>
	</div>

	<a href="./add">ADD</a>
</body>
</html>