<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<body>
		
	<main>
						
		<h1>${sessionScope.loginMember.memberName}의 구매 리스트</h1>
			<table>
				<c:forEach var="order" items="${orderList}">
					<tr>
						<td>${order.memberName}</td>
						<td>${order.bookTitle}</td>
						<td>${order.address}</td>
						<td>${order.orderDate}</td>
						<td>${order.quantity}</td>
						<td>${order.status}</td>
						<td>${order.price}</td>
						<td><a class="update-btn">수정</a></td>
						<td><a href="/delete?memberNo=${order.memberNo}" class="delete-btn" 
						onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
					
	
	
		<c:if test="${not empty sessionScope.message}">
		
			<script>
			// EL/JSTL 구문이 자바스크립트보다 먼저 해석되는데
			// 문자열이 들어가있는 데이터의 경우 
			// 따옴표가 없는 상태이니 붙여줘야한다.
			
				alert('${message}');
			</script>
			
			
			 <c:remove var="message" scope="session"/>	
		</c:if>
	</main>
</body>
</html>