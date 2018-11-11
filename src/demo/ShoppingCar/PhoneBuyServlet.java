package demo.ShoppingCar;

import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/* 
 * 购物车demo 
 * 	PhoneList.jsp(商品列表页面) 
 *	 --> PhoneChoseServlet.java (处理list发来的请求，与数据库进行交互，结果在detail.jsp 页面显示出来) (未实现)
 *	 --> PoneDetail.jsp(将 detail.jsp 获取到的数据库数据进行显示)
 *	 --> PhoneBuyServlet.java (处理，将需要添加入购物车的商品加入购物车，如果之前已经存在，商品数量加一，其他不变)
 *	Finished: 2018/11/11
 * 
 */

public class PhoneBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhoneBuyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 获取用户点击链接数据
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		System.out.println("id :" + id + ", name :" + name);
		// 2.创建session对象，存储数据。
		HttpSession session = request.getSession();
//		session.setAttribute("list", ); //将获取到的用户数据添加到session。 购物车处理此逻辑
		HashMap<String, Integer> map = (HashMap<String, Integer>) session.getAttribute("shoppingCar");
		if (map != null) {
			if (map.containsKey(name)) {
				int num = map.get(name);
				map.put(name, num + 1);
			} else {
				map.put(name, 1);
			}
		}else {
			map = new HashMap<String,Integer>();
			map.put(name, 1);
			
		}
		int num = map.get(name);
		System.out.println(num);
		session.setAttribute("shoppingCar", map);

		// 3，跳转到详情页面
		request.getRequestDispatcher("test/ShoppingCar.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
