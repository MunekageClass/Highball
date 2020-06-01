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
import javax.servlet.http.HttpSession;

import model.dao.CustomerDAO;
import model.entity.CustomerBean;

/**
 * Servlet implementation class CustomerUpdateServlet
 */
@WebServlet("/customer-update-servlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerUpdateServlet() {
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

		int customer_id= Integer.parseInt(request.getParameter("customer_id"));

		//DAOの生成
		CustomerDAO dao = new CustomerDAO();
		//転送先URLの初期化
		String url = "";

		CustomerBean customer = new CustomerBean();
	/*追加箇所１*/
		List<CustomerBean> areaList=new ArrayList<CustomerBean>();
		List<CustomerBean> userList=new ArrayList<CustomerBean>();

		//sessionオブジェクトの取得
		HttpSession session = request.getSession();
		if (session.getAttribute("user_name") != null) {

			//ログイン認証済みの転送先
			url = "customer-update.jsp";
			try {

				List<CustomerBean> customerList = new ArrayList<CustomerBean>();
				customerList = dao.selectAll();
			/*追加箇所２*/
				areaList=dao.selectArea();
				userList=dao.selectUser();

				for(CustomerBean person : customerList) {
					if(customer_id == person.getCm_id()) {
						customer = person;
					}
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
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

			session.setAttribute("customer", customer);
		/*追加箇所３*/
			session.setAttribute("areaList", areaList);
			session.setAttribute("userList", userList);

		} else {
			//未認証の転送先
			url = "login.html";
		}

			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
	}
}