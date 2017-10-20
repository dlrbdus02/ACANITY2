<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/head.jsp"%>
<!-- navbar -->
<%@ include file="/header.jsp"%>
<script type="text/javascript">

	function checkValue(){
		
		var form = document.userInfo;
		
		if(!form.m_id.value){
			alert("아이디를 입력하세요.");
			return false;
		}
		
		if(form.idDuplication.value != "idCheck"){
			alert("아이디 중복체크를 해주세요.");
			return false;
		}
		
		if(!form.m_name.value){
			alert("이름를 입력하세요.");
			return false;
		}
		
		if(!form.m_pw.value){
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
		if(!form.m_pw.value != form.m_pwcheck.value){
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}
		
		if(!form.m_tel.value){
			alert("전화번호를 입력하세요.");
			return false;
		}
		
		if(isNaN(form.m_tel.value)){
			alert("전화번호는 숫자만 입력 가능합니다.");
			return false;
		}
		
		if(!form.m_email.value){
			alert("이메일을 입력하세요.");
			return false;
		}
		if(!form.m_time.value){
			alert("수업타임을 선택하세요.");
			return false;
		}
		if(!form.m_class.value){
			alert("클래스를 선택하세요.");
			return false;
		}
		
		
	}

	
	//아이디 입력창에 값 입력시 hidden으로 idUncheck 셋팅한다 
	//중복 체크 후 다시 아이디 창에 새로운 아이디를 입력했을 때 다시 중복체크를 진행하기 위함이다.
	function openIdchk(){
		
		window.name = "parentForm";
		window.open("/acanity/views/member/IdCheckForm.jsp", "chkForm", "width=500, height=300, resizable = no, scrollbars = no");
	}
	function inputIdchk(){
		document.userInfo.idDuplication.value="idUncheck";
	}
</script>
<section id="join" class="section orange">
	<h2 align="center">회원 가입 페이지</h2>
	<br>
	<!-- 웹에서의 절대경로 : "/context root명/대상경로/파일명.확장자" -->

	<form action="/acanity/menroll" method="post" id="join-form" name="userInfo" onsubmit="return checkValue()">
		<table align="center" width="600" height="350">
			<tr>
				<th width="150">아이디</th>
				<td width="450">
				<input type="text" name="m_id" id="m_id" value="" onkeydown="inputIdChk()">
				<input type="button" class="btn banner"	onclick="openIdchk()" value="ID 중복확인" />
				<input type="hidden" name="idDuplication" value="idUncheck">
				</td>
			</tr>
			<tr>
				<th>이 름</th>
				<td><input type="text" name="m_name" value=""></td>
			</tr>
			<tr>
				<th>암 호</th>
				<td><input type="password" name="m_pw" value=""></td>
			</tr>
			<tr>
				<th>암호확인</th>
				<td><input type="password" name="m_pwcheck"></td>
			</tr>
			<td><br></td>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" name="m_tel" value=""
					placeholder="'-'제외하고 숫자만 입력"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="m_email" value=""></td>
			</tr>
			<tr>
				<th>시간</th>
				<td>

					<table>
						<tr>
							<td width="60px"><input type="radio" name="m_time"
								value="오전"> 오전</td>
							<td>&nbsp;&nbsp;&nbsp;</td>
							<td width="60px"><input type="radio" name="m_time"
								value="오후"> 오후</td>
						</tr>
					</table>


				</td>
			</tr>

			<tr>
				<th>클래스</th>
				<td>
					<table>
						<tr>
							<td width="40px"><input type="radio" name="m_class"
								value="A"> &nbsp;A&nbsp;</td>
							<td width="40px"><input type="radio" name="m_class"
								value="B"> &nbsp;B&nbsp;</td>
							<td width="40px"><input type="radio" name="m_class"
								value="C"> &nbsp;C&nbsp;</td>
						</tr>
						<tr>
							<td width="40px"><input type="radio" name="m_class"
								value="D"> &nbsp;D&nbsp;</td>
							<td width="40px"><input type="radio" name="m_class"
								value="E"> &nbsp;E&nbsp;</td>
							<td width="40px"><input type="radio" name="m_class"
								value="F"> &nbsp;F&nbsp;</td>
						</tr>
						<tr>
							<td width="40px"><input type="radio" name="m_class"
								value="G"> &nbsp;G&nbsp;</td>
							<td width="40px"><input type="radio" name="m_class"
								value="H"> &nbsp;H&nbsp;</td>
							<td width="40px"><input type="radio" name="m_class"
								value="I"> &nbsp;I&nbsp;</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit" class="btn btn-success">가입하기</button>&nbsp;
					<button type="reset" class="btn btn-success">취소</button>

				</th>
			</tr>
		</table>
	</form>
	<br>
	<div align="center">
		<a href="../../index.jsp">시작페이지로 이동</a>
	</div>
	<br>
</section>
<%@ include file="/footer.jsp"%>
<%@ include file="/headend.jsp"%>