package com.jkang.technicaltest.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erick
 */
public class UserRoleTest {
	
	public UserRole userRole;
	
	public UserRoleTest() {
		userRole = new UserRole();
	}
	
	@Test
	public void setGetIdTest() {
		userRole.setId(1);
		assertEquals(1, userRole.getId());
	}
	
	@Test
	public void setGetUserIdTest() {
		userRole.setUserId(1);
		assertEquals(1, userRole.getUserId());
	}
	
	@Test
	public void setGetRoleIdTest() {
		userRole.setRoleId(1);
		assertEquals(1, userRole.getRoleId());
	}
	
}
