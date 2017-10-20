<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="member.model.vo.Member"%>
<%@ include file="/head.jsp"%>
<!-- navbar -->
<%@ include file="/header.jsp"%>

<br>
여기는 마이페이지 영역이다 오바.
<ul>
	<li><a href="#">나의모임현황</a></li>
	<li><a href="/acanity/minfo?mid=<%= member.getmId() %>">내정보보기</a></li>
	<li><a href="#">회원탈퇴</a></li>
</ul>
<%@ include file="/footer.jsp"%>
<%@ include file="/headend.jsp"%>