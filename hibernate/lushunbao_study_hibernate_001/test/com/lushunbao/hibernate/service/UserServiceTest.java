package com.lushunbao.hibernate.service;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class UserServiceTest {
	private UserService userService = new UserService();
	
	@Test
	public void testAddUser() throws Exception {
		userService.setUp();
		userService.addUser();
	}

}
