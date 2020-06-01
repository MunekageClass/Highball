<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログアウト</title>
</head>
<body>
	<%@ include file = "header-logout.jsp" %>
	<form action="login.jsp" method="POST">
		<h3>ログアウトしました。</h3>
		<input type="submit" value="ログイン画面に戻る">
	</form>

</body>
</html>