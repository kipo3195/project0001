<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <meta charset="utf-8">
  <meta name="`port" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Landing Page - Start Bootstrap Theme</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/landing-page.min.css" rel="stylesheet">
<%@ include file="../common/navigator.jsp" %>
</head>
<body>
    <div>
     	<a href="regist">글 작성하기</a>
    </div>

    <table class="table" border="1">
    	<tr>
    		<td>글 번호</td>
    		<td>글 제목</td>
    		<td>작성자</td>
    		<td>등록일</td>
    		<td>최종수정일</td>
    	</tr>
   		<c:choose>
   		<c:when test="${not empty Board}">
   			<c:forEach items="${Board}" var="board">
	   				<tr onclick="location.href='detail?bNum=${board.BNum}'" style="cursor:hand">
	   					<td>${board.BNum}</td>
	   					<td>${board.BTitle}</td>
	   					<td>${board.BAuth}</td>
	   					<td>${board.regDate}</td>
	   					<td>${board.updateDate}</td>
	   				</tr>
   			</c:forEach>
   		</c:when>
   		
		<c:otherwise>
			<tr>
				<td colspan="5" class="text-center">
					게시물이 존재하지 않습니다.
				</td>
			</tr>							
		</c:otherwise>   
    </c:choose>
    </table>
    <!-- 페이징 블럭 -->
    	<div>
    		<c:if test="${pm.first}">
    			<a href="main?page=1" class="btn btn-outline-success">처음</a>
    		</c:if>
    		<c:if test="${pm.prev}">
   				<a href="main?page=${pm.endPage-1}" class="btn btn-outline-primary">이전</a>
   			</c:if>
    		<c:forEach var="i" begin="${pm.startPage}" end="${pm.endPage}">
    			  <a class="btn btn-primary" href="main?page=${i}">${i}</a>
   			</c:forEach>
   			<c:if test="${pm.next}">
   				<a href="main?page=${pm.endPage+1}" class="btn btn-outline-primary">다음</a>
   			</c:if>
   			<c:if test="${pm.last}">
   				<a href="main?page=${pm.maxPage}" class="btn btn-outline-success">마지막</a>
   			</c:if>
   		</div>
   		
</body>
		
<script>
	var msg ='${message}';
	if(msg == 'S'){
		alert('처리완료!');
	}else if(msg == 'F'){
		alert('요청 처리실패');
	}
	
		

	
	
</script>
