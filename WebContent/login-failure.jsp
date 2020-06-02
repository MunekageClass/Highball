<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン失敗</title>
<link rel="stylesheet" type="text/css" href="css/login-failure.css">
</head>
<body>
	<%@ include file = "header-logout.jsp" %>
	<form action="login.jsp" method="POST">
		<p>ログイン失敗</p>
		<p class="failure">ログインに失敗しました。</p>
		<input type="submit" value="ログイン画面に戻る" class="loginfailbutton">
	</form>
</body>
</html>