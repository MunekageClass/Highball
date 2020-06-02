<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報削除確認画面</title>
<link rel="stylesheet" type="text/css" href="css/customer-delete-confirmation.css">
</head>
<body>
<%@ include file="header-login.jsp"%>

<h1>顧客情報削除確認</h1>
<br>
<%CustomerBean delete_customer=(CustomerBean)session.getAttribute("delete_customer"); %>

<p>
顧客ID：<%=delete_customer.getCm_id() %>さんの顧客情報を削除してよろしいですか？
</p>

<br>
<table border = 1 style = "border-collapse: collapse; border:solid 1px;">
<tr><th>顧客名称</th>
	<th>顧客名称かな</th>
	<th>郵便番号</th>
	<th>所在地</th>
	<th>地区情報</th>
	<th>担当者名</th>
	<th>担当者名かな</th>
	<th>担当者電話番号</th>
	<th>営業担当者情報</th>
</tr>
<tr><td><%if(!(delete_customer.getCm_name()==null)){ %>
		<%=delete_customer.getCm_name() %>
	<%} %></td>

	<td><%if(!(delete_customer.getCm_name_kana()==null)){ %>
		<%=delete_customer.getCm_name_kana() %>
	<%} %></td>

	<td><%if(!(delete_customer.getPt_code()==null)){ %>
		<%=delete_customer.getPt_code() %>
	<%} %></td>

	<td><%if(!(delete_customer.getAddress()==null)){ %>
		<%=delete_customer.getAddress() %>
	<%} %></td>

	<td><%if(!(delete_customer.getArea_name()==null)){ %>
		<%=delete_customer.getArea_name() %>
	<%} %></td>

	<td><%if(!(delete_customer.getCt_person_name()==null)){ %>
		<%=delete_customer.getCt_person_name() %>
	<%} %></td>

	<td><%if(!(delete_customer.getCt_person_name_kana()==null)){ %>
		<%=delete_customer.getCt_person_name_kana() %>
	<%} %></td>

	<td><%if(!(delete_customer.getCt_person_tel()==null)){ %>
		<%=delete_customer.getCt_person_tel() %>
	<%} %></td>

	<td><%if(!(delete_customer.getUser_name()==null)){ %>
		<%=delete_customer.getUser_name() %>
	<%} %></td>


</tr>
</table>
<form action="customer-delete" method="post">
<input type="submit" value="削除" class="delete">
</form>

<form action="customer-list-servlet" method="POST">
		<button type='submit' class="list">顧客一覧に戻る</button>
	</form>

</body>
</html>