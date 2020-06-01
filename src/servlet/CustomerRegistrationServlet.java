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
 * Servlet implementation class CustomerRegistrationServlet
 */
@WebServlet(description = "ログイン認証済みか確認し、顧客登録に画面遷移", urlPatterns = { "/customer-registration-servlet" })
public class CustomerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistrationServlet() {
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

		// ログイン認証済みか確認し、顧客情報登録画面に遷移

		String url;

		//sessionオブジェクトの取得
		HttpSession session=request.getSession();

		if(session.getAttribute("user_name")!=null){
			//認証済み
			url="customer-registration.jsp";
			List<CustomerBean> userList = null;
			List<CustomerBean> areaList = null;

			CustomerDAO dao = new CustomerDAO();

			try {
				userList = dao.selectUser();
				areaList = dao.selectArea();
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			session.setAttribute("userList", userList);
			session.setAttribute("areaList", areaList);
			request.setAttribute("user_name", session.getAttribute("user_name"));
			request.setAttribute("user_id", session.getAttribute("user_id"));


		}else {
			//未認証
			url="login.jsp";
		}

		RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}