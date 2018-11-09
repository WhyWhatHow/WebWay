package learn.demo.HistoryVisited;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learn.util.CookieUtils;

/*
 * quction:cookie.setPath("/WebWay/test")会带来的问题，找不到cookie,
 * reason:是自己的servlet并不在这个文件夹下（猜测），所以出现bug
 * solution: easy way, cookie.setPath("/WebWay/")
 */
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HistoryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtils.findCookieByName(cookies, "history");
		String id = request.getParameter("id");
		System.out.println("id === " + id);
		if (cookie == null) {// 第一次浏览商品
			System.out.println("============cookie  First created! ===============");
			cookie = new Cookie("history", id);
		} else {
			System.out.println("============cookie already created! ===============");
			String value = cookie.getValue();
			value += "#" + id;
			cookie.setValue(value);
		}
		System.out.println(cookie.getValue());
		// 当前浏览记录为最后一件商品
//		String output = "现在， 您正在浏览的商品是 " + id; // 电商（eg 京东）是写的静态页面跳转
		cookie.setMaxAge(60 * 60 * 24 * 7);
		cookie.setPath("/WebWay");
//		response.getWriter().write(output);
//		response.addCookie(cookie);
		response.addCookie(cookie);
//		request.getRequestDispatcher("/test/GoodsDetail.jsp").forward(request,response); // 需要写绝对路径，需要修改部分信息，重定向不需要
		response.sendRedirect("/WebWay/test/GoodsDetail.jsp");// 未完，待续
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
