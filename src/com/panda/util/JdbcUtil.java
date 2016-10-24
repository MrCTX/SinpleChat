package com.panda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/*
* @author MrC
* @date 2016年10月8日下午7:35:53
* @parameter driver是mysql的驱动名,url是数据库的位置定位符，user为连接数据库的用户名，password是连接数据库的密码
* @version
*/
public class JdbcUtil {
	private static Connection connection ;
	private static String driver ; 
	private static String url ;
	private static String user ;
	private static String password;
	private static Properties properties ;
	//静态语句块，只加载一次
	static {
		properties = new Properties();
		//获得ClassLoader对象
		ClassLoader loader = JdbcUtil.class.getClassLoader();
		try {
		//读取文件流
			properties.load(loader.getResourceAsStream("jdbc.properties"));
			//获得driver键的值
			driver = properties.getProperty("driver");
			//获得url键的值
			url = properties.getProperty("url");
			//获得user键的值
			user = properties.getProperty("user");
			//获得passowrd键的值
			password = properties.getProperty("password");
			//获得驱动名
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//连接数据库返回一个Connection对象
	public static Connection getConnection() throws Exception {
		connection = DriverManager.getConnection(url, user, password);
		return connection ;
	}
	
	//关闭数据库连接
	public static void clossConnection(Connection connection , 
			Statement statement , ResultSet resultSet) {
		
	}
	
	//关闭数据库连接
	public static void clossPrepareStatementConnection(Connection connection , 
			PreparedStatement preparedStatement , ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				} finally {
					if (preparedStatement != null) {
						try {
							preparedStatement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							if (resultSet != null) {
								try {
									resultSet.close();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			} 
	}
}
