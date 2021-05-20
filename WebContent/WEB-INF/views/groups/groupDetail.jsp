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
<link rel="stylesheet" href="/css/bootstrap.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<div class="container">		
		아무나 보이는 영역<br>
		<table>
			<tr>
				<th>모임 이름</th>
				<td><%=info.getGroupName() %></td>
				<th>카테고리</th>
				<td><%=info.getCategoryName() %></td>
			</tr>
			<tr>
				<th>모임 소개</th>
				<td><%=info.getGroupDetail() %></td>
				<th>모임장</th>
				<td><%=info.getLeaderName() %></td>
			</tr>
			<tr>
				<td colspan="4"><%=info.getKeyword1() %> <%=info.getKeyword2() %> <%=info.getKeyword3() %> <%=info.getKeyword4() %> <%=info.getKeyword5() %></td>
			</tr>
		</table>
		<%if(isMem) {%>
		회원만 보이는 영역
		<table>
			<%for(GNotice n : noticeList) {%>
			<tr>
				<td><a href="/gNoticeView?groupId=<%=info.getGroupId() %>&noticeNo=<%=n.getgNoticeNo()%>&mem=5"><%=n.getgNoticeTitle() %></a></td>
				<td><a href="javascript:gNoticeView(<%=n.getgNoticeNo()%>)"><%=n.getgNoticeTitle() %></a></td>
				<td><%=n.getgNoticeDate() %></td>
			</tr>
			<%} %>
			<form action="/gNoticeView" name="transmitMem">
					<input type="hidden" name="groupId" value="<%=info.getGroupId() %>">
					<input type="hidden" name="noticeNo">
					<input type="hidden" name="mem" value="5">					
			</form>
		</table>
		<table>
		
		</table>
		<%} %>
	</div>
	<script>
		function gNoticeView(noticeNo) {
			var form = $("[name=transmitMem]");
			$("[name=noticeNo]").val(noticeNo);
			form.method = "post";
			form.action = "/gNoticeView";
			form.submit();
		}
	</script>
	<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>