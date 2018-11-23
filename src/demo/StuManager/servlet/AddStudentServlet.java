package demo.StuManager.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import demo.StuManager.Service.StudentService;
import demo.StuManager.Service.StudentServiceImpl;
import demo.StuManager.domain.Student;

public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddStudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO 可优化代码
		// problem: 对应 addStudent.jsp 文件名 由name ->sname, 通过request 获取名字失败，猜测原因：
		// ans : 浏览器缓存问题，防止更新啊cdn
		// 卫什么不把时间选择有string处理，前端进行初步的数据清洗，保证数据的有效性，后端负责安全检查， 不解三联，明明字符串存的，为什么非得着呢吗做，何苦呢？
		try {
			System.out.println("====================add Student servlet ==============");
			String sname = request.getParameter("sname");
			int age = Integer.parseInt(request.getParameter("age"));
			String address = request.getParameter("address");
			String tel = request.getParameter("tel");
			String brithday = request.getParameter("birthday");
			String[] hobbys = request.getParameterValues("hobby");
			String gender = request.getParameter("gender");
			String info = request.getParameter("info");
			System.out.println(sname + "," + tel + "," + brithday + "," + "," + gender + "," + info);
			String hobby = hobbys[0];
			for (int i = 1; i < hobbys.length; i++) {
				hobby = hobby + "," + hobbys[i];
			}
			int sid = 0;
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(brithday);
			Student stu = new Student(sid, sname, gender, address, tel, hobby, info, date, age);
			System.out.println(stu);
			StudentService service = new StudentServiceImpl();
			service.add(stu);
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
