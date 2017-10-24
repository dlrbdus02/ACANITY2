<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member, post.model.vo.Post, java.util.*" %>
<%
	Member member = (Member)session.getAttribute("member");
	int cno = Integer.parseInt(request.getParameter("cno"));
	Post post = (Post)request.getAttribute("post");

	String[] filenames = null;
	if (post.getOriginalFileName() != null){
		filenames = post.getOriginalFileName().split(",");
	}
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
	<div id="detail_box1">
			<table id="detail_table1" cellspacing="0" style="border-collapse : collapse;">
				<tr><th width="14%" style="border-top-width: 0;">제목</th>
					<td width="57%" style="border-top-width: 0;"><%= post.getpTitle() %></td>
						<th width="14%" style="border-top-width: 0;">작성일</th>
						<td width="15%" style="border-top-width: 0; border-right-width: 0;"><%= post.getpDate() %></td></tr>
				<tr><th>작성자</th>
					<td><%= member.getmId() %></td>
					<th>조회수</th><td style="border-right-width: 0;"><%= post.getReadCount() %></td></tr>
				<tr height="212"><th>내용</th>
					<td>
						<div id="detail_box3">
							<%= post.getpContent() %>
						</div>
					</td>
					<td colspan="2" style="border-right-width: 0; vertical-align: top;">
						<div id="detail_box2">
							<% if (post.getOriginalFileName() != null){
								for(int i = 0; i < filenames.length; i++){ %>
									<input type="checkbox">
									<span id="detail_span1"><%= filenames[i] %></span><br>
							<% 	} %>
									<button id="detail_button2">선택한 파일 저장하기</button>
									<button id="detail_button2">모든 파일 저장하기</button>
							<% }else{	//파일이 없다면 %>
									<span id="detail_span2">첨부파일이 없습니다.</span>	
							<%	} %>
						</div>
					</td>
				</tr>
			</table>
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