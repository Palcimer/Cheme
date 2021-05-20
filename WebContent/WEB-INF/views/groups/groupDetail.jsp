<%@page import="group.model.vo.Group"%>
<%@page import="gnotice.model.vo.GNotice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    boolean isMem = (boolean)request.getAttribute("isMem");
    ArrayList<GNotice> noticeList = (ArrayList<GNotice>)request.getAttribute("noticeList");
    Group info = (Group)request.getAttribute("groupInfo");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/group.css">
<link rel="stylesheet" href="/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">
        <div style="margin-top:50px; margin-bottom:50px">
            <div class="group-wrap d-flex">
                <div class="group-image">
                    <img src="img03.jpg" width="500px">
                </div>
                <div class="group-detail">
                    <p class="group-name"><%=info.getGroupName() %></p>
                    <button type="button" class="btn btn-success">모임정보수정</button>
                    <p class="group-content"><%=info.getGroupDetail() %></p>
                    <div class="group-info">
                    	<%if(info.getKeyword1() != null) {%>
                        <span class="badge rounded-pill bg-secondary">#<%=info.getKeyword1() %></span>
                        <%} %>
                        <%if(info.getKeyword2() != null) {%>
                        <span class="badge rounded-pill bg-warning">#<%=info.getKeyword2() %></span>
                        <%} %>
                        <%if(info.getKeyword3() != null) {%>
                        <span class="badge rounded-pill bg-success">#<%=info.getKeyword3() %></span>
                        <%} %>
                        <%if(info.getKeyword4() != null) {%>
                        <span class="badge rounded-pill bg-danger">#<%=info.getKeyword4() %></span>
                        <%} %>
                        <%if(info.getKeyword5() != null) {%>
                        <span class="badge rounded-pill bg-info">#<%=info.getKeyword5() %></span>
                        <%} %>
                        <br>
                        <span>카테고리: <a href="#"><%=info.getCategoryName() %></a></span>
                        <span>모임장: <%=info.getLeaderName() %></span>
                    </div>
                </div>
            </div>
            <div class="group-join">
                <button type="button" class="btn btn-success joinbtn">가입하기</button>
            </div>
            <%if(isMem) {%>
            <div>
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
                        <table>
			<%for(GNotice n : noticeList) {%>
			<tr>
				<td><a href="/gNoticeView?groupId=<%=info.getGroupId() %>&noticeNo=<%=n.getgNoticeNo()%>&mem=<%=m.getMemberNo()%>"><%=n.getgNoticeTitle() %></a></td>
				<td><%=n.getgNoticeDate() %></td>
			</tr>
			<%} %>
		</table>
                    </div>
                    <div class="tab-pane fade" id="board">
                        <p>게시판</p>
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