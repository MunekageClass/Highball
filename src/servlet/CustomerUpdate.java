package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.CustomerDAO;
import model.entity.CustomerBean;

/**
 * Servlet implementation class CustomerUpdate
 */
@WebServlet("/customer-update")
public class CustomerUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdate() {
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

		request.setCharacterEncoding("UTF-8");
		//セッションオブジェクトの取得
		HttpSession session = request.getSession();

		//スコープからの属性値の取得
		String customer_name = request.getParameter("customer_name");
		String customer_name_kana = request.getParameter("customer_name_kana");
		String postal_code = request.getParameter("postal_code");
		String address = (String) request.getParameter("address");
		String area_code = request.getParameter("area_code");
		String contact_person_name = request.getParameter("contact_person_name");
		String contact_person_name_kana = request.getParameter("contact_person_name_kana");
		String contact_person_tel = request.getParameter("contact_person_tel");
		String user_id = request.getParameter("user_id");


		CustomerBean customer = new CustomerBean();
		customer = (CustomerBean) session.getAttribute("customer");
		List<CustomerBean> userList = (List) session.getAttribute("userList");
		List<CustomerBean> areaList = (List) session.getAttribute("areaList");

		if (!(customer_name.equals(""))) {
			customer.setCm_name(customer_name);
		}

		if (!(customer_name_kana.equals(""))) {
			customer.setCm_name_kana(customer_name_kana);
		}

		if (!(postal_code.equals(""))) {
			customer.setPt_code(postal_code);
		}

		if (!(address.equals(""))) {
			customer.setAddress(address);
		}

		if (!(area_code.equals(""))) {
			customer.setArea_code(area_code);
		}

		if (!(contact_person_name.equals(""))) {
			customer.setCt_person_name(contact_person_name);
		}
		if (!(contact_person_name_kana.equals(""))) {
			customer.setCt_person_name_kana(contact_person_name_kana);
		}
		if (!(contact_person_tel.equals(""))) {
			customer.setCt_person_tel(contact_person_tel);
		}
		if (!(user_id.equals(""))) {
			customer.setUser_id(user_id);
		}
		//area_nameの設定
		for(CustomerBean cus:areaList) {
			if(customer.getArea_code().equals(cus.getArea_code())) {
				customer.setArea_name(cus.getArea_name());
			}
		}
		//user_nameの設定}
		for(CustomerBean cus:userList) {
			if(customer.getUser_id().equals(cus.getUser_id())) {
				customer.setUser_name(cus.getUser_name());
			}
		}


		//DAOの生成
		CustomerDAO dao = new CustomerDAO();

		int processingNumber = 0;

		try {
			//DAO（顧客情報編集）の利用
			processingNumber = dao.update(customer);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		//セッションスコープへの属性設定
		session.setAttribute("customer", customer);
		request.setAttribute("processingNumber", processingNumber);

		RequestDispatcher rd = request.getRequestDispatcher("customer-update-fin.jsp");
		rd.forward(request, response);

	}
}