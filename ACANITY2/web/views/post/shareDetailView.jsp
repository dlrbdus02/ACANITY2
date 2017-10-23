<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member, post.model.vo.Post, java.util.*" %>
<%
	Member member = (Member)session.getAttribute("member");
	int cno = Integer.parseInt(request.getParameter("cno"));
	Post post = (Post)request.getAttribute("post");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shareListView</title>
<link rel="stylesheet" href="/acanity/css/sharepost.css">
</head>
<body>
<div id="list_box1">
	<div id="list_box1_sub1">자료공유방</div>
	<div id="list_box1_sub2"><b><%= member.getmId() %></b>님 환영합니다.</div>
</div>

<div id="list_box2">
	<div id="write_box3">
		<span id="write_span1"><%= post.getpTitle() %></span>
		<a href="javascript:history.back();"><span id="write_span2">뒤로</span></a>
	</div>
<form name="form" action="../../spinsert?cno=<%=cno%>" method="post" enctype="multipart/form-data">
<input type="hidden" name="writer" value="<%= member.getmId() %>">
	<div id="write_box1">
		<div id="write_box1_sub1">
			<table id="write_table1" cellspacing="0" style="border-collapse : collapse;">
				<tr><th width="18%" style="border-top-width: 0;">제목</th>
					<td style="border-top-width: 0;">
					<input type="text" name="title" size="45" id="write_inputtitle" placeholder="제목을 입력해주세요.">
					</td></tr>
				<tr><th>작성자</th>
					<td><%= member.getmId() %>
					</td></tr>
				<tr height="149"><th>내용</th>
					<td>
					<textarea rows="8" cols="54" name="content" id="write_textarea" placeholder="내용을 입력해주세요."></textarea>
					</td></tr>
			</table>
		</div>
		<div id="write_box1_sub2_1">
		<span id="write_span3">
		<b>게시글 작성 시 주의사항</b><br>
		① 타인에 대한 비방이나 비속어는 자제해주세요.<br>
		② 불필요한 개인정보는 포함하지 말아주세요.<br>
		④ 불건전한 게시물은 관리자에 의해 무통보 삭제처리됩니다.<br>
		</span>
		</div>
		<div id="write_box1_sub2">
			<input type="file" name="uploadfile1" id="write_file1">
			<input type="file" name="uploadfile2" id="write_file1">
			<input type="file" name="uploadfile3" id="write_file1">
		</div>
		<div id="write_box1_sub2_2">
		<label for="pwd" id="write_label">비밀번호</label>
		<input type="password" name="pwd" id="write_inputpass" size="28" placeholder=" 게시글 수정 시 필요합니다.">
		</div>
	</div>
	<div id="write_box2">
		<input type="button" value="SUBMIT" onclick="check();" id="write_button1" style="cursor: pointer">
	</div>
</form>
</div>

</body>
</html>