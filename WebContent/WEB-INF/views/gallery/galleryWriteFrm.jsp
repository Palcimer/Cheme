<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/gallery/freeHeader.jsp" %>
	<div class="container">
		<form action="/galleryWrite" method="post" enctype="multipart/form-data">
			<fieldset>
				<legend>글작성</legend>
				<table class="table" style="width:100%;">
					<tr class="table-active">
						<th>제목</th>
						<td colspan="3" style="text-align:left">
							<input type="text" class="form-control" placeholder="제목" name="galleryTitle">
						</td>
					</tr>
					<tr class="table-active">
						<th>작성자</th>
						<td>
							<input type="hidden" name="galleryWriter" value="1">작성자
						</td>
						<th>첨부파일</th>
						<td style="text-align:left">
							<input type="file" name="filename" onchange="loadImg(this);">
						</td>
					</tr>				
					<tr class="table-active">
						<th>이미지</th>
						<td colspan="3">
							<div id="img-viewer">
								<img id="img-view" width="500px">
							</div>
						</td>
					</tr>
					<tr class="table-active">
						<th>내용</th>
						<td colspan="3">
							<textarea class="form-control" name="galleryContent" id="exampleTextarea" rows="3" style="margin-top: 0px; margin-bottom: 0px; height: 300px;"></textarea>
						</td>
					</tr>
					<tr class="table-active">
						<th colspan="4">
							<button type="submit" class="btn btn-primary btn btn-block">등록하기</button>	
						</th>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<script>
		function loadImg(f){
			console.log(f.files);//input file에서 선택한 파일을 배열로 가지고옴
			if(f.files.length != 0){ //첨부파일 있을때
				var reader = new FileReader(); //첨부파일을 읽어올 객체
				reader.readAsDataURL(f.files[0]);//해당 파일의 경로를 읽어옴
				//경로를 다 읽어오면 실행할 함수 지정
				reader.onload=function(e){
					$("#img-view").attr("src",e.target.result);	
				}
			}else{ //첨부파일 없을때
				$("#img-view").attr("src","");
			}
		}
	
	</script>
</body>
</html>