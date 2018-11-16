package demo.StuManager.Service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import demo.StuManager.dao.StudentDao;
import demo.StuManager.dao.StudentImpl;
import demo.StuManager.domain.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> search(String name, String gender) {
		String sql = "select * from student where 1=1 ";
		List<Student> list = new LinkedList<>();
		StudentDao dao = new StudentImpl();
		if (name != null) {
			name = "and sname like %" + name + "%";
		}
		if (gender.equals("boy") || gender.equals("girl")) { // 需要排除 请悬着的情况
			gender = "and gender = " + gender;
		}
		sql = sql + name + gender;
		try {
			list = dao.search(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	public void update(int sid) {

		StudentDao studentDao = new StudentImpl();
		try {
			Student student = studentDao.findBySid(sid);
			if (student != null) { // 根据用户列表返回数据不会存在空这种情况
				studentDao.update(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
