package learn.demo.ShoppingCar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PhoneBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PhoneBuyServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 获取用户点击链接数据
		String name = request.getParameter("name");
		String id  = request.getParameter("id");
		System.out.println("id :"+id+", name :"+name);
		// 2.创建session对象，存储数据。
		HttpSession session = request.getSession();
//		session.setAttribute("list", ); //将获取到的用户数据添加到session。 购物车处理此逻辑
		
		
		// 3，跳转到详情页面
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
