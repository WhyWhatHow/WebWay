package learn.servlet.Demo;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import learn.util.CookieUtils;

public class LoginLatestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginLatestServlet() {
		super();
	}

	/*	 
	 * 1. 获取请求数据， usename,password 
	 * 2. 判断是否有cookie，含有上一次登陆时间，若有，获取上次登录时间，，修改对应的cookie值，response 返回，
	 * 3.否则的话，生成新的cookie，加入response 
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + password);
		if ("admin".equals(username) && "123456".equals(password)) {
			Cookie[] cookies = request.getCookies();
			String value = null;
			String time = LocalTime.now().toString();
			 System.out.println(time);
			Cookie cookie = CookieUtils.findCookieByName(cookies, "latestTime");
			if (cookie == null) {
				cookie = new Cookie("latestTime", time);
				cookie.setMaxAge(60*60*24*7);// 以秒为单位
//				cookie.setPath(getServletContext().getRealPath(".")); // 设置cookie的使用路径
				response.addCookie(cookie);
				response.getWriter().write("<h1>您好，欢迎您的登录,这是您的第一次登录</h1>");
			} else {
				value = cookie.getValue();
				cookie.setValue(time);
				response.getWriter().write("<h1>您好，欢迎您的登录,您上次登陆时间为：" + value + "....</h1>");
			}

		}else {
			try {
				response.getWriter().write("<h1>对不起，您输入的密码有错误，请重新输入</h1>");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			response.sendRedirect("/WebWay/test/recentLogin.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Test
	public void test() {
		String time = LocalTime.now().toString();
		System.out.println(time);

	}

}
