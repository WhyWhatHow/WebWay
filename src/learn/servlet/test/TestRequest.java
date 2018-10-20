package learn.servlet.test;

import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  *     测试方法一 ： html 登录页面： /WebWay/WebContent/test/countServeltContext.html
 *   测试方法二： http://localhost:8080/WebWay/TestRequest?username=admin&password=aa12321.   -- 修改参数实现, 
 *    解决问题： 
 *     	attribute,paramter,initalParamter
 *    	中文乱码 	 
 *    	servletContext 访问对象归属问题 ，---web服务器， 对项目而言是 webContent 下的文件.
 *  PS: 至于方法：自己多看java-ee-api文档吧
 *  request.setCharacterEncoding("utf-8");
 *		request.getAttribute(name);
 * 		request.getParameter(name);
 *		request.getParameterMap();
 * 		request.getAttributeNames();
 */
public class TestRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String oldEncoding = request.getCharacterEncoding();
		
		
		String username = request.getParameter("username");
		String passward = request.getParameter("password");
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String param = parameterNames.nextElement();
			System.out.println(param);
		}
		System.out.println("==================================================");

		ServletContext context = getServletContext();
		System.out.println();

		response.setContentType("text/html;charset=UTF-8");
		String result = "username :" + username + ",password : " + passward + "<br>";
		response.getWriter().write(result);
		if ("admin".equals(username) && "aa12321.".equals(passward)) {
			Object count = context.getAttribute("count");
			System.out.println(count);
			int x;
			if (count != null) {
				x = (Integer) count + 1;

				context.setAttribute("count", x);
			} else {
				x = 1;
				context.setAttribute("count", x);
			}
			System.out.println("x" + x);

			response.getWriter().write("login successed ,count : " + x);
		} else {
			response.getWriter().write("failed =============<br>");
		}
		response.getWriter().write("小飞就是我啦");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
