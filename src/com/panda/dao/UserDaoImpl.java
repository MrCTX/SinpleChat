package com.panda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.panda.util.JdbcUtil;
import com.panda.vo.User;

/*
* @author MrC
* @date 2016��10��10������8:45:05
* @parameter
* @version
*/
public class UserDaoImpl implements UserDao {
	@Override
	public User getAllUserByAccount(String account) throws Exception {
		//����һ�� User����
		User user = null;
		//�������ݿ�
		Connection connection = JdbcUtil.getConnection();
		//�����ѯ��䣬���ݴ���Ĳ���account�����ݿ���ȥ��ѯ����
		String sql = "select * from user where account = ?";
		//���PreparedStatement����,�����������ò���ֵ
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, account);
		//����PreparedStatement����Ĳ�ѯ������ResultSet����
		ResultSet rs = ps.executeQuery();
		//�ж�rs�����µ�ָ���Ƿ�Ϊ��,�����Ϊ�վ��½�һ��User���󣬲�Ϊ����������
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
