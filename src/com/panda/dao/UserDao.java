package com.panda.dao;

import com.panda.vo.User;

/*
* @author MrC
* @date 2016��10��10������8:29:27
* @parameter ��User����������ݿ������ͳһ�ӿ�
* @version
*/
public interface UserDao {
	//�����˺ŷ���User����
	User getAllUserByAccount(String account) throws Exception;
}
