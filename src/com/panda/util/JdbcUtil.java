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
* @date 2016��10��8������7:35:53
* @parameter driver��mysql��������,url�����ݿ��λ�ö�λ����userΪ�������ݿ���û�����password���������ݿ������
* @version
*/
public class JdbcUtil {
	private static Connection connection ;
	private static String driver ; 
	private static String url ;
	private static String user ;
	private static String password;
	private static Properties properties ;
	//��̬���飬ֻ����һ��
	static {
		properties = new Properties();
		//���ClassLoader����
		ClassLoader loader = JdbcUtil.class.getClassLoader();
		try {
		//��ȡ�ļ���
			properties.load(loader.getResourceAsStream("jdbc.properties"));
			//���driver����ֵ
			driver = properties.getProperty("driver");
			//���url����ֵ
			url = properties.getProperty("url");
			//���user����ֵ
			user = properties.getProperty("user");
			//���passowrd����ֵ
			password = properties.getProperty("password");
			//���������
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�������ݿⷵ��һ��Connection����
	public static Connection getConnection() throws Exception {
		connection = DriverManager.getConnection(url, user, password);
		return connection ;
	}
	
	//�ر����ݿ�����
	public static void clossConnection(Connection connection , 
			Statement statement , ResultSet resultSet) {
		
	}
	
	//�ر����ݿ�����
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
