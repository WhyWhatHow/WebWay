package demo.StuManager.Service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import demo.StuManager.dao.StudentDao;
import demo.StuManager.dao.StudentImpl;
import demo.StuManager.domain.Student;

public class StudentServiceImpl implements StudentService {

	@Override
	public List<Student> search(String name, String gender) throws SQLException {
		String sql = "select * from student where 1=1 ";
		List<Student> list = new LinkedList<>();
		StudentDao dao = new StudentImpl();
		if (name != null&& !name.equals("")) {

			name = "and sname like '%" + name + "%' ";
			sql = sql + name;
		}
		if (gender != null) {
			if (gender.equals("male") || gender.equals("female")) { // 需要排除 请悬着的情况
				gender = "and gender = '" + gender+"'";
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

}
