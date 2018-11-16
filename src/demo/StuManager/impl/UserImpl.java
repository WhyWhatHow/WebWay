package demo.StuManager.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import Util.DButil;
import demo.StuManager.dao.UserDao;
import test.Bean.User;

public class UserImpl implements UserDao {

	@Override
	public boolean loginIn(String username, String password) {
//		Connection con = DButil.open();
//		ResultSet rs = null;
//		PreparedStatement ps = null;
//		String sql = "select password from user where id= ? and password = ?";
//
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, username);
//			ps.setString(2, password);
//			rs = ps.executeQuery();
//			if (rs.next()) {
//				System.out.println("Successfully LoginIn !");
//				return true ;
//			} else {
//				System.out.println("Login in failed!");
//				return false ;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DButil.close(con);
//		}
//		return false ;
		QueryRunner queryRunner = new QueryRunner(DButil.getDataBase());
		try {
			User user = queryRunner.query("select * from user where id  = ? and password =?",
					new BeanHandler<User>(User.class), username, password);
			return user != null;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Test
	public void run() {
		if (loginIn("admin", "aa12321.")) {
			System.out.println("==========login in========");
		} else {
			System.out.println("============failed==============");

		}
		if (loginIn("admin", "123456")) {
			System.out.println("==========login in========");
		} else {
			System.out.println("============failed==============");

		}

	}

}
