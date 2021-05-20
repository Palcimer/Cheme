<%@page import="gnotice.model.vo.GNotice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String groupName = (String)request.getAttribute("groupName");
    String pageNavi = (String)request.getAttribute("pageNavi");
    ArrayList<GNotice> list = (ArrayList<GNotice>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
        <div style="margin-bottom:50px">
            <h6><%=groupName %></h6>
            <h3>공지사항</h3>
            <table class="table table-hover board-table">
                <tr class="table-success">
                    <th scope="col" style="width:50px; text-align:center">번호</th>
                    <th scope="col" style="width:80%">제목</th>
                    <th scope="col" style="width:120px; text-align:center">작성일</th>
                </tr>
                <%for(GNotice notice : list) {%>
                <tr>
                    <th scope="row" style="text-align:center"><%=notice.getRnum() %></th>
                    <td><a href="/gNoticeView?groupId=<%=notice.getGroupId() %>&noticeNo=<%=notice.getgNoticeNo()%>&mem=5"><%=notice.getgNoticeTitle() %></a></td>
                    <td style="text-align:center"><%=notice.getgNoticeDate() %></td>
                </tr>
                <%} %>
            </table>
            <div class="page">
             	<%=pageNavi %>
            </div>
        </div>                
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>