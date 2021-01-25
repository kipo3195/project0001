<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script  src="http://code.jquery.com/jquery-latest.min.js"></script>

    <head>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
     	<button class="button" id="insert">수정</button>
     	<button class="button" id="delete">삭제</button>
    </div>
			<c:if test="${not empty VO}">
			<form id="insertForm">
			    <table class="table" border="1">
			    	<tr>
						<td><input type="hidden" name="bNum" value="${VO.BNum}" readonly/></td>
					</tr>	
					<tr>
						<td>글 제목</td>
						<td><input type="text" name="bTitle" value="${VO.BTitle}" readonly/></td>
					</tr>		
					<tr>
						<td>내용</td>
						<td><textarea name="bContent" readonly>${VO.BContent}</textarea></td>
					</tr>		
					<tr>
						<td>작성자</td>
						<td><input type="text" name="bAuth" value="${VO.BAuth}" readonly/></td>
					</tr>	
			    </table>
			  </form>
		</c:if>
    	
    	
   
</body>

<script>

		$(function(){
			
		var form = $("#insertForm");
			$("#insert").click(function(){
				form.attr("action","insert");
				form.attr("method","GET");
				form.submit();
			});
		
			$("#delete").click(function() {
				form.attr("action","delete");
				form.attr("method","post");
				form.submit();
			});
		});
	

</script>
