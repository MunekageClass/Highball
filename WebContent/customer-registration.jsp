<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List,model.entity.CustomerBean"%>
<!DOCTYPE  html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報登録画面</title>
<link rel="stylesheet" type="text/css" href="css/customer-registration.css">
<link rel="stylesheet" type="text/css" href="css/customer-registration.css">
</head>

<body>
<%@ include file="header-login.jsp"%>
	<form action="customer-registration" method="post">
		<h1>顧客情報登録</h1>

		<%
			List<CustomerBean> userList = (List) session.getAttribute("userList");
			List<CustomerBean> areaList = (List) session.getAttribute("areaList");
		%>
		<table border=1 style="border-collapse: collapse; border: solid 1px;" class="table">
			<tbody>
				<tr>
					<th align="left">顧客名称</th>
					<th align="left">顧客名称かな</th>
					<th align="left">郵便番号</th>
					<th align="left">所在地</th>
					<th align="left">地区情報</th>
					<th align="left">担当者名</th>
					<th align="left">担当者名かな</th>
					<th align="left">担当者電話番号</th>
					<th align="left">営業担当者情報</th>
				</tr>
				<tr>

					<td><input type="text" name="customer_name" pattern=".*\S+.*"title="顧客名称が未入力です" required></td>
					<td><input type="text" name="customer_name_kana"></td>
					<td><input type="text" name="postal_code" pattern="\d{3}-\d{4}" title="3桁の数字-(ハイフン)4桁の数字"></td>
					<td><input type="text" name="address"></td>
					<td><select name="area_code">
							<%
								for (CustomerBean customer : areaList) {
							%>
							<option value="<%=customer.getArea_code()%>"><%=customer.getArea_name()%></option>
							<%
								}
							%>
					</select></td>
					<td><input type="text" name="contact_person_name"></td>
					<td><input type="text" name="contact_person_name_kana"></td>
					<td><input type="text" name="contact_person_tel"></td>
					<td><select name="user_id">
							<option value="<%=request.getAttribute("user_id")%>"><%=request.getAttribute("user_name")%></option>
							<%
								for (CustomerBean customer : userList) {
									if(request.getAttribute("user_id").equals(customer.getUser_id())) {

									} else {
							%>
							<option value="<%=customer.getUser_id()%>"><%=customer.getUser_name()%></option>
							<%
									}
								}
							%>
					</select></td>
				</tr>
			</tbody>
		</table>
		<hr>
		<input type="submit" value="登録する">
	</form>
</body>
</html>