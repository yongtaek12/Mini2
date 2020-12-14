<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
	<h2>게시물 삭제</h2>
	<hr>
	<form 
		action="deleteBoard.do" 
		method="post">
		<div class="form-group">
		<input type="hidden" class="form-control" name="no" value="${no }">
		</div>
		<label for="no">글번호 : ${no } </label><br>
		
     <div class="form-group">
        <label for="pwd">패스워드</label>
        <input type="password" class="form-control" id="pwd" name="pwd" placeholder="암호를 입력하세요">
      </div>
	<button type="submit" class="btn btn-danger">삭제</button>
	<button type="reset" class="btn btn-success">취소</button>	
	</form>
	</div>
</body>











</html>