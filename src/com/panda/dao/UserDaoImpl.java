package com.panda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.panda.util.JdbcUtil;
import com.panda.vo.User;

/*
* @author MrC
* @date 2016年10月10日下午8:45:05
* @parameter
* @version
*/
public class UserDaoImpl implements UserDao {
	@Override
	public User getAllUserByAccount(String account) throws Exception {
		//声明一个 User对象
		User user = null;
		//连接数据库
		Connection connection = JdbcUtil.getConnection();
		//定义查询语句，根据传入的参数account在数据库中去查询数据
		String sql = "select * from user where account = ?";
		//获得PreparedStatement对象,并且向其设置参数值
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, account);
		//根据PreparedStatement对象的查询结果获得ResultSet对象
		ResultSet rs = ps.executeQuery();
		//判断rs的向下的指针是否为空,如果不为空就新建一个User对象，并为其设置属性
		if (rs.next()) {
			user = new User();
			user.setAccount(rs.getString("account"));
			user.setPassword(rs.getString("password"));
			user.setCname(rs.getString("cname"));
		}
		JdbcUtil.clossPrepareStatementConnection(connection, ps, rs);
		return user;
	}
	
	/*public static void main(String[] args) throws Exception {
		User us = new UserDaoImpl().getAllUserByAccount("ctx");
		System.out.println(us.getCname());
	}*/

}
