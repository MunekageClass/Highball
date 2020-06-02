<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト</title>
<link rel="stylesheet" type="text/css" href="css/logout.css">
</head>
<body>
	<%@ include file = "header-logout.jsp" %>
	<form action="login.jsp" method="POST">
		<p class="logouted">ログアウトしました。</p>
		<input type="submit" value="ログイン画面に戻る" class="tologin">
	</form>

</body>
</html>