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
	<h2>게시물 상세</h2>
	<hr>
	<div class="form-group">
		<label for = "no" class="control-label">글번호 </label>
		<input type="text" id="no" class="form-control" value="${b.no }" readonly="readonly">
	</div>
	
	
	<div class="form-group">
		<label for = "title" class="control-label">글제목 </label>
		<input type="text" id="title" class="form-control" value="${b.title }" readonly="readonly">	
	</div>
	<div class="form-group">
		<label for = "writer" class="control-label">작성자 </label>
		<input type="text" id="title" class="form-control" value="${b.writer }" readonly="readonly">	
	</div>
	<div class="form-group">
		<label for = "content" class="control-label">글내용 </label>
		<input type="text" id="title" class="form-control" value="${b.content }" readonly="readonly">	
	</div>
	<div class="form-group">
		<label class="control-label">작성 날짜</label>
		<span>"${b.regdate }"</span>
	</div>
	<div class="form-group">
		<label class="control-label">조회수</label>
		<span>"${b.hit }"</span>
	</div>
		<div class="form-group">
		<label class="control-label">Ip주소</label>
		<span>"${b.ip }"</span>
	</div>
	
	<div class="form-group">
		<label class="control-label">첨부파일</label>
		<span><a href="board_upload/${b.fname }">${b.fname }</a></span>
	</div>
	<hr>
	<div class="form-group">
	<button type="button" id="list_btn" class="btn btn-primary" onclick="location.href='updateBoard.do?no=${b.no }'">수정</button>
	<button type="button" id="list_btn" class="btn btn-success" onclick="location.href='deleteBoard.do?no=${b.no }'">삭제</button>
	<button type="button" id="list_btn" class="btn btn-warning" onclick="location.href='insertBoard.do?no=${b.no }'">답글</button>
	<button type="button" id="list_btn" class="btn btn-info" onclick="location.href='listBoard.do'">목록</button>

	</div>
	</div> 
</body>
</html>
