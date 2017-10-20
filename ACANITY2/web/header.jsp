<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
 
<%
	Member member = (Member)session.getAttribute("member");
%>
<div class="navbar-wrapper">
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<!-- Responsive navbar -->
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
				</a>
				<h1 class="brand"><a href="/acanity/index.jsp">ACANITY</a></h1>
				<!-- navigation -->
				<nav class="pull-right nav-collapse collapse">
				<ul id="menu-main" class="nav">
					<% if(member == null){ %>
					<li><a title="signup" href="/acanity/views/member/enrollForm.jsp">Sign Up</a></li>
					<%}else{ %>
					<%= member.getmName() %>님 환영합니다
					<%} %>
					<% if(member == null){ %>
					<li><a title="signin" href="/acanity/views/member/Login.jsp">Sign In</a></li>
					<%}else{ %>
					<li><a title="logout" href="/acanity/logout">Logout</a></li>
					<%} %>
					<li><a title="board" href="/acanity/views/community/communityListView.jsp">모임</a></li>
					<li><a title="post" href="#">모임게시판</a>
					<li><a title="mypage" href="/acanity/views/mypage/mypageMain.jsp">마이페이지</a></li>
					<li><a title="qna" href="/acanity/qnalist">Q&A</a></li>
					<li><a href="/acanity/introduce.html">소개</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
</div>