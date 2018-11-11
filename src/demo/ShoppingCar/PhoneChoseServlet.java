package demo.ShoppingCar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PhoneChoseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PhoneChoseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		// 1. 获取session对象
//		HttpSession session = request.getSession();
//		Map<String , String> map  = (Map<String, String>) session.getAttribute("phone");
//		
//		// 2. 根据goodsID获取goods 的详细信息 -- 本demo未涉及此部分，数据属于随意捏造的
//		String name = request.getParameter("name");
//		String id = request.getParameter("id");
//		// 并未涉及数据库查询，所以此处采取默认 ,返回bean 对象，此处未实现
//		String detail = "id: "+ id ;
//		// 3. 覆盖之前的session中的 phone 对象
//		// 4. 跳转到货品详情页， 利用session显示数据
//		if(map==null) { // 第一次创建
//			map = new HashMap();	
//		}
//		map.put(name, detail);
//		session.setAttribute("phone", map);
		request.getRequestDispatcher("./test/PhoneDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
