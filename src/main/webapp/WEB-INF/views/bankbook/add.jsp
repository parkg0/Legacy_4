<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>BankBook ADD Page</h1>

<form action="./add" method="post">
	BookName<input type="text" placeholder="통장이름" name="bookName">
	BookRate<input type="text" placeholder="" name="bookRate">
	BookContents<textarea name="bookContents" rows="10" cols="10"></textarea>
	BookSale
	<div>
		판매<input type="radio" name="bookSale" value="1"> 판매중지<input type="radio" name="bookSale" value="0">
	</div>
	
	<div>
	checkbox
	<input type="checkbox">
	<input type="checkbox">
	<input type="checkbox">
	</div>
	
	<input type="submit" value="ADD">
	<button type="submit">ADD</button>
</form>
</body>
</html>