<%@ page pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/header-login.css">
<div class="background">
	<br>

	<div class="title">顧客管理システム</div>
	<form action="logout-servlet" method="POST">
		<input type="submit" value="ログアウト" class="logout">
	</form>

	<div class="login-user">
		ログインユーザー：<%=(String) session.getAttribute("user_name")%>さん
	</div>

	<br>
	<hr>
</div>