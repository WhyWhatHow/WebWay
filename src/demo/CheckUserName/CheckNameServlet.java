package demo.CheckUserName;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckNameServlet() {
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("=======checkUserNameServlet==========");
		String name = request.getParameter("name");
		boolean res = false ;
		if (!name.equals("admin")) { // 实际上应该模拟查库的过程，走一遍所谓的三层架构service， dao，bean  省略
			res = true ;
		}
		System.out.println(res);
		response.getWriter().write(""+res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
