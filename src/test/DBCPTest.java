package test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
/*
 * DBCP 的测试： 
	 * 使用dhcp步骤如下： 
	 * 1. 导入jar包
	 * 2. 无配置文件的api
		 *  BasicDataSource dataSource = new BasicDataSource();
		 *  dataSource.setDriverClassLoader(this.getClass().getClassLoader());// 类加载器的形式实现
		 * 	dataSource.setUrl("jdbc:mysql://localhost/stumanager");
		 * 	dataSource.setUsername("root");
		 *  dataSource.setPassword("aa12321.");
		 * 	conn = dataSource.getConnection();			
	 * 3. 配置文件: 
		 * BasicDataSourceFactory bFactory = new BasicDataSourceFactory();
		 * DataSource dataSource = factory.createDataSource(properties);
 * C3p0测试： --  不会的话，查官方文档
 	*1. 无配置文件：
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "org.postgresql.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:postgresql://localhost/testdb" );
		cpds.setUser("swaldman");                                  
		cpds.setPassword("test-password");                                  
			
		// the settings below are optional -- c3p0 can work with defaults
		cpds.setMinPoolSize(5);                                     
		cpds.setAcquireIncrement(5);
		cpds.setMaxPoolSize(20);
		// The DataSource cpds is now a fully configured and usable pooled DataSource
			
    *2. 配置文件 查官方文档， 英语不好是硬伤， 学好英语
    * c3p0-config.xml 文件的默认位置是 ./src/c3p0-config.xml   
    * 
    *
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.org.apache.bcel.internal.generic.NEW;

import Util.DButil;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import test.Bean.User;

public class DBCPTest {
	
	@Test
	public void testDButils() {
		// insert
		QueryRunner queryRunner = new QueryRunner(new ComboPooledDataSource("mysql"));
		try {
			// insert 
			queryRunner.update("insert into user values(?,?)", "lucy", "528lucy");

//			User user = queryRunner.query("select * from user where id = ? ", new BeanHandler<User>(User.class),
//					"admin");

			// update
			queryRunner.update("update user set password =?  ", "123456");
			// add lucy 
			System.out.println("==========add Lucy =========");
			// select
			List<User> list = queryRunner.query("select * from user", new BeanListHandler<User>(User.class));
			for (User user : list) {
				System.out.println(user);
			}
			// delete
			queryRunner.update("delete from user where id = ? ","lucy");
			list.clear();
			list = queryRunner.query("select * from user ", new BeanListHandler<User>(User.class));
			System.out.println("==========Delete Lucy =========");
			
			for (User user : list) {
				System.out.println(user);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/* c3p0 Api : 
	 * API: ComboPooledDataSource cpds = new ComboPooledDataSource();
	 * cpds.setDriverClass( "org.postgresql.Driver" ); //loads the jdbc driver
	 * cpds.setJdbcUrl( "jdbc:postgresql://localhost/testdb" );
	 * cpds.setUser("swaldman"); cpds.setPassword("test-password"); // the settings
	 * below are optional -- c3p0 can work with defaults cpds.setMinPoolSize(5);
	 * cpds.setAcquireIncrement(5); cpds.setMaxPoolSize(20); // The DataSource cpds
	 * is now a fully configured and usable pooled DataSource
	 * 
	 */
	@Test
	public void testC3p0WithoutXMl() { // 无配置文件

		Connection conn = null;
		PreparedStatement ps = null;
		try {

			// 1. 创建datasource
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			// 2. 设置连接数据的信息
			dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql://localhost/stumanager");
			dataSource.setUser("root");
			dataSource.setPassword("aa12321.");

			// 2. 得到连接对象
			conn = dataSource.getConnection();
			String sql = "select * from user";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String password = rs.getString(2);
				System.out.println(name + ":: " + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}
	}

	@Test // xml 文件默认位置应该为src 文件夹下
	public void testCp0WithXML() {

		// 默认会找 xml 中的 default-config 分支。
		ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");// xml 文件默认位置应该为src 文件夹下
		if (dataSource == null) {
			System.out.println("it's null ======================");
		} else {
			System.out.println(dataSource.toString());
		}
		// 2. 设置连接数据的信息
		try {
			// 2. 得到连接对象
			Connection conn = dataSource.getConnection();
			String sql = "select * from user";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String password = rs.getString(2);
				System.out.println(name + ":: " + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDBCPWithoutProperties() { // 不使用配置文件配置形式

		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "select * from user";
		try {
			// 1. 构建数据源对象
			BasicDataSource dataSource = new BasicDataSource();
			// 连的是什么类型的数据库， 访问的是哪个数据库 ， 用户名， 密码。。
			// jdbc:mysql://localhost/bank 主协议：子协议 ://本地/数据库
			// dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			dataSource.setDriverClassLoader(this.getClass().getClassLoader());// 类加载器的形式实现
			dataSource.setUrl("jdbc:mysql://localhost/stumanager");
			dataSource.setUsername("root");
			dataSource.setPassword("aa12321.");
			// 2. 得到连接对象
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String password = rs.getString(2);
				System.out.println(name + ":: " + password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}

	}

	@Test
	public void testDBCPWithProperties() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			BasicDataSourceFactory bFactory = new BasicDataSourceFactory();
			InputStream in = getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");

			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			Properties properties = new Properties();
//			InputStream is = new FileInputStream("src/dbcpconfig.properties");

			InputStream is = getClass().getClassLoader().getResourceAsStream("dbcpconfig.properties");
			properties.load(is);
//			System.out.println(properties.getProperty("password"));
			DataSource dataSource = factory.createDataSource(properties);

			// 2. 得到连接对象
			conn = dataSource.getConnection();

			String sql = "select * from user";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String password = rs.getString(2);
				System.out.println(name + ":: " + password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(conn);
		}

	}
}
