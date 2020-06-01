<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.entity.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客登録完了</title>
<link rel="stylesheet" type="text/css" href="css/customer-registration-fin.css">
</head>

<body>

	<%@ include file = "header-login.jsp" %>

	<%--成功・失敗のフラグを受け取る--%>
	<%
		int flg = (Integer) request.getAttribute("flg");
		CustomerBean customer = (CustomerBean) request.getAttribute("customer");
	%>


	<%--削除完了--%>
	<%
		if (flg > 0) {
	%>

	以下の情報を登録しました。
	<br>

	<hr>
	<table border=1 style="border-collapse: collapse; border: solid 1px;">
		<tbody>
			<tr>
				<th align="left">顧客名称</th>
				<th align="left">顧客名称かな</th>
				<th align="left">郵便番号</th>
				<th align="left">所在地</th>
				<th align="left">地区名</th>
				<th align="left">担当者名</th>
				<th align="left">担当者名かな</th>
				<th align="left">担当者電話番号</th>
				<th align="left">営業担当者情報</th>
			</tr>
			<tr>
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

		</tbody>
	</table>
	<form action="menu.jsp" method="post">
		<input type="submit" value="メニュー">
	</form>

	<%
		} else {
	%><%--削除失敗 --%>
	以下の情報の登録に失敗しました。
	<br>
	<table border=1 style="border-collapse: collapse; border: solid 1px;">
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
			<td><%=customer.getCm_name()%>　</td>
			<td><%=customer.getCm_name_kana()%></td>
			<td><%=customer.getPt_code()%></td>
			<td><%=customer.getAddress()%></td>
			<td><%=customer.getArea_code()%></td>
			<td><%=customer.getCt_person_name()%></td>
			<td><%=customer.getCt_person_name_kana()%></td>
			<td><%=customer.getCt_person_tel()%></td>
			<td><%=customer.getUser_id()%></td>
		</tr>
	</table>
	<form action="menu.jsp" method="post">
		<input type="submit" value="メニュー">
	</form>
	<%} %>

</body>
</html>