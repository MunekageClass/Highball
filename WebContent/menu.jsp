<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
<link rel="stylesheet" type="text/css" href="css/menu.css">
</head>
<body>

		<%
			if (session.getAttribute("user_name") != null) {
		%>
			<!-- ヘッタ挿入 -->
			<%@ include file = "header-login.jsp" %>
			<h1>メニュー</h1>
			<div align="center">
			<form action="customer-registration-servlet" method="POST" style="position: centor" >
				<input type="submit" value="顧客情報を登録する" class="registration">
			</form>
			</div>


			<br>

			<div align="center" style="">
			<form action="customer-list-servlet" method="POST" >
				<input type="submit" value="顧客一覧を表示する" class="list">
			</form>
			</div>


		<%
			}else{
		%>

			ログイン認証がされていません
			<a href="login.jsp">ログイン画面に戻る</a>

		<%
			}
		%>

</body>
</html>