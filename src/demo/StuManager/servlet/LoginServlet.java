package demo.StuManager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.StuManager.dao.UserDao;
import demo.StuManager.impl.UserImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		response.setContentType("text/html;charset=utf-8");
		System.out.println(username + "::" + password);
		// first use Bean -- Dao -- impl -- servlet
		// second use Bean --Dao -- impl -- service -- servlet
		UserDao userDao = new UserImpl();
		boolean yes = userDao.loginIn(username, password);
		if (yes) { // 登陆成功
			System.out.println("========================Login in =======================");
			response.sendRedirect("/WebWay/StuManager/index.html");
		}
		else {
			String result = "Sorry, userName or password doesn't work ";
			response.getWriter().write(result);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
