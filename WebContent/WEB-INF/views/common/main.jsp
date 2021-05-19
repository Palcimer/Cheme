<%@page import="notice.model.vo.MainNotice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<MainNotice> list = (ArrayList<MainNotice>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
    	.table{
                text-align: center;
            }
            .table td, .table th{
            	padding : 12px;
            }
            #main-notice{
                color: black;
                text-decoration: none;
            }
			.carousel-inner img{
                width: 1100px;
                height: 600px;
            }
            #img-h2{
                text-align: center;
                font-weight: bolder;
            }
    </style>
	<div class="container">
	<br><br>
		<h2 id="img-h2">HOT</h2>
        <br><br>
        <div id="demo" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ul class="carousel-indicators">
                <li data-target="#demo" data-slide-to="0" class="active"></li>
                <li data-target="#demo" data-slide-to="1"></li>
                <li data-target="#demo" data-slide-to="2"></li>
            </ul>
            <!-- The slideshow -->
            <div class="carousel-inner">
                <div class="carousel-item active" >
                    <img src="/img/trip.jpg" alt="게임">
                </div>
                <div class="carousel-item">
                    <img src="/img/game.jpg" alt="여행">
                </div>
                <div class="carousel-item">
                    <img src="/img/run.jpg" alt="운동">
                </div>
            </div>
            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#demo" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>
        </div>
		<br><br>
		<a href="#" id="main-notice"><h2>공지사항</h2></a>
        <table class="table">
        <thead>
            <tr>
            <th style="width: 20%;">글 번호</th>
            <th style="width: 35%;">제목</th>
            <th>작성일</th>
            </tr>
        </thead>
        <tbody>
            <%for(int i=0;i<5;i++){ %>
            <tr>
            	<td><%=list.get(i).getMainNoticeNo() %></td>
            	<td>
            		<a href="/noticeView?noticeNo=<%=list.get(i).getMainNoticeNo() %>" id="main-notice"><%= list.get(i).getMainNoticeTitle()%></a>
            	</td>
            	<td>
            		<%=list.get(i).getMainNoticeDate() %>
            	</td>
            </tr>
            <%} %>
            </tbody>
        </table>
	</div>
	<br><br>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
</body>
</html>