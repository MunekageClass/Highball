<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.List,model.entity.CustomerBean"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顧客情報一覧</title>
<link rel="stylesheet" type="text/css" href="css/customer-list.css">
</head>
<body>
	<%@ include file = "header-login.jsp" %>
	<%
		if (session.getAttribute("user_name") != null) {
	%>
		<%
			List<CustomerBean> customerList
				= (List<CustomerBean>) request.getAttribute("customerList");
		%>



		<%
			if(!(customerList.isEmpty() ) ){
		%>
			<h3>顧客情報一覧</h3>
			<table border = 1 style = "border-collapse: collapse; border:solid 1px;">

				<tr>
					<th>顧客ID</th>
					<th>顧客名称</th>
					<th>顧客名称かな</th>
					<th>郵便番号</th>
					<th>所在地</th>
					<th>地区名</th>
					<th>担当者名</th>
					<th>担当者名かな</th>
					<th>担当者電話番号</th>
					<th>営業担当者情報</th>
			</tr>

			<%
				for (CustomerBean customer : customerList) {
			%>
				<tr>	<!-- 各データを追加していく -->
				<td>
					<%if(!(customer.getCm_id()==0)){%>
						<%=customer.getCm_id() %>
					<%}%>
				</td>
				<td>
					<%if(!(customer.getCm_name()==null)){%>
						<%=customer.getCm_name() %>
					<%}%>
				</td>
				<td>
					<%if(!(customer.getCm_name_kana()==null)){%>
						<%=customer.getCm_name_kana() %>
					<%}%>
				</td>
				<td>
				<%if(!(customer.getPt_code()==null)){%>
					<%=customer.getPt_code() %>
				<%}%>
				</td>
				<td>
					<%if(!(customer.getAddress()==null)){%>
						<%=customer.getAddress() %>
					<%}%>
				</td>
				<td>
					<%if(!(customer.getArea_code()==null)){%>
						<%=customer.getArea_name() %>
					<%}%>
				</td>
				<td>
					<%if(!(customer.getCt_person_name()==null)){%>
						<%=customer.getCt_person_name() %>
					<%}%>
				</td>
				<td>
					<%if(!(customer.getCt_person_name_kana()==null)){%>
						<%=customer.getCt_person_name_kana() %>
					<%}%>
				</td>
				<td>
					<%if(!(customer.getCt_person_tel()==null)){%>
						<%=customer.getCt_person_tel() %>
					<%}%>
				</td>
				<td>
					<%if(!(customer.getUser_id()==null)){%>
						<%=customer.getUser_name() %>
					<%}%>
				</td>

				<td>
				<form action="customer-update-servlet" method="POST">
					<button type='submit' name='customer_id' value=<%=customer.getCm_id()%>>編集する</button>
				</form>
				</td>

				<td>
				<form action="customer-delete-servlet" method="POST">
					<button type='submit' name='customer_id' value=<%=customer.getCm_id()%>>削除する</button>
				</form>
				</td>
				</tr>
			<%
			}
			%>

			</table>

		<%
			}else{
		%>

			顧客情報がありません<br>
			<a href="menu.jsp">メニュー画面に戻る</a>

		<%
			}
		%>


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