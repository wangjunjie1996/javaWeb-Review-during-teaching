package com.hpe.mapper;

import com.hpe.pojo.User;

public interface UserMapper {
	
	public User selectById(int id);
	
	//转账，修改用户信息
	public int updateAccount(String name,double money);
	
}
