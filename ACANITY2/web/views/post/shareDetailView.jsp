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
<input type="hidden" name="writer" value="<%= member.getmId() %>">
	<div id="write_box1">
		<div id="write_box1_sub1">
			<table id="write_table1" cellspacing="0" style="border-collapse : collapse;">
				<tr><th width="18%" style="border-top-width: 0;">제목</th>
					<td style="border-top-width: 0;">
					<%= post.getpTitle() %>
					</td></tr>
				<tr><th>작성자</th>
					<td><%= member.getmId() %>
					</td></tr>
				<tr height="149"><th>내용</th>
					<td>
					<%= post.getpContent() %>
					</td></tr>
			</table>
		</div>
		<div id="write_box1_sub2">
			<input type="file" name="uploadfile1" id="write_file1">
			<input type="file" name="uploadfile2" id="write_file1">
			<input type="file" name="uploadfile3" id="write_file1">
		</div>
	</div>
	<div id="write_box2">
<% if(member.getmId().equals(post.getpId())){ %>
		<input type="button" value="수정" onclick="check();" id="detail_button1" style="cursor: pointer">
		<input type="button" value="삭제" onclick="check();" id="detail_button1" style="cursor: pointer">
<% } %>
		<input type="button" value="목록" onclick="javascript:history.back();" id="detail_button1" style="cursor: pointer">
	</div>
</div>

</body>
</html>