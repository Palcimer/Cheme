<%@page import="gnotice.model.vo.GNoticeComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gnotice.model.vo.GNotice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    GNotice gNotice = (GNotice)request.getAttribute("gNotice");
    ArrayList<GNoticeComment> cmtList =  (ArrayList<GNoticeComment>)request.getAttribute("cmtList");
    String gName = (String)request.getAttribute("gName");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
        <div>
            <h6><%=gName %></h6>
            <h3>공지사항</h3>
            <div>
                <div class="bg-success board-title"><%=gNotice.getgNoticeTitle() %></div>
                <div class="bg-success board-date"><%=gNotice.getgNoticeDate() %></div>
            </div>
            <div class="board-buttons">
            	<a href="/writeGNoticeFrm?groupId=<%=gNotice.getGroupId() %>" class="btn btn-outline-primary" style="width:140px">새 공지 작성</a>
                <a href="/modGNotice?noticeNo=<%=gNotice.getgNoticeNo() %>" class="btn btn-outline-primary" style="width:140px">글 수정</a>
                <a href="/delGNotice?noticeNo=<%=gNotice.getgNoticeNo() %>" class="btn btn-outline-primary" style="width:140px">글 삭제</a>
            </div>             
            <div class="board-body"><%=gNotice.getgNoticeContentBr() %>
            	<%if(gNotice.getFilename() != null) {%>
                <div class="bg-light files">
                   	첨부파일 : <i class="fas fa-clone"></i> <a href="file?noticeNo=<%=gNotice.getgNoticeNo() %>"><%=gNotice.getFilename() %></a>
                </div>
                <%} %>
            </div>
            <div class="bg-light replies">
            	<%for(GNoticeComment cmt : cmtList) {%> 
            	<%if(cmt.getgNcLev() == 1) {%>           	
                <div class="comments1">
                	<span class="cmtWriter"><%=cmt.getgNcWriter() %></span>
                	<span class="cmtContent"><%=cmt.getgNcContent() %></span>
                	<span class="cmtDate"><%=cmt.getgNcDate() %></span>
                </div>
                <%} %>
                <div class="comments2"><i class="fa fa-angle-double-right 2x"></i>댓글2</div>
                <%} %>
                <div class="replysubmit">
                    <textarea class="form-control"></textarea>
                    <button type="button" class="btn btn-secondary" style="width:100%">댓글 달기</button>                    
                </div>
            </div>
            <div class="board-list"><a href="/gNoticeList?Page=1" class="btn btn-outline-primary" style="width:200px">글 목록</a></div>
            
        </div>        
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    
</body>
</html>