<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
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
	<c:if test="${no==0 }">
		<h2>새글 등록</h2>
	</c:if>
	
	<c:if test="${no!=0 }">
		<h2>답글 등록</h2>
	</c:if>
	
	<hr>
	<form 
		action="insertBoard.do" 
		method="post"
		enctype="multipart/form-data">
		<div class="form-group">
		<input type="hidden" class="form-control" name="no" value="${no }">
		</div>
	<div class="form-group">
		<label for="titie">글제목 </label>
		<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력하세요.">
   	</div>
   	
	<div class="form-group">
        <label for="writer">작성자</label>
        <input type="text" class="form-control" id="writer" name="writer" placeholder="이름을 입력하세요">
      </div>
      
      <div class="form-group">
        <label for="pwd">패스워드</label>
        <input type="password" class="form-control" id="pwd" name="pwd" placeholder="암호를 입력하세요">
      </div>
      
      <div class="form-group">
        <label for="content">내용</label>
        <textarea class="form-control" id="content" name="content" rows="4"></textarea>
      </div>



		
	<div class="form-group">
	<label for ="file">파일</label>
	<input type="file" class="form-control" id ="uploadFile"name="uploadFile"><br>
	</div>
	<button type="submit" class="btn btn-primary">등록</button>
	<button type="reset" class="btn btn-danger">취소</button>	
	</form>
	</div>
</body>