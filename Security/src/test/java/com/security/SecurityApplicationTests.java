package com.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.security.domain.UserDto;
import com.security.mapper.UserMapper;

@SpringBootTest
class SecurityApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	@Transactional
	void addUser() {
		UserDto userDto = new UserDto();
		userDto.setEmail("test02");
		userDto.setPassword("1234");

		userMapper.addUser(userDto);
		System.out.println(userDto);
	}
	
//	@Test
	void getUserByEmail() {
		System.out.println(userMapper.getUserByEmail("test01"));
	}
	
//	@Test
	void setRole() {
		userMapper.setRole(1);
	}
	

}
