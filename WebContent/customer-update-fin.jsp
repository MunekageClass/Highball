<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報編集 完了画面</title>
<link rel="stylesheet" type="text/css" href="css/customer-update-fin.css">
</head>
<body>
	<%@ include file = "header-login.jsp" %>
	<%
	request.setCharacterEncoding("UTF-8");
	int processingNumber = (int) request.getAttribute("processingNumber");
	CustomerBean customer = (CustomerBean) session.getAttribute("customer");



	if(processingNumber != 0){
	%>
	<h1>顧客情報変更完了</h1>
	<p>顧客情報は以下のように変更されました。</p>
	 <table border="1">
    <tr>
    	<th>顧客名称</th>
      	<th>顧客名称かな</th>
      	<th>郵便番号</th>
      	<th>所在地</th>
      	<th>地区情報</th>
      	<th>担当者名</th>
      	<th>担当者名かな</th>
      	<th>担当者電話番号</th>
      	<th>営業担当者情報</th>
    </tr>

    <tr>
    	<td><%=customer.getCm_name() %></td>
    	<td><%=customer.getCm_name_kana() %></td>
		<td><%=customer.getPt_code() %></td>
		<td><%=customer.getAddress() %></td>
		<td><%=customer.getArea_name() %></td>
		<td><%=customer.getCt_person_name() %></td>
		<td><%=customer.getCt_person_name_kana() %></td>
		<td><%=customer.getCt_person_tel() %></td>
		<td><%=customer.getUser_name() %></td>
    </tr>
    </table>
    <form action="menu.jsp" method="post">
    	<input type="submit" value="メニューに戻る" class="menu">
    </form>
    <form action="customer-list-servlet" method="post">
    	<input type="submit" value="一覧に戻る" class="list">
    </form>







    <%} else { %>
	<h1>顧客情報変更失敗</h1>
	<p>以下の顧客情報の変更に失敗しました</p><br>

	<div class="table1">
	<table border = 1 style = "border-collapse: collapse; border:solid 1px;">
	<tr>
		<th>顧客名称</th>
		<th>顧客名称かな</th>
		<th>郵便番号</th>
		<th>所在地</th>
		<th>地区情報</th>
		<th>担当者名</th>
		<th>担当者名かな</th>
		<th>担当者電話番号</th>
		<th>営業担当者情報</th>
	</tr>
	<tr>
		<td><%=customer.getCm_name() %></td>
		<td><%=customer.getCm_name_kana() %></td>
		<td><%=customer.getPt_code() %></td>
		<td><%=customer.getAddress() %></td>
		<td><%=customer.getArea_name() %></td>
		<td><%=customer.getCt_person_name() %></td>
		<td><%=customer.getCt_person_name_kana() %></td>
		<td><%=customer.getCt_person_tel() %></td>
		<td><%=customer.getUser_name() %></td>
	</tr>
	</table>
	</div>
    <br>
	<div class="table2">
    <form action="menu.jsp" method="post">
    	<input type="submit" value="メニューに戻る" class="menu">
    </form>
    <br>
    <form action="customer-list-servlet" method="post">
    	<input type="submit" value="一覧に戻る" class="list">
    </form>
    </div>
	<%} %>
</body>
</html>