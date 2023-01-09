<%@ page language="java" contentType="text/html; charset=UTF-16"  pageEncoding="UTF-16"%>

<%@ include file = "../layout/header.jsp" %>

<div class="container">

<form action="/action/loginProc" method = "post">
  
  <div class="form-group">
    <label for="username">닉네임</label>
    <input type="text"  name = "username" class="form-control" placeholder="닉네임을 입력하세요" id="username">
  </div>
  
  <div class="form-group">
    <label for="pwd">패스워드</label>
    <input type="password" name = "password" class="form-control" placeholder="패스워드를 입력하세요" id="password">
  </div>
  
    <button id="btn-login" class="btn btn-primary">로그인</button>
</form>

  
</div>

<%@ include file = "../layout/footer.jsp" %>