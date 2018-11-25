package demo.StuManager.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import Util.MyDateConverter;
import demo.StuManager.Service.StudentService;
import demo.StuManager.Service.StudentServiceImpl;
import demo.StuManager.domain.Student;

public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateStudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//TODO BeanUtils 
		try {		
		System.out.println("====================Update Student servlet ==============");
		//  using beanutils get stubean 对象
		Student stu = new Student();
		ConvertUtils.register(new MyDateConverter(), Date.class);
		Map  map = request.getParameterMap();
		BeanUtils.populate(stu, map);
		
		System.out.println(stu);
		StudentService service = new StudentServiceImpl();
		service.update(stu);
		System.out.println("================end update =================================");
		response.sendRedirect("/WebWay/StudentListServlet");
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
