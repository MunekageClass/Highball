package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
 * Servlet implementation class CustomerDelete
 */
@WebServlet("/customer-delete")
public class CustomerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerDelete() {
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
		//DAOを使ってデータベース内の顧客情報を削除
		//セッションスコープの受け取り
		HttpSession session=request.getSession();
		CustomerBean customer=(CustomerBean)session.getAttribute("delete_customer");

		//DAOの生成
		CustomerDAO dao=new CustomerDAO();

		int flg=0;

		try {
			flg=dao.delete(customer);

			int processingNumber = 0;
			String sql="ALTER TABLE m_customer auto_increment = 1;";
			try (Connection con = ConnectionManager.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)) {
				processingNumber = pstmt.executeUpdate();

			} catch (ClassNotFoundException | SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		//requestの設定
		request.setAttribute("flg", flg);
		//転送
		RequestDispatcher rd=request.getRequestDispatcher("customer-delete-fin.jsp");
		rd.forward(request, response);
	}

}