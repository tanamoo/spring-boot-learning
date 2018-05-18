package com.momo.springbootlearning.dao;

import static org.junit.Assert.*;


import java.text.DateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.momo.springbootlearning.entity.User;

import junit.framework.Assert;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;

	@SuppressWarnings("deprecation")
	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
		userRepository.save(new User("tan", "123456", "aa@126.com", "momo", formattedDate));
		userRepository.save(new User("li", "root", "bb@126.com", "dapang", formattedDate));
		userRepository.save(new User("lei", "test", "cc@126.com", "dashen", formattedDate));
		
		Assert.assertEquals(3, userRepository.findAll().size());
		Assert.assertEquals("dapang", userRepository.findByUserName("li").getNickName());
		userRepository.delete(userRepository.findByUserName("lei"));
		
	}

}
