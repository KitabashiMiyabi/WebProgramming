package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if(session.getAttribute("UaerInfo") == null ){
			response.sendRedirect("Login");
			return;
		}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userregistration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");//おまじない


			String loginId = request.getParameter("loginId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
            String birthDate = request.getParameter("birthDate");

            try{
            	UserDao userDao = new UserDao();
            	userDao.signup(loginId, password,name,birthDate);

            	response.sendRedirect("UserList" );

            }catch(SQLException e) {
				// リクエストスコープにエラーメッセージをセット
				request.setAttribute("errMsg", "入力された内容は正しくありません");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userregistration.jsp");
				dispatcher.forward(request, response);
				return;
			}


	}

}
