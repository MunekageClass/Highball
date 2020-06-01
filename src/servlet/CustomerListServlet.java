package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CustomerDAO;
import model.entity.CustomerBean;;
/**
 * Servlet implementation class Employee
 */
@WebServlet("/customer-list-servlet")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		// レスポンスのコンテンツタイプおよびエンコーディング方式を指定
		response.setContentType("text/html; charset=UTF-8");


		List<CustomerBean> customerList = null;
		List<CustomerBean> areaList=new ArrayList<CustomerBean>();
		List<CustomerBean> userList=new ArrayList<CustomerBean>();
		CustomerDAO dao = new CustomerDAO();

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try {
			customerList = dao.selectAll();
			areaList = dao.selectArea();
			userList = dao.selectUser();
			for(CustomerBean customer : customerList) {
				for(CustomerBean area : areaList) {
					for(CustomerBean user : userList) {
						if(user.getUser_id().equals(customer.getUser_id())) {
							customer.setUser_name(user.getUser_name());
						}
						if(area.getArea_code().equals(customer.getArea_code())) {
							customer.setArea_name(area.getArea_name());
						}
					}
				}
			}
			// リクエストスコープへの属性の設定
			request.setAttribute("customerList", customerList);

			// リクエストの転送 今回は顧客一覧jspに送る
			RequestDispatcher rd = request.getRequestDispatcher("customer-list.jsp");
			rd.forward(request, response);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}