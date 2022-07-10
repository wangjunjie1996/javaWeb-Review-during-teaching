package com.hpe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hpe.mapper.UserMapper;
import com.hpe.pojo.User;
import com.hpe.service.UserService;

//@Transactional 注解在类上，表示当前对象的所有方法都进行事务管理
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectById(int id) {
		// TODO Auto-generated method stub
		User user = new User();
		try {
			user = userMapper.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	//事务的注解  ，注解在方法上，表示当前的方法进行事务管理
	@Transactional
	@Override
	public void transfer(String inUser, String outUser, double money) {
		//给outUser减钱
		userMapper.updateAccount(outUser, -money);
		//int a = 1/0;
		selectById(1);
		//给inUser加钱
		userMapper.updateAccount(inUser, money);
	}

}
