package demo.StuManager.dao;


import java.util.List;

import demo.StuManager.domain.Student;

public interface StudentDao {

	List<Student> findAll();
}
