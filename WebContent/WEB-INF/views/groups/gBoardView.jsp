<%@page import="gboard.model.vo.GBoard"%>
<%@page import="gboard.model.vo.GBoardComment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String gName = (String)request.getAttribute("gName");
    ArrayList<GBoardComment> cmtList =  (ArrayList<GBoardComment>)request.getAttribute("cmtList");
    GBoard board = (GBoard)request.getAttribute("gBoard");
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
                <div class="bg-success board-title"><%=board.getgBoardTitle() %></div>
                <div class="bg-success board-date"><%=board.getgBoardDate() %></div>
            </div>
            <%if(m != null && m.getMemberNo() == board.getgBoardWriter()) {%>
            <div class="board-buttons">
                <a href="/modGBoard?boardNo=<%=board.getgBoardNo() %>" class="btn btn-outline-primary" style="width:140px">글 수정</a>
                <a href="/delGBoard?boardNo=<%=board.getgBoardNo() %>" class="btn btn-outline-primary" style="width:140px">글 삭제</a>
            </div>          
            <%} %>   
            <div class="board-body"><%=board.getgBoardContentBr() %>
            	<%if(board.getgBoardFilename() != null) {%>
                <div class="bg-light files">
                   	첨부파일 : <i class="fas fa-clone"></i> <a href="gBoardFile?boardNo=<%=board.getgBoardNo() %>"><%=board.getgBoardFilename() %></a>
                </div>
                <%} %>
            </div>
            <!-- 댓글 -->
            <div class="bg-light replies">
            	<table class="table">
            		<%for(GBoardComment cmt : cmtList) {%> 
            		<%if(cmt.getgBoardCommentLev() == 1) {%>
                    <tr>
                        <th scope="row" style="width:150px"><%=cmt.getgBoardCommentWriterName() %></th>
                        <td>
                        	<span><%=cmt.getgBoardCommentContentBr() %></span>
                        	<textarea name="gNcContent" class="form-control" style="display:none"><%=cmt.getgBoardCommentContent() %></textarea>
                        	<span class="cmtMenu"> 
                        		<%if(m != null && m.getMemberNo() == cmt.getgBoardCommentWriter()) {%>
                        		<a href="javascript:void(0)" onclick="modCmt(this, <%=cmt.getgBoardCommentNo()%>, <%=board.getgBoardNo()%>, <%=board.getGroupId()%>, <%=m.getMemberNo()%>)">수정</a>
                        		<a href="javascript:void(0)" onclick="delCmt(this, <%=cmt.getgBoardCommentNo()%>, <%=board.getgBoardNo()%>, <%=board.getGroupId()%>, <%=m.getMemberNo()%>)">삭제</a>
                        		<%} %>
                        		<a href="javascript:void(0)" onclick="recShow(this)">댓글</a>
                        	</span>
                        	
                        	<form action = "/gComment" style="display:none">
								<input type="hidden" name="rpLv" value="2">
								<input type="hidden" name="rpWriter" value="<%=m.getMemberNo()%>">
								<input type="hidden" name="No" value="<%=board.getgBoardNo()%>">
								<input type="hidden" name="rpRef" value="<%=cmt.getgBoardCommentNo()%>">
								<input type="hidden" name="groupId" value="<%=board.getGroupId()%>">
								<input type="hidden" name="mem" value="<%=m.getMemberNo()%>">
								<textarea class="form-control" name="rpContent"></textarea>
								<span class="cmtMenu"> 
									<a href="javascript:void(0)" onclick="reCmt(this)">댓글 달기</a>
									<a href="javascript:void(0)" onclick="cancelCmt(this)">취소</a>
								</span>
							</form>					
                        </td>
                        <td style="text-align:center; width:120px;"><%=cmt.getgBoardCommentDate() %></td>
                    </tr>
	                    <%for(GBoardComment cmtlv2 : cmtList) {%> 
	                    <%if(cmtlv2.getgBoardCommentLev() == 2 && cmtlv2.getgBoardCommentRef() == cmt.getgBoardCommentNo()) {%>
	                    <tr>
	                        <th scope="row">
	                        	<i class="fa fa-angle-double-right 5x"></i>
	                        	<%=cmtlv2.getgBoardCommentWriterName() %>
	                        </th>
	                        <td>
	                        	<span><%=cmtlv2.getgBoardCommentContentBr() %></span>
	                        	<textarea name="gNcContent" class="form-control" style="display:none"><%=cmtlv2.getgBoardCommentContent() %></textarea>
	                        	<span class="cmtMenu">
	                        		<%if(m != null && m.getMemberNo() == cmtlv2.getgBoardCommentWriter()) {%>
	                        		<a href="javascript:void(0)" onclick="modCmt(this, <%=cmtlv2.getgBoardCommentNo()%>, <%=board.getgBoardNo()%>, <%=board.getGroupId()%>, <%=m.getMemberNo()%>)">수정</a>
	                        		<a href="javascript:void(0)" onclick="delCmt(this, <%=cmtlv2.getgBoardCommentNo()%>, <%=board.getgBoardNo()%>, <%=board.getGroupId()%>, <%=m.getMemberNo()%>)">삭제</a>
	                        		<%} %>
	                        	</span>
	                        </td>
	                        <td style="text-align:center"><%=cmtlv2.getgBoardCommentDate() %></td>
	                    </tr>
	                    <%} %>
	                    <%} %>
                    <%} %>
                    <%} %>                    
                </table>
                <div class="replysubmit">
                	<form action="/gComment" method="post">                
	                	<input type="hidden" name="rpLv" value="1">
						<input type="hidden" name="rpWriter" value="<%=m.getMemberNo()%>">
						<input type="hidden" name="No" value="<%=board.getgBoardNo()%>">
						<input type="hidden" name="rpRef" value="0">
						<input type="hidden" name="groupId" value="<%=board.getGroupId()%>">
						<input type="hidden" name="mem" value="<%=m.getMemberNo()%>">
	                    <textarea class="form-control" name="rpContent"></textarea>
	                    <button type="submit" class="btn btn-secondary" style="width:100%; margin-top:3px">댓글 달기</button>                    
	                </form>                    
                </div>
            </div>
            <div class="board-tolist">
            	<a href="/gList?groupId=1&mem=<%=m.getMemberNo()%>&page=1" class="btn btn-outline-primary" style="width:40%">글 목록으로</a>
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
    	function modCmt(obj, cmtNo, boardNo, groupId, mem) {
    		$(obj).parent().prev().prev().hide();
    		$(obj).parent().prev().show();
    		$(obj).html("수정완료");
    		$(obj).attr("onclick", "modComplete(this, " + cmtNo + ", " + boardNo + ", " + groupId + ", " + mem + ")");
    		$(obj).next().html("수정취소");
    		$(obj).next().attr("onclick", "modCancel(this, " + cmtNo + ", " + boardNo + ", " + groupId + ", " + mem + ")");
    		$(obj).next().next().hide();
    	}
    	function modCancel(obj, cmtNo, boardNo, groupId, mem) {
    		$(obj).parent().prev().hide();
    		$(obj).parent().prev().prev().show();
    		$(obj).prev().html("수정");
    		$(obj).prev().attr("onclick", "modCmt(this, " + cmtNo + ", " + boardNo + ", " + groupId + ", " + mem + ")");
    		$(obj).html("삭제");
    		$(obj).attr("onclick", "delCmt(this, " + cmtNo + ", " + boardNo + ", " + groupId + ", " + mem + ")");
    		$(obj).next().show();
    	}
    	function modComplete(obj, cmtNo, boardNo, groupId, mem) {
    		var form = $("<form action='/modGBoardComment' method='post'></form>");
    		form.append($("<input type='hidden' name='cmtNo' value='" + cmtNo + "'>"));
    		form.append($("<input type='hidden' name='No' value='" + boardNo + "'>"));
    		form.append($("<input type='hidden' name='groupId' value='" + groupId + "'>"));
    		form.append($("<input type='hidden' name='mem' value='" + mem + "'>"));
    		form.append($(obj).parent().prev());
    		$("body").append(form);
    		form.submit();
    	}
    	function delCmt(obj, cmtNo, boardNo, groupId, mem) {
    		if(confirm("댓글을 삭제하시겠습니까?")) {
				location.href="/delGBoardComment?cmtNo=" + cmtNo + "&boardNo=" + boardNo + "&groupId=" + groupId + "&mem=" + mem;
			}
    	}
    </script>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>