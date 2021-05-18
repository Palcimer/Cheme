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
	<div class="container">
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
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
	
</body>
</html>