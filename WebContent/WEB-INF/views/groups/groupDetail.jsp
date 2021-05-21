<%@page import="gboard.model.vo.GBoard"%>
<%@page import="group.model.vo.Group"%>
<%@page import="gnotice.model.vo.GNotice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    boolean isMem = (boolean)request.getAttribute("isMem");
    ArrayList<GNotice> noticeList = (ArrayList<GNotice>)request.getAttribute("noticeList");
    ArrayList<GBoard> boardList = (ArrayList<GBoard>)request.getAttribute("boardList");
    Group info = (Group)request.getAttribute("groupInfo");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/group.css">
<link rel="stylesheet" href="/css/gallery.css">
<link rel="stylesheet" href="/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
        <div style="margin-top:50px; margin-bottom:50px">
            <div class="group-wrap d-flex">
                <div class="group-image">
                    <img src="/upload/grouprepresenphoto/<%=info.getGroupImg() %>" width="500px">
                </div>
                <div class="group-detail">
                    <p class="group-name"><%=info.getGroupName() %></p>
                    <%if(info.getGroupLeader() == m.getMemberNo()) {%>                
                    <a href="/groupUpdateFrm?groupNo=<%=info.getGroupId()%>" class="btn btn-success">모임정보수정</a>
                    <%} else if(isMem && info.getGroupLeader() != m.getMemberNo()) { %>
                    <a href="/leaveGroup?groupId=<%=info.getGroupId() %>&mem=<%=m.getMemberNo() %>" class="btn btn-success">모임 탈퇴</a>
                    <%} %>
                    <p class="group-content"><%=info.getGroupDetailBr() %></p>
                    <div class="group-info">
                    	<%if(info.getKeyword1() != null) {%>
                        <span class="badge rounded-pill bg-secondary"><%=info.getKeyword1() %></span>
                        <%} %>
                        <%if(info.getKeyword2() != null) {%>
                        <span class="badge rounded-pill bg-warning"><%=info.getKeyword2() %></span>
                        <%} %>
                        <%if(info.getKeyword3() != null) {%>
                        <span class="badge rounded-pill bg-success"><%=info.getKeyword3() %></span>
                        <%} %>
                        <%if(info.getKeyword4() != null) {%>
                        <span class="badge rounded-pill bg-danger"><%=info.getKeyword4() %></span>
                        <%} %>
                        <%if(info.getKeyword5() != null) {%>
                        <span class="badge rounded-pill bg-info"><%=info.getKeyword5() %></span>
                        <%} %>
                        <br>
                        <span>카테고리: <a href="/groupListView?groupCategory=<%=info.getGroupCategory() %>&reqPage=1"><%=info.getCategoryName() %></a></span>
                        <span>모임장: <%=info.getLeaderName() %></span>
                    </div>
                </div>
            </div>
            <%if(m != null && !isMem) {%>
            <div class="group-join">
                <a href="/joinGroup?groupId=<%=info.getGroupId() %>&mem=<%=m.getMemberNo() %>" class="btn btn-success joinbtn">가입하기</a>
            </div>
            <%} else if(m == null) {%>
            <div class="group-join">
                <a href="/login" class="btn btn-success joinbtn">가입하기</a>
            </div>
            <%} else if(isMem) {%>
            <div class="member-page">
                <ul class="nav nav-tabs">
                    <li class="nav-item flex-fill tablink">
                        <a class="nav-link active" onclick="selectTab(0);">공지사항</a>
                    </li>
                    <li class="nav-item flex-fill tablink">
                        <a class="nav-link" onclick="selectTab(1);">게시판</a>
                    </li>
                    <li class="nav-item flex-fill tablink">
                        <a class="nav-link" onclick="selectTab(2);">갤러리</a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade active show" id="notice">
                        <table class="table table-hover">
                      		<%if(noticeList.size() == 0) { %>
                      		<p style="padding:10px 20px;">공지사항이 없습니다.
                      			<%if(info.getGroupLeader() == m.getMemberNo()) {%>
                      			<a href="writeGNoticeFrm?groupId=<%=info.getGroupId() %>">새 공지를 작성해보세요.</a>
                      			<%} %>
                      		</p>
                      		<%} else { %>
							<%for(GNotice n : noticeList) {%>
							<tr>
								<td style="width:80%"><a href="/gNoticeView?groupId=<%=info.getGroupId() %>&noticeNo=<%=n.getgNoticeNo()%>&mem=<%=m.getMemberNo()%>"><%=n.getgNoticeTitle() %></a></td>
								<td style="width:20%; text-align:center"><%=n.getgNoticeDate() %></td>
							</tr>
							<%} %>
							<%} %>
						</table>
                    </div>
                    <div class="tab-pane fade" id="board">
                        <table class="table table-hover">
                        	<%if(boardList.size() == 0) { %>
                        	<p style="padding:10px 20px;"><a href="/writeGBoardFrm?groupId=<%=info.getGroupId() %>">게시글이 없습니다. 새 게시글을 작성해보세요.</a></p>
                      		<%} else { %>
							<%for(GBoard b : boardList) {%>
							<tr>
								<td style="width:80%"><a href="/gBoardView?groupId=<%=info.getGroupId() %>&boardNo=<%=b.getgBoardNo()%>&mem=<%=m.getMemberNo()%>"><%=b.getgBoardTitle() %></a></td>
								<td style="width:20%; text-align:center"><%=b.getgBoardDate() %></td>
							</tr>
							<%} %>
							<%} %>
						</table>
                    </div>
                    <div class="tab-pane fade" id="gallery">
                        <p>갤러리</p>
                    </div>
                </div>
            </div>
            <%} %>
        </div>               
    </div>
    <script>
        function selectTab(idx) {
            var tab = $(".nav-item a");
            var content = $(".tab-pane");
            console.log(content);
            for(var i=0; i<content.length; i++) {
                if(i == idx) {
                    tab.eq(i).attr("class", "nav-link active");
                    content.eq(i).attr("class", "tab-pane fade active show");
                } else {
                    tab.eq(i).attr("class", "nav-link");
                    content.eq(i).attr("class", "tab-pane fade");
                }             
            }
        }
    </script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>