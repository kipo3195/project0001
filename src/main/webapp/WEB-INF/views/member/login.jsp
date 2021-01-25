<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<html>
<head>

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

</head>
<body>
<!-- navi -->
  <nav class="navbar navbar-light bg-light static-top">
    <div class="container">
      <a class="navbar-brand" href="/CRUD">홈</a>
   	  <a class="btn btn-primary" href="join">회원가입</a>
    </div>
    <div>
    </div>
   </nav>
 <!-- table -->  
 	<form action="loginsubmit" method="post">
 		<table border="1" class="table">
 			<tr>
 				<th colspan="2">Welcome login!</th>
 			</tr>
 			<tr>
 				<td>아이디</td>
 				<td><input type="text" name="userid" required/></td>
 			</tr>
 			<tr>
 				<td>비밀번호</td>
 				<td><input type="password" name="userpw" required/></td>
 			</tr>
 			<tr>
 				<td colspan="2"><input type="checkbox">아이디 저장</td>
 			</tr>
 			<tr>
 				<td><input type="submit" value="LOGIN" id="submit" class="btn-outline-primary"></td>
 				<td><input type="button" value="PW찾기" id="findPw" ></td>
 			</tr>
 		</table>
 	</form>
 
</body>
<script>
		//jquery이용해서 버튼을 submit 동작하게 만듬
		$(function(){
			$("#findPw").click(function(){
				location.href="#";
			});
		});

</script>
</html>