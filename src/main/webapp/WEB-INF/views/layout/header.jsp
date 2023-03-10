<%@ page language="java" contentType="text/html; charset=UTF-16"  pageEncoding="UTF-16"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- 로그인이 되었는지 안되었는지 확인할 수 있는 코드 -->
<sec:authorize access = "isAuthenticated()">
	<sec:authentication property = "principal" var = "principal"/>
	<!-- principal이라는 변수 안에는 로그인 세션이 담겨있음 -->
</sec:authorize>

 <!DOCTYPE html>
<html lang="en">
<head>

  <title>Sujung 블로그</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- ajax 통신을 위한 meta tag -->
 <meta name="_csrf" content="${_csrf.token}">
 <meta name="_csrf_header" content="${_csrf.headerName}">
  <link rel="stylesheet" 
  href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <link rel="stylesheet" 
  href="/css/custom.css">
 <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.1/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
  
</head>
<body>

<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" href="/">❤️Sujung's portfolio❤️</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
  
  <c:choose>
  	<c:when test="${empty principal}">
  	  <ul class="navbar-nav">
      <li class="nav-item"><a class="nav-link" href="/auth/loginForm">로그인</a> </li>
      <li class="nav-item"><a class="nav-link" href="/auth/joinForm">회원가입</a></li>
    </ul>
  	</c:when>
  	<c:otherwise>
      <li class="nav-item"><a class="nav-link" href="/board/saveForm">글쓰기</a> </li>
      <li class="nav-item"><a class="nav-link" href="/user/updateForm">회원정보</a></li>
      <li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
    </ul>   
  	</c:otherwise>
  </c:choose>
  

 
  </div>  
</nav>
<br />