<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member, post.model.vo.Post, java.util.*" %>
<%
	Member member = (Member)session.getAttribute("member");
	int cno = Integer.parseInt(request.getParameter("cno"));
	ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("list");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shareListView</title>
<link rel="stylesheet" href="/acanity/css/sharepost.css">
<script type="text/javascript">
	function postWrite(){
		location.href = "/acanity/views/post/shareWriteForm.jsp?cno=<%=cno%>";
	}
</script>
</head>
<body>
<div id="list_box1">
	<div id="list_box1_sub1">자료공유방</div>
	<div id="list_box1_sub2"><b><%= member.getmId() %></b>님 환영합니다.</div>
</div>

<div id="list_box2">
	<div id="list_box2_sub0">
		<table id="list_table1">
		<tr><td width="8%">번호</td>
			<td width="46%">제목</td>
			<td width="15%">작성자</td>
			<td width="17%">작성일</td>
			<td width="9%">조회수</td></tr>
		</table>
	</div>
	<div id="list_box2_sub1">
		<table id="list_table2" cellspacing="0" style="border-collapse : collapse;">
<% for (Post p : list){ %>
		<tr><td width="8%"><%= p.getpNo() %></td>
			<td width="46%" style="text-align: left; padding-left: 6px"><%= p.getpTitle() %></td>
			<td width="15%"><%= p.getpId() %></td>
			<td width="17%"><%= p.getpDate() %></td>
			<td width="9%"><%= p.getReadCount() %></td></tr>
<% }%>
		</table>
	</div>
	<div id="list_box2_sub2">
		<div id="list_box2_sub2_1">
			<input id="list_input1" type="text" name="title" placeholder=" 제목을 입력하세요." size="26">
			<button id="list_button1">검색</button>
		</div>
		<div id="list_box2_sub2_2">
			<button id="list_button2" onclick="postWrite()" style="cursor: pointer">올리기</button>
		</div>
	</div>
</div>

</body>
</html>