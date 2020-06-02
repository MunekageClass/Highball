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

			<form action="customer-registration-servlet" method="POST">
				<input type="submit" value="顧客情報登録" class="menubutton">
			</form>

			<form action="customer-list-servlet" method="POST" >
				<input type="submit" value="顧客一覧表示" class="listbutton">
			</form>

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