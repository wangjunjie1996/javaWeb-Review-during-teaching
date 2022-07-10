package com.hpe.service;

import com.hpe.pojo.User;

public interface UserService {

	public User selectById(int id);
	
	//转账
	public void transfer(String inUser, String outUser,double money);
}
