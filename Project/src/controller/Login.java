package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     *
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");//おまじない

			String loginId = request.getParameter("loginid");
			String password = request.getParameter("password");

			// リクエストパラメータの入力項目を引数に渡して、Daoのメソッドを実行
			UserDao userDao = new UserDao();
			User user = userDao.findByLoginInfo(loginId, password);

			if (user == null) {
				// リクエストスコープにエラーメッセージをセット
				request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります");

				// ログインjspにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
				return;
			}

			/** テーブルに該当のデータが見つかった場合 **/
			// セッションにユーザの情報をセット
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", user);

			// ユーザ一覧のサーブレットにリダイレクト
			response.sendRedirect("UserList");

	}
}
