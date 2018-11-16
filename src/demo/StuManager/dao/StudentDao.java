package demo.StuManager.dao;


import java.sql.SQLException;
import java.util.List;

import demo.StuManager.domain.Student;
import sun.reflect.generics.tree.VoidDescriptor;

public interface StudentDao {

	List<Student> findAll();
	List<Student> findByGender();
	List<Student> findByName(String name ) throws SQLException;
	Student findBySid(int sid) throws SQLException;
	List<Student> findByStudent();
	void add(Student stu) throws SQLException ;
	void delete(int sid ) throws SQLException;
	void update(Student stu) throws SQLException;
	List<Student> search(String sql) throws SQLException;
}
