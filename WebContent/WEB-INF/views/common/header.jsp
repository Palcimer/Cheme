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
    
    
	<div class="head">
        <div class="left">
            <a href="/main"><img src="img/mainlogo.jpg"></a>
        </div>
        <div class="center">
            <input type="text" id="searchBox" name="searchBox" placeholder="&#61442;">
            <a href="#" class="tag" id="search">검색</a>
        </div>
        <div class="right">
        	<%if(m != null){ %>
        		<a href="#" class="tag"><%=m.getMemberId() %></a>
            	<a href="#" class="tag">로그인시 미정</a> 
        	<%}else{ %>
        		<a href="/join" class="tag">login</a>
            	<a href="#" class="tag">회원가입</a> 
        	<%} %>
        </div>
        <div class="navbar">
        <ul class="nuderline-hover">
            <li><a href="#">모임 리스트</a></li>
            <li><a href="/insertGroupFrm">모임 만들기</a></li>
            <li><a href="#">공지사항</a></li>
            <li><a href="/board?reqPage=1">자유게시판</a></li>
            <li><a href="/">회사소개</a></li>
        </ul>
    </div>
    </div>
    <br>
    <br>
    <br>
    