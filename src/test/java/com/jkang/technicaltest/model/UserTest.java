package com.jkang.technicaltest.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erick
 */
public class UserTest {
	
	public User user;
	
	public UserTest() {
		user = new User();
	}
	
	@Test
	public void setGetIdTest() {
		user.setId(1);
		assertEquals(1, user.getId());
	}
	
	@Test
	public void setGetNameTest() {
		user.setName("test name");
		assertEquals("test name", user.getName());
	}
	
}
