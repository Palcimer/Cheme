<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    	Member m = (Member)session.getAttribute("m");
    %>
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.js"></script>
    <script src="https://kit.fontawesome.com/8eb5905426.js" crossorigin="anonymous"></script>
    <style>
    	
    </style>
    
	<div class="head">
        <div class="left">
            <a href="/main"><img src="img/logo.png"></a>
        </div>
        <div class="center">
            <input type="text" id="searchBox" name="searchBox" placeholder="&#61442;">
            <a href="#" class="tag" id="search">검색</a>
        </div>
        <div class="right">
        	<%if(m != null){ %>
        		<a href="#" class="tag"><%=m.getMemberId() %></a>
            	<a href="/logout" class="tag">로그아웃</a> 
        	<%}else{ %>
        		<a href="/join" class="tag" data-toggle="modal" data-target=".modal">login</a>
            	<a href="#" class="tag">회원가입</a> 
            	<div class="modal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">로그인</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="/loginCheck" method="post" name="loginFrm">
					<div class="modal-body">
						<div class="form-group">
							<label for="memberId">아이디</label>
							<input type="text" class="form-control"
							name="memberId" id="memberId" placeholder="아이디 입력">
						</div>
						<div class="form-group">
							<label for="memberPw">비밀번호</label>
							<input type="password" class="form-control"
							name="memberPw" id="memberPw" placeholder="비밀번호 입력">
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-outline-secondary">로그인</button>
						<button type="button" class="btn btn-secondary"
						data-dismiss="modal" onclick="initInputs();">닫기</button>
					</div>
					<div class="modal-footer">
						<a href="#">아이디/비밀번호 찾기</a>
					</div>
				</form>
			</div>
		</div>
	</div>
        	<%} %>
        </div>
        <div class="navbar">
        <ul class="nuderline-hover">
            <li><a href="/groupList?reqPage=1">모임 리스트</a></li>
            <li><a href="/insertGroupFrm">모임 만들기</a></li>
            <li><a href="/board?reqPage=1">공지사항</a></li>
            <li><a href="/">회사소개</a></li>
        </ul>
    	</div>
    </div>
    <br>
    <br>
    <br>
    <script>
		function initInputs(){
			$("[name=loginFrm] input").val("");
		}
	</script>
    