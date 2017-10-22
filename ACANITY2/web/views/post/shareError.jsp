<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shareError</title>
<link rel="stylesheet" href="/acanity/css/sharepost.css">
</head>
<body>
<div id="list_box1">
	<div id="list_box1_sub1">ERROR PAGE</div>
</div>

<div id="list_box2">
		<span id="error_span1">자료공유게시판 서비스 에러</span>
		<br>
		<span id="error_span2"> <%= request.getAttribute("message") %></span>
	<div id="error_box1">
		<br>
		<button id="error_button1" onclick="javascript:history.back();" style="cursor: pointer">이전 페이지로</button>
	</div>
</div>

</body>
</html>