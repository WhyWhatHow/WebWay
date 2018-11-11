package demo.StuManager.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import Util.DButil;
import demo.StuManager.dao.UserDao;

public class UserImpl implements UserDao {

	@Override
	public boolean loginIn(String username, String password) {
		Connection con = DButil.open();
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql = "select password from user where id= ? and password = ?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Successfully LoginIn !");
				return true ;
			} else {
				System.out.println("Login in failed!");
				return false ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(con);
		}
		return false ;

	}

	@Test
	public void run() {
		loginIn("admin", "aa12321.");
		System.out.println("==========================");
		loginIn("admin", "aa2222.");
		System.out.println("==========================");

	}

}
