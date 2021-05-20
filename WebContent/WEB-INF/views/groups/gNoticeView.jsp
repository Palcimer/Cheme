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
            <!-- 공지 본문 -->
            <div>
                <div class="bg-success board-title"><%=gNotice.getgNoticeTitle() %></div>
                <div class="bg-success board-date"><%=gNotice.getgNoticeDate() %></div>
            </div>
            <%if(m != null && m.getMemberNo() == gNotice.getgNoticeWriter()) {%>
            <div class="board-buttons">
            	<a href="/writeGNoticeFrm?groupId=<%=gNotice.getGroupId() %>" class="btn btn-outline-primary" style="width:140px">새 공지 작성</a>
                <a href="/modGNotice?noticeNo=<%=gNotice.getgNoticeNo() %>" class="btn btn-outline-primary" style="width:140px">글 수정</a>
                <a href="/delGNotice?noticeNo=<%=gNotice.getgNoticeNo() %>" class="btn btn-outline-primary" style="width:140px">글 삭제</a>
            </div>          
            <%} %>   
            <div class="board-body"><%=gNotice.getgNoticeContentBr() %>
            	<%if(gNotice.getFilename() != null) {%>
                <div class="bg-light files">
                   	첨부파일 : <i class="fas fa-clone"></i> <a href="file?noticeNo=<%=gNotice.getgNoticeNo() %>"><%=gNotice.getFilename() %></a>
                </div>
                <%} %>
            </div>
            <!-- 댓글 -->
            <div class="bg-light replies">
            	<table class="table">
            		<%for(GNoticeComment cmt : cmtList) {%> 
            		<%if(cmt.getgNcLev() == 1) {%>
                    <tr>
                        <th scope="row" style="width:150px"><%=cmt.getgNcWriterName() %></th>
                        <td>
                        	<span><%=cmt.getgNcContentBr() %></span>
                        	<textarea name="gNcContent" class="form-control" style="display:none"><%=cmt.getgNcContent() %></textarea>
                        	<span class="cmtMenu"> 
                        		<%if(m != null && m.getMemberNo() == cmt.getgNcWriter()) {%>
                        		<a href="javascript:void(0)" onclick="modCmt(this, <%=cmt.getgNcNo()%>, <%=gNotice.getgNoticeNo()%>, <%=gNotice.getGroupId()%>, <%=m.getMemberNo()%>)">수정</a>
                        		<a href="javascript:void(0)" onclick="delCmt(this, <%=cmt.getgNcNo()%>, <%=gNotice.getgNoticeNo()%>, <%=gNotice.getGroupId()%>, <%=m.getMemberNo()%>)">삭제</a>
                        		<%} %>
                        		<a href="javascript:void(0)" onclick="recShow(this)">댓글</a>
                        	</span>
                        	
                        	<form action = "/gNoticeComment" style="display:none">
								<input type="hidden" name="rpLv" value="2">
								<input type="hidden" name="rpWriter" value="<%=m.getMemberNo()%>">
								<input type="hidden" name="noticeNo" value="<%=gNotice.getgNoticeNo() %>">
								<input type="hidden" name="rpRef" value="<%=cmt.getgNcNo() %>">
								<input type="hidden" name="groupId" value="<%=gNotice.getGroupId() %>">
								<input type="hidden" name="mem" value="<%=m.getMemberNo()%>">
								<textarea class="form-control" name="rpContent"></textarea>
								<span class="cmtMenu"> 
									<a href="javascript:void(0)" onclick="reCmt(this)">댓글 달기</a>
									<a href="javascript:void(0)" onclick="cancelCmt(this)">취소</a>
								</span>
							</form>					
                        </td>
                        <td style="text-align:center; width:120px;"><%=cmt.getgNcDate() %></td>
                    </tr>
	                    <%for(GNoticeComment cmtlv2 : cmtList) {%> 
	                    <%if(cmtlv2.getgNcLev() == 2 && cmtlv2.getgNcRef() == cmt.getgNcNo()) {%>
	                    <tr>
	                        <th scope="row">
	                        	<i class="fa fa-angle-double-right 5x"></i>
	                        	<%=cmtlv2.getgNcWriterName() %>
	                        </th>
	                        <td>
	                        	<span><%=cmtlv2.getgNcContentBr() %></span>
	                        	<textarea name="gNcContent" class="form-control" style="display:none"><%=cmtlv2.getgNcContent() %></textarea>
	                        	<span class="cmtMenu">
	                        		<%if(m != null && m.getMemberNo() == cmtlv2.getgNcWriter()) {%>
	                        		<a href="javascript:void(0)" onclick="modCmt(this, <%=cmtlv2.getgNcNo()%>, <%=gNotice.getgNoticeNo()%>, <%=gNotice.getGroupId()%>, <%=m.getMemberNo()%>)">수정</a>
	                        		<a href="javascript:void(0)" onclick="delCmt(this, <%=cmtlv2.getgNcNo()%>, <%=gNotice.getgNoticeNo()%>, <%=gNotice.getGroupId()%>, <%=m.getMemberNo()%>)">삭제</a>
	                        		<%} %>
	                        	</span>
	                        </td>
	                        <td style="text-align:center"><%=cmtlv2.getgNcDate() %></td>
	                    </tr>
	                    <%} %>
	                    <%} %>
                    <%} %>
                    <%} %>                    
                </table>
                <div class="replysubmit">
                	<form action="/gNoticeComment" method="post">                
	                	<input type="hidden" name="rpLv" value="1">
						<input type="hidden" name="rpWriter" value="<%=m.getMemberNo()%>">
						<input type="hidden" name="noticeNo" value="<%=gNotice.getgNoticeNo() %>">
						<input type="hidden" name="rpRef" value="0">
						<input type="hidden" name="groupId" value="<%=gNotice.getGroupId() %>">
						<input type="hidden" name="mem" value="<%=m.getMemberNo()%>">
	                    <textarea class="form-control" name="rpContent"></textarea>
	                    <button type="submit" class="btn btn-secondary" style="width:100%; margin-top:3px">댓글 달기</button>                    
	                </form>                    
                </div>
            </div>
            <div class="board-tolist">
            	<a href="/gNoticeList?groupId=1&mem=<%=m.getMemberNo()%>&page=1" class="btn btn-outline-primary" style="width:40%">글 목록으로</a>
            </div>
        </div>        
    </div>
    <script>
    	function recShow(obj) {
    		$(obj).parent().next().show();
    		$(obj).parent().hide();
    	}
    	function cancelCmt(obj) {
    		$(obj).parent().parent().hide();
    		$(obj).parent().parent().prev().show();
    	}
    	function reCmt(obj) {
    		var form = $(obj).parent().parent();
    		form.submit();
    	}
    	function modCmt(obj, cmtNo, noticeNo, groupId, mem) {
    		$(obj).parent().prev().prev().hide();
    		$(obj).parent().prev().show();
    		$(obj).html("수정완료");
    		$(obj).attr("onclick", "modComplete(this, " + cmtNo + ", " + noticeNo + ", " + groupId + ", " + mem + ")");
    		$(obj).next().html("수정취소");
    		$(obj).next().attr("onclick", "modCancel(this, " + cmtNo + ", " + noticeNo + ", " + groupId + ", " + mem + ")");
    		$(obj).next().next().hide();
    	}
    	function modCancel(obj, cmtNo, noticeNo, groupId, mem) {
    		$(obj).parent().prev().hide();
    		$(obj).parent().prev().prev().show();
    		$(obj).prev().html("수정");
    		$(obj).prev().attr("onclick", "modCmt(this, " + cmtNo + ", " + noticeNo + ", " + groupId + ", " + mem + ")");
    		$(obj).html("삭제");
    		$(obj).attr("onclick", "delCmt(this, " + cmtNo + ", " + noticeNo + ", " + groupId + ", " + mem + ")");
    		$(obj).next().show();
    	}
    	function modComplete(obj, cmtNo, noticeNo, groupId, mem) {
    		var form = $("<form action='/modGNoticeComment' method='post'></form>");
    		form.append($("<input type='hidden' name='cmtNo' value='" + cmtNo + "'>"));
    		form.append($("<input type='hidden' name='noticeNo' value='" + noticeNo + "'>"));
    		form.append($("<input type='hidden' name='groupId' value='" + groupId + "'>"));
    		form.append($("<input type='hidden' name='mem' value='" + mem + "'>"));
    		form.append($(obj).parent().prev());
    		$("body").append(form);
    		form.submit();
    	}
    	function delCmt(obj, cmtNo, noticeNo, groupId, mem) {
    		if(confirm("댓글을 삭제하시겠습니까?")) {
				location.href="/delGNoticeComment?cmtNo=" + cmtNo + "&noticeNo=" + noticeNo + "&groupId=" + groupId + "&mem=" + mem;
			}
    	}
    </script>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
    
</body>
</html>