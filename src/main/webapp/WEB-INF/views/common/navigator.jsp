<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- Navigation -->
  <nav class="navbar navbar-light bg-light static-top">
    <div class="container">
      
      <a class="navbar-brand" href="/CRUD">HOME</a>
      <a class="navbar-brand" href="board/main">View table List</a>
      
      	<c:choose>
    	  	<c:when test="${member == null}">
	    		  <a class="btn btn-outline-primary" href="member/join">회원가입</a>
	   			  <a class="btn btn-primary" href="member/login">로그인</a>
	   	  	</c:when>
	   	  	<c:otherwise>
	   	  		<a href="#">Welcome! ${member.username}님 환영합니다.  </a>
	   	  		 <a class="btn btn-danger" href="member/logout">로그아웃</a>
	   	  	</c:otherwise>
	   	</c:choose>
    </div>
    <div>
    </div>
    
  </nav>