package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");

		UserDao userDao = new UserDao();
		User user = userDao.Leference(id);

		request.setAttribute("user", user);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userupdate.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");//おまじない

		String id = request.getParameter("id");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");

		String name = request.getParameter("name");
        String birthDate = request.getParameter("birthDate");

        try{
         	UserDao userDao = new UserDao();  //isEmpty
         	if(password.equals(password2) && !name.equals("")&& !birthDate.equals("") ) {
         		if(password.equals("") ) {
         			userDao.update(id,name,birthDate);
         		}else {
         			userDao.update(id,password,name,birthDate);
         		}
         	}else {


         		User user = new User(Integer.parseInt(id), loginId, name, Utill.convertDate(birthDate) , null, null, null);

         		request.setAttribute("user", user);
         		request.setAttribute("errMsg", "入力された内容は正しくありません");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userupdate.jsp");
				dispatcher.forward(request, response);
				return;
         	}

         	response.sendRedirect("UserList" );

        }catch(SQLException e) {
				// リクエストスコープにエラーメッセージをセット
				request.setAttribute("errMsg", "入力された内容は正しくありません");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userupdate.jsp");
				dispatcher.forward(request, response);
				return;
		}
	}

}
