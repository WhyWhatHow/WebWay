package top.enjoy_life.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServletStart02
 */
public class TestServletStart02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestServletStart02() {
		super();
		// TODO Auto-generated constructor stub
	}
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
			System.out.println("=============================================================================");
	    	System.out.println("Start2创建哦咯");
			System.out.println("=============================================================================");
		
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	

}
