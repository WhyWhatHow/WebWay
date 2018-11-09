package learn.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  servletConfig 常见方法： 
 *    获取servletConfig；ServletConfig  config =getServletConfig();
 *    config.getServletName();
 *    config.getInitParameter(String name) ;
 *    config.getInitParmaeterNames();   	 
 */
public class TestServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServletConfig() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig  config =getServletConfig();
		/* web.xml :
		 *   <init-param>
		 *    <param-name>mother</param-name>
		 *   <param-value>︿(￣︶￣)︿</param-value>
		 * </init-param>
		 **/
		String name = config.getInitParameter("name");
		String mother = config.getInitParameter("mother");
		response.setContentType("text/html;charset=utf-8");
		String output = "name: "+ name +";\n mother : "+ mother;
		response.getWriter().write(output);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
