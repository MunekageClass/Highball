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
 * Servlet implementation class CustomerDeleteServlet
 */
@WebServlet("/customer-delete-servlet")
public class CustomerDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログイン認証済みか確認し、顧客削除確認画面に遷移

		//リクエストの受け取り
		request.setCharacterEncoding("UTF-8");
		int customer_id= Integer.parseInt(request.getParameter("customer_id"));

		String url;
		CustomerBean customer=new CustomerBean();
		/*追加*/
		List<CustomerBean> areaList=new ArrayList<CustomerBean>();
		List<CustomerBean> userList=new ArrayList<CustomerBean>();

		//DAOの生成
		CustomerDAO dao=new CustomerDAO();

		//sessionオブジェクトの取得
		HttpSession session=request.getSession();

		if(session.getAttribute("user_name")!=null){
			//認証済み
			url="customer-delete-confirmation.jsp";
			try {
				//すべての顧客情報から削除する顧客情報を抜き出す。
				List<CustomerBean> customerList = new ArrayList<CustomerBean>();
				customerList=dao.selectAll();
				areaList=dao.selectArea();
				userList=dao.selectUser();

				for(CustomerBean cus:customerList) {
					if(customer_id==cus.getCm_id()) {
						customer=cus;
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

			}catch(SQLException|ClassNotFoundException e) {
				e.getStackTrace();
			}
			session.setAttribute("delete_customer",customer);

		}else {
			//未認証
			url="login.html";
		}

		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);


	}

}