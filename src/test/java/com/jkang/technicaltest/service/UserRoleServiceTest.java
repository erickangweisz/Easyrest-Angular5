package com.jkang.technicaltest.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erick
 */
public class UserRoleServiceTest {
	
	public UserRoleService userRoleService;
	public String basePath;
	
	public UserRoleServiceTest() {
		userRoleService = new UserRoleService();
		basePath = "localhost:8080/TechnicalTest/userroleservice/";
	}
	
	/*@Test
	public void getRolesByUserIdTest() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(basePath + "rolesbyuserid/{id}");
		Response response = target.resolveTemplate("id", 1).request().get();
		try {
			assertEquals(202, response.getStatus());
		} finally {
			response.close();
			client.close();
		}
	}*/
	
	/*@Test
	public void getAllUsersTest() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(basePath + "usersroles");
		Response response = target.request().get();
		try {
			assertEquals(202, response.getStatus());
		} finally {
			response.close();
			client.close();
		}
	}*/

}
