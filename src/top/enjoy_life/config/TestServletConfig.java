package top.enjoy_life.config;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServletConfig() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletConfig  config =getServletConfig();
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
