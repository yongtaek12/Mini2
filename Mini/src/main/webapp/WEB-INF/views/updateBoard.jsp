<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<h2>게시물 수정</h2>
	<hr>
	<form 
		action="updateBoard.do" 
		method="post"
		enctype="multipart/form-data">
		<div class="form-group">
		<input type="hidden" class="form-control" name="no" value="${b.no }">
		</div>
		<div class="form-group">
		<label for ="title">글제목</label>
		<input type="text" class="form-control" id="title" name="title" value="${b.title }">
		</div>
		<div class="form-group">
		<label for ="writer">작성자</label>
		<input type="text" class="form-control" id="writer" name="writer" value="${b.writer }"readonly="readonly">
		</div>
     	<div class="form-group">
        <label for="pwd">패스워드</label>
        <input type="password" class="form-control" id="pwd" name="pwd">
      </div>
      <div class="form-group">
        <label for="content">내용</label>
        <textarea class="form-control" id="content" name="content" rows="4">${b.content }</textarea>
      </div>
		<div class="form-group">
		<label for="file">파일</label>
		: ${b.fname }(${b.fsize }bytes)
		</div>
		
		<div class="form-group">
		<input type="text" class="form-control" id="fname" name="fname"value="${b.fname }">
		</div>
		<div class="form-group">
		<input type="text" class="form-control" id="fsize" name="fsize"value="${b.fsize }">
		</div>
		<div class="form-group">
		<input type="file" class="form-control" id="uploadFile" name="uploadFile">
		</div>
	<button type="submit" class="btn btn-primary">수정</button>
	<button type="reset" class="btn btn-danger">취소</button>	

	</form>
	</div>
</body>











</html>