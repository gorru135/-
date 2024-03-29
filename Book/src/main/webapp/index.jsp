<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<link rel ="stylesheet" href="/resources/css/main.css">
	
	<title>Book</title>
</head>
<body>
	<main>
		<!-- 로그인 -->
		<c:choose>
		
			<%-- 로그인을 하지 않았다면 : 로그인 /회원가입 입력 폼 출력--%>
			<c:when test="${empty sessionScope.loginMember}">
			
				<h1>Book 로그인</h1>
				
				<form action="/login" method="post" class="login-form">
					<div>
						<p>아이디</p>
						<input type="text" name="inputId" autocomplete="off">
					</div>
					<div>
						<p>패스워드</p>
						<input type="password" name="inputPw">
					</div>
					
					<button>로그인</button>
					
					<a href="/signup" class="signup">회원가입</a>
				</form>
			</c:when>
			
			<c:otherwise>
				<div>
				${sessionScope.loginMember.memberName}님 환영합니다.
				<a href="/purchaseList" class="purchase-btn">구매목록</a>
				<a href="/logout" class="logout-btn">로그아웃</a>
				
				</div>

				<table>
					<tr>
						<th>타이틀</th>
						<th>저자</th>
						<th>출판사</th>
						<th>가격</th>
					</tr>
					<c:forEach var="book" items="${bookList}">
						<tr>
							
							<td>${book.bookTitle}</td>						
							<td>${book.bookAuthor}</td>
							<td>${book.publisher}</td>
							<td>${book.bookPrice}</td>
					
							
							<form action="/purchase" method="get">
								<td> 
									<input type="number" class="quantity" name="quantity" value="0">
									수량
									<input type="hidden" name="bookNo" value="${book.bookNo}">
									
								</td>
								<td>
									<button>구매</button>
								</td>
							</form>						
						</tr>
					</c:forEach>
						
				</table>
				
					<div>
					<table>
						<tr>
							<th>책 추천</th>
						</tr>
						<tr>
							<td><a href="/selectBest">이달의 책 추천</a></td>
							<td><a href="/selectSale">판매량 책 추천</a></td>
							
							
						</tr>
					</table>
				</div>
		
			</c:otherwise>
	
		
		</c:choose>
		
	
	</main>	
	
	<c:if test="${not empty sessionScope.message}">
		
		<script>
			alert('${message}');
		</script>
		
		<c:remove var="message" scope="session" />
	</c:if>
	
	
<script src="/resources/js/mainIndex.js"></script>
</body>
</html>