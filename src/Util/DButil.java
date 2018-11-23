package Util;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import test.Bean.User;
public class DButil {
	
	static ComboPooledDataSource dataSource = null;
	static {
		dataSource = new ComboPooledDataSource("mysql");
	}
	// 为引入数据库连接池的写法
//	static String driverClass = null;
//	static String url = null;
//	static String user = null;
//	static String password = null;
//	static {
//		try {
//			Properties properties = new Properties();
//			//类加载器的方式，
//			InputStream in = DButil.class.getClassLoader().getResourceAsStream("jdbc.properties"); 
//			
////			FileReader in = new FileReader("./jdbc.properties"); // 不成功 ，获取文件路径失败
//			properties.load(in);
//		
//			driverClass = properties.getProperty("driverClass");
//			url = properties.getProperty("url");
//			user = properties.getProperty("name");
//			password = properties.getProperty("password");
//		} catch (Exception e) {
//		}
//	}
	
	public static ComboPooledDataSource getDataBase() {
		return dataSource;
	}
	public static Connection open() {
		// java 实训代码
		
//		try {
//			Class.forName(driverClass);
//			return DriverManager.getConnection(url, user, password);
//			
//		}catch (Exception e) {
//			System.out.println("can't link to DataBase");
//			e.printStackTrace();
//		}
//		return null ;
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null ;
		
	}
	public static void close (Connection con) {
		if(con ==null) {
			return ; 
		}else {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * @description: 数据库的备份
	 * @param: host,username,password,savePath,fileName,databaseName;
	 * @return: true or false
	 * @author:initial-mind
	 * @time:2018年7月7日
	 */
	public static synchronized boolean backup(String host, String userName, String password, String savePath,
			String fileName, String databaseName) {
		File saveFile = new File(savePath);
		if (!saveFile.exists()) {
			saveFile.mkdirs();
		}
		if (!savePath.endsWith(File.separator)) {
			savePath = savePath + File.separator;
		}
		StringBuilder command = new StringBuilder();
		command.append("mysqldump --opt -h").append(host).append(" --user=").append(userName).append(" --password=")
				.append(password).append(" --lock-all-tables=true ").append(" --result-file=")
				.append(savePath + fileName).append("  --default-character-set=utf8 ").append(databaseName);
//		
//		command.append("mysqldump -h").append(host).append(" -u").append(userName).append(" -p").append(password)
//				.append(" ").append(databaseName).append(" > ").append(savePath).append(fileName);
//		System.out.println(command);
		String[] cmd = { "sh", "-c", command.toString() };
		System.out.println(cmd);
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			if (process.waitFor() == 0) {
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @description:数据库的恢复
	 * @param:userName,password,databaseName,filePath,fileName
	 * @return: true or false
	 * @author:initial-mind
	 * @time:2018年7月7日
	 */
	public synchronized static boolean load(String userName, String password, String databaseName, 
//			String filePath,
			String fileName) {
		StringBuilder loadDB = new StringBuilder();
		loadDB.append("mysql -u").append(userName).append(" -p").append(password).append(" ").append(databaseName)
				.append(" < ").append(
//						filePath + File.separator +
						fileName);

		System.out.println(loadDB.toString());
		String[] cmd = { "sh", "-c", loadDB.toString() };
		try {
			Process load = Runtime.getRuntime().exec(cmd);
			if (load.waitFor() == 0)
				return true;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Test
	public void rn() {
			QueryRunner queryRunner= new QueryRunner(DButil.getDataBase());
			try {
			List<User> list = queryRunner.query("select * from user", new BeanListHandler<User>(User.class));
			 for (User user : list) {
				System.out.println(user);
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
