package demo.StuManager.dao;


import java.sql.SQLException;
import java.util.List;

import demo.StuManager.domain.Student;

public interface StudentDao {

	int PAGE_SIZE=8;
	List<Student> findAll() throws SQLException;
	List<Student> findByPage(String sql ,int currentPage) throws SQLException;
	List<Student> findByName(String name ) throws SQLException;
	Student findBySid(int sid) throws SQLException;
	List<Student> findByStudent();
	int findStudentNum() throws SQLException;
	int searchStudentNum(String sql) throws SQLException;
	void add(Student stu) throws SQLException ;
	void delete(int sid ) throws SQLException;
	void update(Student stu) throws SQLException;
	List<Student> search(String sql) throws SQLException;
}
