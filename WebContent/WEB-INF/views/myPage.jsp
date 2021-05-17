<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
 <style>
      .content {
        width: 760px;
      }
      .content-wrap {
        margin-top: 100px;
        margin-bottom: 100px;
        display: flex;
        justify-content: center;
      }
      .nav-item {
        width: 380px;
        text-align: center;
      }
      .updateMyInfo {
        height: 900px;
        width: 760px;
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 0;
        border: 1px solid #ddd;
        border-top: 0;
        border-bottom-left-radius: 1.5%;
        border-bottom-right-radius: 1.5%;
      }
      form > div {
        width: 550px;
      }
      .juso > input {
        width: 452px;
        float: left;
      }
      .form-label {
        margin-top: 0;
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
    <div class="content-wrap">
      <div class="content">
        <ul class="nav nav-tabs">
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="tab" href="#myPage"
              >마이페이지</a
            >
          </li>
          <li class="nav-item">
            <a class="nav-link" data-bs-toggle="tab" href="#updateMyInfo"
              >내 정보수정</a
            >
          </li>
        </ul>
        <div id="myTabContent" class="tab-content">
          <div class="tab-pane fade" id="myPage">
            <div class="myPage">
              <div class="manageMoim-wrap"></div>
            </div>
          </div>
          <div class="tab-pane fade active show" id="updateMyInfo">
            <div class="updateMyInfo-wrap">
              <div class="updateMyInfo">
                <form action="#">
                  <div class="form-group">
                    <fieldset disabled="">
                      <label class="form-label" for="memberId">ID</label>
                      <input
                        class="form-control"
                        id="memberId"
                        type="text"
                        placeholder="당신의 ID"
                        disabled=""
                      />
                    </fieldset>
                  </div>
                  <div class="form-group">
                    <label for="memberPw" class="form-label mt-4"
                      >비밀번호</label
                    >
                    <input
                      type="password"
                      class="form-control"
                      id="memberPw"
                      placeholder="변경할 비밀번호를 입력해주세요."
                    />
                  </div>

                  <div class="form-group">
                    <label for="memberPw" class="form-label mt-4"
                      >비밀번호 확인</label
                    >
                    <input
                      type="password"
                      class="form-control"
                      id="memberPw"
                      placeholder="변경할 비밀번호를 다시 입력해주세요."
                    />
                  </div>
                  <hr />
                  <div class="form-group">
                    <fieldset disabled="">
                      <label class="form-label" for="memberName">이름</label>
                      <input
                        class="form-control"
                        id="memberName"
                        type="text"
                        placeholder="당신의 이름"
                        disabled=""
                      />
                    </fieldset>
                  </div>
                  <hr />
                  <div class="form-group">
                    <fieldset disabled="">
                      <label class="form-label" for="memberPhone"
                        >전화번호</label
                      >
                      <input
                        class="form-control"
                        id="memberPhone"
                        type="text"
                        placeholder="당신의 전화번호"
                        disabled=""
                      />
                    </fieldset>
                  </div>
                  <hr />
                  <div class="form-group">
                    <div class="juso">
                      <fieldset>
                        <label class="form-label" for="post-button">주소</label>
                      </fieldset>
                      <input
                        type="text"
                        id="postCode"
                        class="short form-control"
                        readonly=""
                      />
                      <button
                        onclick="addSearch();"
                        class="btn btn-primary"
                        id="post-button"
                      >
                        주소검색
                      </button>
                    </div>

                    <div>
                      <input
                        type="text"
                        id="roadAddr"
                        class="form-control"
                        placeholder="도로명주소"
                        readonly
                      />
                    </div>

                    <div>
                      <input
                        type="text"
                        id="jibunAddr"
                        class="form-control"
                        placeholder="지번주소"
                        readonly
                      />
                    </div>

                    <div>
                      <input
                        type="text"
                        id="detailAddr"
                        placeholder="상세주소"
                        class="form-control"
                      />
                    </div>
                  </div>

                  <div class="button-form">
                    <button type="button" class="btn btn-primary btn-lg">
                      Large button
                    </button>
                    <button type="button" class="btn btn-secondary btn-lg">
                      Large button
                    </button>
                  </div>
                  <!-- TODO: alert 창 띄우기 -->
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
  <script>
    function addSearch() {
      new daum.Postcod({
        oncomplete: function (data) {
          $("#postCode").val(data.zonecode);
          $("#roadAddr").val(data.roadAddress);
          $("#jibunAddr").val(data.jibunAddress);
          $("#detailAddr").focus();
        },
      }).open();
    }
  </script>
</html>
