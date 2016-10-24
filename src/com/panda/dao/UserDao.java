package com.panda.dao;

import com.panda.vo.User;

/*
* @author MrC
* @date 2016年10月10日下午8:29:27
* @parameter 对User对象进行数据库操作的统一接口
* @version
*/
public interface UserDao {
	//根据账号返回User对象
	User getAllUserByAccount(String account) throws Exception;
}
