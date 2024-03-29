<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가격별책 추천</title>
</head>
<body>
	<main>
		<form action="/selectPrice">
			<p>제목</p>
		
			<p>${book.bookTitle}</p>
			<span>지은이 : ${book.bookAuthor}</span>
			<span>${book.bookPrice}원</span>		
		</form>
	</main>
</body>
</html>