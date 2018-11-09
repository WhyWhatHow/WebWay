package learn.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TestServletContext() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		
		String address = context.getInitParameter("address");
		System.out.println(" ==================  全局变量的获取  ===============");
		System.out.println(address);
		String path = context.getRealPath("TestServletContext.java");
		System.out.println(" ==================  绝对路径的获取  ================");
		System.out.println(path);
		System.out.println("web project root path is:  " + context.getRealPath(""));
		System.out.println("readme.md's location is : " + context.getRealPath("readme.md"));
		System.out.println(" ==================  获取工程资源===================");
		System.out.println(context.getRealPath("file/read.properties"));
		/*
		 * 指定载入的数据源 此处，如果想获取web工程下的资源，用普通的FileInputStream 写法是不OK 的。 因为路径不对了。
		 * 这里相对的路径，其实是根据jre来确定的。 但是我们这是一个web工程， jre 后面会由tomcat管理，所以这里真正相对的路径是
		 * tomcat里面的bin目录
		 */
//		InputStream in  = context.getResourceAsStream(path); // 找不到该文件，context 方法只能用于 相对路径，其中，相对路径是针对tomcat 服务器实现的
		try {
//			InputStream in = context.getResourceAsStream("file/read.properties");
//			Properties properties = new Properties();

			InputStream in = context.getResourceAsStream("file/read.txt");
			if (in != null) {
//				properties.load(in);
//				System.out.println(properties.getProperty("username"));
				System.out.println("已经获取到文件了！！！！");
				byte[] buf = new byte[10];
				System.out.println(buf.toString());
				response.getWriter().write(buf.toString());
				in.close();
			} else {
				System.out.println("然而，并没有获取到文件");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
