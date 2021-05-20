<%@page import="gboard.model.vo.GBoard"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String groupName = (String)request.getAttribute("groupName");
    String pageNavi = (String)request.getAttribute("pageNavi");
    ArrayList<GBoard> list = (ArrayList<GBoard>)request.getAttribute("list");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/board.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
        <div style="margin-bottom:50px">
            <h6><%=groupName %></h6>
            <h3>모임 게시판</h3>
            <div style="margin-bottom:5px"><a href="/writeGBoardFrm?groupId=<%=list.get(0).getGroupId() %>" class="btn btn-outline-primary">새 글 쓰기</a></div>
            <table class="table table-hover board-table">
                <tr class="table-success">
                    <th scope="col" style="width:70px; text-align:center">번호</th>
                    <th scope="col">제목</th>
                    <th scope="col" style="width:150px; text-align:center">작성자</th>
                    <th scope="col" style="width:120px; text-align:center">작성일</th>
                </tr>
                <%for(GBoard b : list) {%>
                <tr>
                    <th scope="row" style="text-align:center"><%=b.getRnum() %></th>
                    <td><a href="/gBoardView?groupId=<%=b.getGroupId() %>&boardNo=<%=b.getgBoardNo()%>&mem=<%=m.getMemberNo()%>"><%=b.getgBoardTitle() %></a></td>
                    <td style="text-align:center"><%=b.getgBoardWriterName() %></td>
                    <td style="text-align:center"><%=b.getgBoardDate() %></td>
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