package demo.StuManager.Service;

import java.sql.SQLException;
import java.util.List;

import demo.StuManager.domain.Page;
import demo.StuManager.domain.Student;

public interface StudentService {
	 List<Student> search(String name ,String gender) throws SQLException;
	 void add(Student stu);
	 void delete(int sid );
	 void update(Student stu) throws SQLException;
	 Student searchBySid(int sid ) throws SQLException;
	 Page<Student> findByPage(int currentPage) throws SQLException;
	 Page<Student> searchByPage(String name, String gender ,int currentPage) throws SQLException;
}
