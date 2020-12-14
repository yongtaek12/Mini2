<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>미니 게시판</title>
<!-- 제이쿼리 -->
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<!-- 합쳐지고 최소화된 css -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"> </script>
</head>
<body>
<div class="container">
	<h2>미니 게시판</h2>
	<hr>
	<h3> ${name } 님 ! 게시판에 오신걸 환영합니다 <a href="logout.do">로그아웃</a></h3>
	<a href="insertBoard.do">게시물 등록</a><br>
	<table class="table table-hover">
	<thead>
		<tr><th>번호</th><th>제목</th>	<th>작성자</th></tr>		
	</thead>

		
		<c:forEach var="b" items="${list }">
			<tr>
				<td>${b.no }</td>
				<td>
						
				
					<a href="detailBoard.do?no=${b.no }">${b.title }</a>
				</td>
				<td>${b.writer }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	</div>

</body>
</html>