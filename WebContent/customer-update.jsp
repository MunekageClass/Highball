<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.CustomerBean,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報編集画面</title>
<link rel="stylesheet" type="text/css" href="css/customer-update.css">
</head>
<body>
	<%@ include file="header-login.jsp"%>
	<%
		CustomerBean customer = (CustomerBean) session.getAttribute("customer");
	%>
	<!-- リストを追加 -->
	<%
		List<CustomerBean> areaList = (List<CustomerBean>) session.getAttribute("areaList");
		List<CustomerBean> userList = (List<CustomerBean>) session.getAttribute("userList");
	%>

	<h1>顧客情報編集画面</h1>
	<form action="customer-update" method="post">


		<table border="1" style="table-layout: fixed">
			<tr>
				<th></th>
				<th>顧客名称</th>
				<th>顧客名称かな</th>
				<th>郵便番号</th>
				<th>所在地</th>
				<th>地区コード</th>
				<th>担当者名</th>
				<th>担当者名かな</th>
				<th>担当者電話番号</th>
				<th>担当者コード</th>
			</tr>
			<tr>
				<td>前</td>
				<td><%=customer.getCm_name()%></td>
				<td><%=customer.getCm_name_kana()%></td>
				<td><%=customer.getPt_code()%></td>
				<td><%=customer.getAddress()%></td>
				<td><%=customer.getArea_code()%></td>
				<td><%=customer.getCt_person_name()%></td>
				<td><%=customer.getCt_person_name_kana()%></td>
				<td><%=customer.getCt_person_tel()%></td>
				<td><%=customer.getUser_id()%></td>
			</tr>
			<tr>
				<td>後</td>
				<td><input type="text" name="customer_name" size="20"></td>
				<td><input type="text" name="customer_name_kana"></td>
				<!-- 変更箇所：郵便番号 -->
				<td><input type="text" name="postal_code" pattern="\d{3}-\d{4}"
					title="3桁の数字－(ハイフン)4桁の数字"></td>
				<td><input type="text" name="address"></td>
				<!-- 変更箇所：地区コード -->
				<td><select name="area_code" title="エリアコードを選択してください">
						<option value=""></option>
						<%
							for (int i = 0; i < areaList.size(); i++) {
						%>
						<option value=<%=areaList.get(i).getArea_code()%>><%=areaList.get(i).getArea_name()%></option>
						<%
							}
						%>
				</select></td>
				<td><input type="text" name="contact_person_name"></td>
				<td><input type="text" name="contact_person_name_kana"></td>
				<td><input type="text" name="contact_person_tel"></td>
				<!-- 変更箇所：ユーザーID -->
				<td><select name="user_id" title="ユーザIDを選択してください">
						<option value=""></option>
						<%
							for (int i = 0; i < userList.size(); i++) {
						%>
						<option value=<%=userList.get(i).getUser_id()%>><%=userList.get(i).getUser_name()%></option>
						<%
							}
						%>
				</select></td>
			</tr>
		</table>
		顧客ID：<%=customer.getCm_id()%>
		さんの情報を編集します。<br> ※空欄の場合は、編集されません。


		<!--
	<input type="text" name="customer_name" size="5">
	<input type="text" name="customer_name_kana" size="10">
	<input type="text" name="postal_code" size="5">
	<input type="text" name="address" size="5">
	<input type="text" name="area_code" size="5">
	<input type="text" name="contact_person_name" size="5">
	<input type="text" name="contact_person_name_kana" size="5">
	<input type="text" name="contact_person_tel" size="5">
	<input type="text" name="user_id" size="5"> -->
		<!--     <table>
    <tr>
		<th><input type="text" name="customer_name" size="20"></th>
		<th><input type="text" name="customer_name_kana" ></th>
		<th><input type="text" name="postal_code" ></th>
		<th><input type="text" name="address" ></th>
		<th><input type="text" name="area_code" ></th>
		<th><input type="text" name="contact_person_name" ></th>
		<th><input type="text" name="contact_person_name_kana" ></th>
		<th><input type="text" name="contact_person_tel" ></th>
		<th><input type="text" name="user_id" ></th>
	</tr>
    </table> -->
		<br> <input type="submit" value="編集する">
	</form>
</body>
</html>