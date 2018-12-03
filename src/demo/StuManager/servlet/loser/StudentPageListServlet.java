package demo.StuManager.servlet.loser;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.StuManager.Service.StudentService;
import demo.StuManager.Service.StudentServiceImpl;
import demo.StuManager.domain.Page;
import demo.StuManager.domain.Student;

public class StudentPageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentPageListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			System.out.println("=========================== page List  servlet =================");
			String curr = request.getParameter("currentPage").trim();
			int currentPage = 1;
			if (curr == null || curr.equals("")) {

			} else {
				currentPage = Integer.parseInt(curr);
			}
			HttpSession session = request.getSession();
			StudentService service = new StudentServiceImpl();
			Page<Student> page = service.findByPage(currentPage);
			System.out.println(curr);

			session.setAttribute("pageBean", page);
			response.sendRedirect("/WebWay/StuManager/Stu_List.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
