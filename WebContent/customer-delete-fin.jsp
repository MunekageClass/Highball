<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.entity.CustomerBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報削除完了画面</title>
<link rel="stylesheet" type="text/css" href="css/customer-delete-fin.css">
</head>
<body>

<%@ include file="header-login.jsp"%>
<%--成功・失敗のフラグを受け取る--%>
<%
	request.setCharacterEncoding("UTF-8");
	int flg=(int)request.getAttribute("flg");
%>

<%CustomerBean delete_customer=(CustomerBean)session.getAttribute("delete_customer"); %>
<%--削除完了--%>
<%if(flg==1){ %>
<h2>削除完了画面</h2>
以下の顧客情報を削除しました。<br>
顧客ID：<%=delete_customer.getCm_id() %><br>
<table border = 1 style = "border-collapse: collapse; border:solid 1px;">
<tr><th>顧客名称</th>
	<th>顧客名称かな</th>
	<th>郵便番号</th>
	<th>所在地</th>
	<th>地区情報</th>
	<th>担当者名</th>
	<th>担当者名かな</th>
	<th>担当者電話番号</th>
	<th>営業担当者情報</th></tr>
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
<br>
<form action="menu.jsp" method="post" >
<input type="submit" value="メニュー">
</form>

<form action="customer-list-servlet" method="post" >
<input type="submit" value="一覧に戻る">
</form>



<%} else{ %><%--削除失敗 --%>
<h2>削除エラー画面</h2>
以下の顧客情報の削除に失敗しました<br>
顧客ID：<%=delete_customer.getCm_id() %><br>
<table border = 1 style = "border-collapse: collapse; border:solid 1px;">
<tr><th>顧客名称</th>
	<th>顧客名称かな</th>
	<th>郵便番号</th>
	<th>所在地</th>
	<th>地区情報</th>
	<th>担当者名</th>
	<th>担当者名かな</th>
	<th>担当者電話番号</th>
	<th>営業担当者情報</th></tr>
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

	<td><%if(!(delete_customer.getArea_code()==null)){ %>
		<%=delete_customer.getArea_code() %>
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

	<td><%if(!(delete_customer.getUser_id()==null)){ %>
		<%=delete_customer.getUser_id() %>
	<%} %></td>
</tr>
</table>

<form action="customer-list-servlet" method="post">
<input type="submit" value="一覧に戻る">
</form>
<%} %>
</body>
</html>