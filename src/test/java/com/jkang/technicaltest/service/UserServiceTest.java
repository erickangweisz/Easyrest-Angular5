package com.jkang.technicaltest.service;

import java.sql.SQLException;
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
public class UserServiceTest {
	
	public UserService userService;
	public String basePath;
	
	public UserServiceTest() {
		userService = new UserService();
		basePath = "localhost:8080/TechnicalTest/userservice/";
	}
	
	// this is the last thing i was developing...
	/*@Test
	public void getUserIdTest() throws SQLException, ClassNotFoundException {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(basePath + "user/{id}");
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
		WebTarget target = client.target(basePath + "users");
		Response response = target.request().get();
		try {
			assertEquals(202, response.getStatus());
		} finally {
			response.close();
			client.close();
		}
	}*/
	
}
