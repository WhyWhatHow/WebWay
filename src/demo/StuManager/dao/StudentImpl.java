package demo.StuManager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import Util.DButil;
import demo.StuManager.domain.Student;

public class StudentImpl implements StudentDao {

	@Override
	public List<Student> findAll() {
		List<Student> list = new LinkedList();
		Connection con = DButil.open();
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select sid,sname,gender,sage,address,tel from student ";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String gender = rs.getString(3);
				int age = rs.getInt(4);
				String address = rs.getString(5);
				String tel = rs.getString(6);
				list.add(new Student(id, name, gender, tel, address, age));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}
		return null;
	}

	@Test
	public void run() {
		List<Student> list = findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}

}
