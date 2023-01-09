<%@ page language="java" contentType="text/html; charset=UTF-16"  pageEncoding="UTF-16"%>

<%@ include file = "../layout/header.jsp" %>

<div class="container">

<form >
  <div class="form-group">
    <label for="username">닉네임</label>
    <input type="text" class="form-control" placeholder="닉네임을 입력하세요" id="username">
  </div>
  
    <div class="form-group">
    <label for="pwd">패스워드</label>
    <input type="password" class="form-control" placeholder="패스워드를 입력하세요" id="password">
  </div>
  
    <div class="form-group">
    <label for="email">이메일</label>
    <input type="email" class="form-control" placeholder="이메일을 입력하세요" id="email">
  </div>
 


</form>

  <button id = "btn-save" class="btn btn-primary">회원가입 완료</button>
  
</div>

<script src="/js/user.js"></script>

<%@ include file = "../layout/footer.jsp" %>