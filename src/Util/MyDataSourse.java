package Util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;
/*
 * 自定义数据库连接池的实现： 
 * 1.创建 10 个默认链接
 * 2. 超过10个，增加5个
 * 3.归还链接 addBack();
 * PS:参考黑马，自己只是简单地实现了下数据库连接池的操作，获取连接与归还链接的操作
 */
public class MyDataSourse implements DataSource {

	LinkedList<Connection> list = new LinkedList<Connection>();

	public MyDataSourse() {
		for (int i = 0; i < 10; i++) {
			Connection connection = DButil.open();
			list.add(connection);
		}
	}

	@Override 
	public Connection getConnection() throws SQLException {// 从数据库连接池获取连接
		if (list.size() == 0) {
			for (int i = 0; i < 5; i++) {
				Connection connection = DButil.open();
				list.add(connection);
			}
		}
		Connection conn = list.remove(0);
		System.out.println("Remain: "+  list.size());
		// 装饰者模式实现 面向接口编程
		Connection connection  = new ConnectionWrap(conn, list);
		return connection ;
	}
	
	
	/*
	 * 归还 connection
	 */
	public void addBack(Connection connection) {
		list.add(connection);
		System.out.println(list.size());
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		return null;
	}

	@Override
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {

	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {

	}

}
