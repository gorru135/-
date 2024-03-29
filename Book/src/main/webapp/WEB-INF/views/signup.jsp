<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
</head>
<body>
	<main>
		<h1>회원가입</h1>
		
		<form action="/signup" method="post" class="signup-form" onsubmit="return validate()">
			
			<p>이름</p>
			<input type="text" name="inputName" id="inputName" autocomplete="off" required>
			
			<p>아이디</p>
			<input type="text" name="inputId" id="inputId" autocomplete="off" required>
			<span id="idMsg">영어 대/소문자, 숫자 6~14글자</span>
			
			<p>비밀번호</p>
			<input type="password" name="inputpw" id="inputPw" required>
		
			<p>비밀번호 확인</p>
			<input type="password" name="inputpw2" id="inputPw2" required>
			<span id="pwMessage"></span>	
			
			<p>성별</p>
			
			<label>
			남
			<input type="radio" name="gender" value="남" id="malegender">
			</label>
			<label>
			여
			<input type="radio" name="gender" value="여" id="femalegender">
			</label>
			<p>주소지</p>
			<input type="text" name="address"id="address" autocomplete="off" required>
			
			<button>가입하기</button>
		</form>
	</main>
	
	<script src="/resources/js/signup.js"></script>
</body>
</html>