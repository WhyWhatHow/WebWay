package demo.StuManager.Service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;

import org.junit.Test;

import com.sun.javafx.sg.prism.NGShape.Mode;

import demo.StuManager.dao.StudentDao;
import demo.StuManager.dao.StudentImpl;
import demo.StuManager.domain.Page;
import demo.StuManager.domain.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> search(String name, String gender) throws SQLException {
		String sql = "select * from student where 1=1 ";
		List<Student> list = new LinkedList<>();
		StudentDao dao = new StudentImpl();
		if (name != null && !name.equals("")) {

			name = "and sname like '%" + name + "%' ";
			sql = sql + name;
		}
		if (gender != null) {
			if (gender.equals("male") || gender.equals("female")) { // 需要排除 请悬着的情况
				gender = "and gender = '" + gender + "'";
				sql = sql + gender;
			}
		}
		list = dao.search(sql);

		return list;
	}

	@Override
	public void add(Student stu) {
		StudentDao dao = new StudentImpl();
		try {
			dao.add(stu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int sid) {
		StudentDao dao = new StudentImpl();
		try {
			dao.delete(sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Student stu) throws SQLException {

		StudentDao studentDao = new StudentImpl();
		studentDao.update(stu);
	}

	@Override
	public Student searchBySid(int sid) throws SQLException {
		StudentDao dao = new StudentImpl();
		return dao.findBySid(sid);
	}

	@Override
	public Page<Student> findByPage(int currentPage) throws SQLException {
		Page<Student> page = new Page<Student>();

		StudentDao dao = new StudentImpl();
		int pageSize = dao.PAGE_SIZE;
		int totalSize = dao.findStudentNum();
		System.out.println("totalSize: "+totalSize);
		int totalPage = totalSize/pageSize;
		int res = totalSize % pageSize;
		if(res!=0) {
			totalPage++;
		}else {
			if (totalSize == 0) {
				totalPage =1 ;
			}
		}
		page.setTotalPage(totalPage);
		page.setPageSize(pageSize);
		page.setCurrentPage(currentPage);
		page.setTotalSize(totalSize);
		page.setList(dao.findByPage(currentPage));
		return page;
	}
	@Test
	public void run() throws SQLException {
			
		Page<Student> page = findByPage(1);
		System.out.println(page);
	}

}
