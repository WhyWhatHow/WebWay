package demo.StuManager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.StuManager.dao.StudentDao;
import demo.StuManager.dao.StudentImpl;
import demo.StuManager.dao.UserDao;
import demo.StuManager.domain.Student;
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
		System.out.println(username+"::"+ password);
		// first use Bean -- Dao -- impl -- servlet
		// second use Bean --Dao -- impl -- service -- servlet
		UserDao userDao = new UserImpl();
		boolean yes = userDao.loginIn(username, password);
		if (yes) { // 登陆成功
			StudentDao studentDao = new StudentImpl();

			List<Student> list = studentDao.findAll();
			if (list != null) { // 成功的情况
				HttpSession session = request.getSession();
				for (Student student : list) {
					System.out.println(student);
				}
				session.setAttribute("list", list);
				request.getRequestDispatcher("StuManager/Stu_List.jsp").forward(request,response);
				

			} else { // student 表中没有数据
				String result = "Sorry, there is no student information in here!";
				response.getWriter().write(result);
			}

		} else {
			String result = "Sorry, userName or password doesn't work ";
			response.getWriter().write(result);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
