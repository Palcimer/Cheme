<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모임 개설하기</title>
<style>
      .content-wrap {
       padding: 100px;
       
      }
      .content {
        width: 770px;
        margin: 0 auto;
        padding-left: 100px;
        padding-right: 100px;
        border: 1px solid #ccc;
        border-radius: 1.5%;
      }
      .button-form {
        padding: 50px;
        display: flex;
        justify-content: center;
        justify-content: space-around;
      }
    </style>
</head>
<body>
		<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="content-wrap">
      <div class="content">
        <form action="#">
          <legend>모임 만들기</legend>

          <div class="form-group">
            <label class="col-form-label col-form-label-lg mt-4" for="moim-name"
              >모임명</label
            >
            <input
              class="form-control form-control-lg"
              type="text"
              id="moim-name"
              placeholder="모임명을 입력해주세요."
            />
          </div>

          <div class="form-group">
            <label for="moim-categori" class="form-label mt-4"
              >모임 카테고리 설정</label
            >
            <select class="form-select" id="moim-categori">
              <option>운동</option>
              <option>뷰티</option>
              <option>개발</option>
              <option>공부</option>
            </select>
          </div>

          <div class="form-group">
            <label for="exampleSelect1" class="form-label mt-4"
              >모임 설정인원</label
            >
            <select class="form-select" id="exampleSelect1">
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
            </select>
          </div>

          <div class="form-group">
            <label for="formFile" class="form-label mt-4"
              >모임 대표사진 설정(?x?)</label
            >
            <input class="form-control" type="file" id="formFile" />
          </div>

          <div class="form-group">
            <label for="moim-intro" class="form-label mt-4"
              >모임 간단 소개글</label
            >
            <textarea class="form-control" id="moim-intro" rows="5"></textarea>
          </div>

          <div class="form-group">
            <label
              class="col-form-label col-form-label-sm mt-1"
              for="inputSmall"
              >모임 키워드(1)</label
            >
            <input
              class="form-control form-control-sm"
              type="text"
              placeholder="ex) #여행홀릭"
              id="inputSmall"
            />
          </div>

          <div class="form-group">
            <label
              class="col-form-label col-form-label-sm mt-1"
              for="inputSmall"
              >모임 키워드(2)</label
            >
            <input
              class="form-control form-control-sm"
              type="text"
              placeholder="ex) #여행홀릭"
              id="inputSmall"
            />
          </div>

          <div class="form-group">
            <label
              class="col-form-label col-form-label-sm mt-1"
              for="inputSmall"
              >모임 키워드(3)</label
            >
            <input
              class="form-control form-control-sm"
              type="text"
              placeholder="ex) #여행홀릭"
              id="inputSmall"
            />
          </div>

          <div class="form-group">
            <label
              class="col-form-label col-form-label-sm mt-1"
              for="inputSmall"
              >모임 키워드(4)</label
            >
            <input
              class="form-control form-control-sm"
              type="text"
              placeholder="ex) #여행홀릭"
              id="inputSmall"
            />
          </div>

          <div class="form-group">
            <label
              class="col-form-label col-form-label-sm mt-1"
              for="inputSmall"
              >모임 키워드(5)</label
            >
            <input
              class="form-control form-control-sm"
              type="text"
              placeholder="ex) #여행홀릭"
              id="inputSmall"
            />
          </div>

          <div class="button-form">
            <button type="button" class="btn btn-primary btn-lg">
              Large button
            </button>
            <button type="button" class="btn btn-secondary btn-lg">
              Large button
            </button>

            <!-- TODO: alert 창 띄우기 -->
          </div>
        </form>
      </div>
    </div>
		
		<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>