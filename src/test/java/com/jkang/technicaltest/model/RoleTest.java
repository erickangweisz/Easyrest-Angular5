package com.jkang.technicaltest.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erick
 */
public class RoleTest {
	
	public Role role;
	
	public RoleTest() {
		role = new Role();
	}
	
	@Test
	public void setGetIdTest() {
		role.setId(1);
		assertEquals(1, role.getId());
	}
	
	@Test
	public void setGetNameTest() {
		role.setName("test name");
		assertEquals("test name", role.getName());
	}
}
