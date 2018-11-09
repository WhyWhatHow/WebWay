package learn.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class TestRequsetDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("這是 请求转发的跳转界面");
//		System.out.println("這是 重定向的跳转界面");
//		String name = request.getParameter("name"); // c-s阶段
//		String aname  = (String )request.getAttribute("name");//  web组件阶段
//		System.out.println(name +"================;"+ aname );
//		request.setAttribute("name", name); // 
		request.getRequestDispatcher("test/TestRequestDispathcher.jsp?name=aa").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
