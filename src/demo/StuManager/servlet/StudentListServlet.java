package demo.StuManager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.StuManager.Service.StudentService;
import demo.StuManager.Service.StudentServiceImpl;
import demo.StuManager.domain.Student;

public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=============================studentlistservlet================");
		HttpSession session = request.getSession();

		StudentService service = new StudentServiceImpl();
		try {
			List<Student> list = (List<Student>) session.getAttribute("list");
			list = service.search(null, null);
			if (list == null) {
				System.out.println("=========================nullllllllll=====================");
			}

			session.setAttribute("list", list);
		
			for (Student student : list) {
				System.out.println(student);
			}
			response.sendRedirect("/WebWay/StuManager/Stu_List.jsp");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
