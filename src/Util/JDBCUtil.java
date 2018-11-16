package Util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/*
 * JDBC 实现的工具类
 *  getConnection(): 获取连接
 *  close(): 关闭连接
 *  backup()： 备份数据库
 *  load（）： 加载数据库
 */
public class JDBCUtil {
	
	static ComboPooledDataSource dataSource = null;

	static {
		dataSource = new ComboPooledDataSource("mysql");
	}
	public static Connection getConnection() {
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


//	@Test
//	 public void run() {
//		System.out.println(url + user + password);
//	}
	@Test
	public void rn() {
		Connection con = null; 
		PreparedStatement pe = null;
		ResultSet rs  = null ;
		String sql = "select * from user";
		con =JDBCUtil.getConnection();
		try {
			pe = con.prepareStatement(sql);
			rs= pe.executeQuery();
			while(rs.next()) {
				String userID = rs.getString(1);
				String password =rs.getString(2);
				System.out.println(userID+" "+ password);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
