<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/head.jsp"%>
<!-- navbar -->
<%@ include file="/header.jsp"%>
<%
	member = (Member)request.getAttribute("member");
%>
<br>
<h2 align="center"><%= member.getmName() %>님 정보보기</h1>
<br><br>
<form action="/acanity/mupdate" method="post">
	
		<table align="center" width="600" height="350">
			<tr>
				<th width="150">아이디</th>
				<td width="450"><input name="mid" value="<%= member.getmId() %>" readonly></td>
			</tr>
			<tr>
				<th>이 름</th>
				<td><input type="text" name="mname" value="<%= member.getmName() %>"></td>
			</tr>
			<tr>
				<th>암 호</th>
				<td><input type="password" name="mpw" value="<%= member.getmPwd() %>"></td>
			</tr>
			<tr>
				<th>암호확인</th>
				<td><input type="password" name="mpw2">
				<div id="checkPwd">동일한 암호를 입력하세요.</div></td>
			</tr>
			<td><br></td>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" name="mtel" value="<%= member.getmTel() %>"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="memail" value="<%= member.getmEmail() %>"></td>
			</tr>
			<tr>
				<th>시간</th>
				<% if(member.getmTime().equals("오전")){ %>
				<td>
				<input type="radio" name="mtime" value="오전" checked readonly>오전
				<input type="radio" name="mtime" value="오후" readonly>오후
				</td>
				<% }else{ %>
				<td>
				<input type="radio" name="mtime" value="오전"  readonly>오전
				<input type="radio" name="mtime" value="오후" checked readonly>오후
				</td>
				<%} %>
			</tr>

			<tr>
				<th>클래스</th>
				<% if(member.getmClass().equals("A")){ %>
				<td>
				<input type="radio" name="mclass" value="A" checked readonly>A
				<input type="radio" name="mclass" value="B"  readonly>B
				<input type="radio" name="mclass" value="C"  readonly>C
				<input type="radio" name="mclass" value="D"  readonly>D
				<input type="radio" name="mclass" value="E"  readonly>E
				<input type="radio" name="mclass" value="F"  readonly>F
				<input type="radio" name="mclass" value="G"  readonly>G
				<input type="radio" name="mclass" value="H"  readonly>H
				<input type="radio" name="mclass" value="I"  readonly>I
				</td>
				<% }else{ %>
				<td>
				<input type="radio" name="mclass" value="B" checked readonly>B
				</td>
				
				<%} %>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit" class="btn btn-success">정보수정완료</button>&nbsp;
					<a href="/acanity/views/mypage/mypageMain.jsp">취소</a>
				</th>
			</tr>
		</table>
	
</form>
<br>
<%@ include file="/footer.jsp"%>
<%@ include file="/headend.jsp"%>