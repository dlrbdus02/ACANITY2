<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member, post.model.vo.Post, java.util.*" %>
<%
	Member member = (Member)session.getAttribute("member");
	int cno = Integer.parseInt(request.getParameter("cno"));
	Post post = (Post)request.getAttribute("post");
	
	String[] filenames = null;
	String[] filenames2 = null;
	if (post.getOriginalFileName() != null){
		filenames = post.getOriginalFileName().split(",");
		filenames2 = post.getRenameFileName().split(",");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shareListView</title>
<link rel="stylesheet" href="/acanity/css/sharepost.css">
<script type="text/javascript">

	function checkall(){
		var chk = document.getElementsByName("filecheck[]");
		for(i=0; i < chk.length; i++){
			chk[i].checked = true;
		}
	}
	
	function uncheckall(){
		var chk = document.getElementsByName("filecheck[]");
		for(i=0; i < chk.length; i++){
			chk[i].checked = false;
		}
	}

	function filedown(){
		//수정해야됨
		var chk = document.getElementsByName("filecheck[]");
/* 		var filename = null;
		for(i=0; i < 3; i++){
			if(chk[i].checked == true){
				filename = chk[i].value.split("/");
				String downfilename = filename[0];
				alert(downfilename);
			}
		}
		 */
		var count = 0;
		var values = "";
		
		// 체크된 체크박스가 총 몇 개인지, 체크박스의 value값을 저장하기
		for(i=0; i < 3; i++){
			if(chk[i].checked == true){
				if(count == 0){
					values += chk[i].value;
				}else{
					values += ",";
					values += chk[i].value;
				}
				count++;
			}
		}
		location.href = "/acanity/spfiledown?files=" + values + "&count=" + count;
	}
	
	function postupdate(){
		var value = prompt("비밀번호를 입력해주세요.");
		if(value == <%=post.getpPw()%>){
			location.href = "/acanity/spupview?cno=" + <%=cno%> + "&pno=" + <%=post.getpNo()%>;
		}else{
			alert("비밀번호가 다릅니다.");
			return;
		}
	}
	
	function postdelete(){
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}else{
			location.href = "/acanity/spdelete?cno=" + <%=cno%> + "&pno=" + <%=post.getpNo()%>;
		}
	}
	
	function move1(){
		location.href = "/acanity/splist?cno=" + <%=cno%>;
	}
</script>
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
						<form name="form">
						<div id="detail_box2">
							<% if (post.getOriginalFileName() != null){
								for(int i = 0; i < filenames.length; i++){ %>
									<input type="checkbox" name="filecheck[]" value="<%=filenames2[i]%>/<%=filenames[i]%>">
									<span id="detail_span1"><%= filenames[i] %></span><br>
							<% 	} %>
									<input type="button" value="모든 파일 선택" onclick="checkall();" id="detail_button2" style="cursor: pointer">
									<input type="button" value="모든 선택 해제" onclick="uncheckall();" id="detail_button3" style="cursor: pointer">
									</div>
									<input type="button" value="선택한 파일 저장" onclick="filedown();" id="detail_button4" style="cursor: pointer">
							<% }else{	//파일이 없다면 %>
									<span id="detail_span2">첨부파일이 없습니다.</span>
									</div>
									<input type="button" value="파일 없음" id="detail_button4">
							<%	} %>
					</form>
					</td>
				</tr>
			</table>
	</div>
	<div id="write_box2">
<% if(member.getmId().equals(post.getpId())){ %>
		<input type="button" value="수정" onclick="postupdate();" id="detail_button1" style="cursor: pointer">
		<input type="button" value="삭제" onclick="postdelete();" id="detail_button1" style="cursor: pointer">
<% } %>
		<input type="button" value="목록" onclick="move1();" id="detail_button1" style="cursor: pointer">
	</div>
</div>

</body>
</html>