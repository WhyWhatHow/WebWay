package demo.StuManager.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.StuManager.Service.StudentService;
import demo.StuManager.Service.StudentServiceImpl;

public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteStudentServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String sid = request.getParameter("sid");
			System.out.println("=========================+sid:" + sid);
			StudentService service = new StudentServiceImpl();
			int id = Integer.parseInt(sid);
			Thread.sleep(1000);
			service.delete(id);
			request.getRequestDispatcher("./StudentListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
