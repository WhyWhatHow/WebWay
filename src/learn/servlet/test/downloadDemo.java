package learn.servlet.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/*
 * 业务逻辑如下： 
 * 	1.  获取到文件的在服务器中的绝对路径
 * 	2.  对中文文件进行处理，  -- 未处理firefox 浏览器的问题
 *  对于web工程而言，文件所在的路径为WebContent文件夹，所以必须在获得绝对路径时加上该文件夹所在的位置。
 *   eg： String file =context.getRealPath(name); 得到的路径为： D:/WebWay/WebContent/read.txt 
 *   String file= context.getRealPath("file/"+name); D:/WebWay/WebContent/file/read.txt
 * ==============
 *response.setHeader("Content-Disposition", "attachment;filename=" + name); // 将文件以附件的形式 展示。
 */
public class downloadDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ServletContext context = getServletContext();
		// 1. 获取文件名
		String name = request.getParameter("fileName");
//		System.out.println(name);
//		System.out.println("==============================");
		/*
		 * 对于web工程而言，文件所在的路径为WebContent文件夹，所以必须在获得绝对路径时加上该文件夹所在的位置。 eg： String file =
		 * context.getRealPath(name); 得到的路径为： D:/WebWay/WebContent/read.txt String file
		 * = context.getRealPath("file/"+name); D:/WebWay/WebContent/file/read.txt
		 */
		// 2. 获取文件绝对路径
		String file = context.getRealPath("file/" + name);
//		System.out.println(file);
		// 3. 解决浏览器乱码 （可省略）
		String clientName = request.getHeader("User-Agent");
		name = changeFileNameInBrower(clientName, name);
//		System.out.println(name);
//		System.out.println("===============================");
		// 4. 设置文件返回类型， 以附件返回
		response.setHeader("Content-Disposition", "attachment;filename=" + name); // 将文件以附件的形式 展示。
		// 5 写入 response 的过程：
		try {
			InputStream inputStream = new FileInputStream(file);
			byte[] buf = new byte[1024];
			OutputStream outputStream = response.getOutputStream();
			int len = 0;
			while ((len = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, len);
			}
			inputStream.close();
			outputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/*
	 * 解决在浏览器中下载文件不能显示中文的问题， return : String as fielname params : clientName as
	 * user-Agent, name as filename
	 * 
	 */
	public String changeFileNameInBrower(String clientName, String name) throws UnsupportedEncodingException {
		if (clientName.contains("Firefox")) { // firefox 浏览器，
			name = new String(name.getBytes(), "iso8859-1");
		} else {
			name = URLEncoder.encode(name, "utf-8"); // 附件文件的显示类型
		}
		return name;
	}

}
