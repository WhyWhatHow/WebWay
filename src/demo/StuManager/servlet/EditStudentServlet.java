package demo.StuManager.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import demo.StuManager.Service.StudentService;
import demo.StuManager.Service.StudentServiceImpl;
import demo.StuManager.domain.Student;

public class EditStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditStudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

//			System.out.println("=================Edit Student servlet==========");
			int sid = Integer.parseInt(request.getParameter("sid"));
			StudentService service = new StudentServiceImpl();
			Student stu = service.searchBySid(sid);
			System.out.println(stu);
			HttpSession session  = request.getSession();
			session.setAttribute("stu", stu);
			response.sendRedirect("/WebWay/StuManager/edit.jsp");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
