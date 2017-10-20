<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/head.jsp"%>
<!-- navbar -->
<%@ include file="/header.jsp"%>


<!-- end section: team -->
<!-- section: services -->

<section id="services" class="section orange">
	<div class="container">
		<h4>Sign In</h4>
		<!-- Four columns -->
		<div class="row" align="center">
			<form action="/acanity/login" method="post">
				<div class="form-group">
					<label for="exampleInputName1">아이디</label> <input type="text"
						class="form-control" id="exampleInputName1" name="m_id"
						placeholder="아이디를 입력하세요">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">암호</label> <input
						type="password" class="form-control" id="exampleInputPassword1" name="m_pw"
						placeholder="암호">
				</div>
				<div class=checkbox">
					<label> <input type="checkbox">Remember me
					</label>
				</div>
				<br>
				<button type="submit" class="btn btn-success">제출</button>
			</form>
		</div>
	</div>
</section>


<%@ include file="/footer.jsp"%>
<%@ include file="/headend.jsp"%>