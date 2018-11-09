package learn.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TestRediction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("這是 重定向的跳转界面");
		String name = request.getParameter("name");
		
//		String aname  = (String )request.getAttribute("name");
//		System.out.println(name +"================;"+ aname );
//		request.setAttribute("name", name); 
		response.sendRedirect("./test/testRediction.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
