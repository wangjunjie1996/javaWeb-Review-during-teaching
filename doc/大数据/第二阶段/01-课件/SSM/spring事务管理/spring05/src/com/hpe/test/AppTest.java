package com.hpe.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hpe.pojo.User;
import com.hpe.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"}) 
public class AppTest {
	
	@Autowired
	private UserService userService ;

	@Test
	public void test(){
		/*ApplicationContext app = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) app.getBean("userService");*/
		User user = userService.selectById(1);
		System.err.println(user);
	}
	
	@Test
	public void transfer(){
		userService.transfer("rose", "jack", 100.00);
	}
}
