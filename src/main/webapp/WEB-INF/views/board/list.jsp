<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link rel="stylesheet" href="../resources/css/table.css">
<link rel="stylesheet" href="../resources/css/list.css">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<h1>${board} List Page</h1>
<h4><a href="./add">글 작성</a></h4>
		<!--검색창-->
	<div>
		<form action="./list" method="get">
			<fieldset>
				<select name="kind">
					<option value="col1">제목</option>
					<option value="col2">본문</option>
					<option value="col3">작성자</option>
				</select> 
				<input type="text" name="search" value=${pager.search}>
				<button type="submit">검색</button>
			</fieldset>	
		</form>

	</div>
<table>
	<thead>	
		<tr>
			<td>글번호</td><td>제목</td><td>작성자</td><td>작성일</td><td>조회수</td>
		</tr>
	</thead>
	<c:forEach items="${list}" var="dto">
	<tbody>
		<tr>
			<td>${dto.num}</td>
			<td>
			<a href="./detail?num=${dto.num}">
			<c:catch var="message">
			<c:forEach begin="1" end="${dto.depth}">&nbsp;</c:forEach> 
			</c:catch>
			${dto.title}</a></td>
		
			<td>${dto.writer}</td>
			<td>${dto.regDate}</td>
			<td>${dto.hit}</td>
		</tr>
	</tbody>
</c:forEach>
</table>



		<div>
			<c:if test="${pager.pre}">
				<a href="./list?page=${pager.startNum-1}">PREVIEW</a>
			</c:if>
				<!-- controller mv 에 pager  -->

				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<a href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a>
				</c:forEach>

				<c:if test="${pager.next}">
					<a href="./list?page=${pager.lastNum+1}">NEXT</a>
				</c:if>
		</div>


</body>
</html>