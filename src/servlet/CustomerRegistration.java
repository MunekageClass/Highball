package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.ConnectionManager;
import model.dao.CustomerDAO;
import model.entity.CustomerBean;

/**
 * Servlet implementation class CustomerRegistration
 */
@WebServlet(description = "顧客情報登録", urlPatterns = { "/customer-registration" })
public class CustomerRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistration() {
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

		//リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

        // リクエストパラメーターの取得
        String customer_name = request.getParameter("customer_name");
        String customer_name_kana = request.getParameter("customer_name_kana");
        String postal_code = request.getParameter("postal_code");
        String address = request.getParameter("address");
        String area_code = request.getParameter("area_code");
        String contact_person_name = request.getParameter("contact_person_name");
        String contact_person_name_kana = request.getParameter("contact_person_name_kana");
        String contact_person_tel = request.getParameter("contact_person_tel");
        String user_id = request.getParameter("user_id");

		CustomerBean ct= new CustomerBean();
		ct.setCm_name(customer_name);
		ct.setCm_name_kana(customer_name_kana);
		ct.setPt_code(postal_code);
		ct.setAddress(address);
		ct.setArea_code(area_code);
		ct.setCt_person_name(contact_person_name);
		ct.setCt_person_name_kana(contact_person_name_kana);
		ct.setCt_person_tel(contact_person_tel);
		ct.setUser_id(user_id);

		HttpSession session=request.getSession();
		List<CustomerBean> userList = (List) session.getAttribute("userList");
		List<CustomerBean> areaList = (List) session.getAttribute("areaList");

		//area_nameの設定
		for(CustomerBean cus:areaList) {
			if(ct.getArea_code().equals(cus.getArea_code())) {
				ct.setArea_name(cus.getArea_name());
			}
		}
		//user_nameの設定}
		for(CustomerBean cus:userList) {
			if(ct.getUser_id().equals(cus.getUser_id())) {
				ct.setUser_name(cus.getUser_name());
			}
		}

		//郵便番号が形式通りかの確認




		//DAOの生成
		CustomerDAO dao=new CustomerDAO();

		int flg=0;

		try {
			flg=dao.insert(ct);
		} catch (ClassNotFoundException | SQLException | NumberFormatException e) {
			e.printStackTrace();
		}



		//登録に失敗した場合顧客IDのAUTOINCREMENTをリセットする
		if(flg==0) {
			int processingNumber = 0;
			String sql="ALTER TABLE m_customer auto_increment = 1;";
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				processingNumber = pstmt.executeUpdate();

			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}




		//requestの設定
		request.setAttribute("flg", flg);
		request.setAttribute("customer", ct);
		//転送
		RequestDispatcher rd=request.getRequestDispatcher("customer-registration-fin.jsp");
		rd.forward(request, response);


	}


}