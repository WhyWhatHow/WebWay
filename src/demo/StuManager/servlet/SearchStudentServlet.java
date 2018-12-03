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
import demo.StuManager.domain.Page;
import demo.StuManager.domain.Student;

public class SearchStudentServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
	static int count =1 ;
	
	public SearchStudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int currentPage = 1 ;
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String curr =request.getParameter("currentPage");
			if(curr ==null || curr.equals("")) {
				
			}else {
				currentPage = Integer.parseInt(curr);
			}
			System.out.println("======================search ====================");
			if (gender.equals("--chose --")) {
				gender = null;
			}if (name.equals("--chose --")) {
				name = null;
			}
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			session.setAttribute("gender", gender);
			System.out.println(count+" times :"+name + ": " + gender);
			count++;
			StudentService service = new StudentServiceImpl();
			Page page = service.searchByPage(name, gender, currentPage);
			session.setAttribute("pageBean", page);
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
