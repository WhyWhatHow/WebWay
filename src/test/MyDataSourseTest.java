package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import Util.MyDataSourse;

public class MyDataSourseTest {
	@Test
	public void run() {
		try {
			MyDataSourse myDataSourse = new MyDataSourse();
			System.out.println("============1==================");
			Connection con = myDataSourse.getConnection();
			String sql = "select * from user ";
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("============1==================");

			ResultSet rs = ps.executeQuery();
			System.out.println("============1==================");

			while (rs.next()) {
				String name = rs.getString(1);
				String password = rs.getString(2);
				System.out.println(name + ":: " + password);
			}
			System.out.println("==============return connection = ============");
//			myDataSourse.addBack(con); // 调用自己生成的函数实现
			con.close();// 面向接口编程
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		System.out.println("runnnnnnnnnnnnnnnnnnnnnnnn");

	}
}
