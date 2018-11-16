package demo.StuManager.Service;

import java.util.List;

import demo.StuManager.domain.Student;

public interface StudentService {
	 List<Student> search(String name ,String gender ) ;
	 void add(Student stu);
	 void delete(int sid );
	 void update(int sid );
	
}
