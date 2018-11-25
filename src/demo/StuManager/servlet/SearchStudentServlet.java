package demo.StuManager.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.StuManager.Service.StudentService;
import demo.StuManager.Service.StudentServiceImpl;
import demo.StuManager.domain.Student;

public class SearchStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchStudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String name = request.getParameter("name").toLowerCase();
			String gender = request.getParameter("gender").toLowerCase();
			System.out.println("======================search ====================");
			System.out.println(name + ": " + gender);
			if (gender.equals("--chose --")) {
				gender = null;
			}
			StudentService service = new StudentServiceImpl();
			List<Student> list;
			list = service.search(name, gender);
			HttpSession session = request.getSession();
			for (Student student : list) {
				System.out.println(student);
			}
			session.setAttribute("list", list);
			response.sendRedirect("/WebWay/StuManager/Stu_List.jsp");
			System.out.println("================== end search ===================");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
