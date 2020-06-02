<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<jsp:include page="header-logout.jsp"/>
</head>
<body>
	<form action="login-servlet" method="POST">
		<!-- <h2>顧客情報管理システム　ログイン</h2> -->
		<p class="userid">ユーザID</p>
		<input type="text" name="user_id" class="name">

		<p class="pass" >パスワード</p>
		<input type="password" name="password" class="password">

		<input type="submit" value="ログイン" class="login">
	</form>
</body>
</html>