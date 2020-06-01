package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ログインフォームから送信されたリクエストを処理する
 * @author emBex Education
 */
@WebServlet("/menu-servlet")
public class MenuServlet extends HttpServlet {

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// セッションオブジェクトの取得
		HttpSession session = request.getSession();

		//処理がうまくいっていないときはログイン失敗に行くようにする
		String url = "login-failure.html"; // 転送先

		//ログインセッションの確認をあとで追加する
		if (session.getAttribute("user_name") != null) {
			url = "menu.jsp";
		}else {

		}
		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}