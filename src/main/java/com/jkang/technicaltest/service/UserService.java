package com.jkang.technicaltest.service;

import com.google.gson.Gson;
import com.jkang.technicaltest.dao.UserDao;
import com.jkang.technicaltest.model.User;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;;
import org.jboss.resteasy.annotations.providers.jaxb.Formatted;

/**
 *
 * @author erick
 */
@Path("userservice")
public class UserService {
	
	private UserDao userDao = new UserDao();
	
	// Method which should return a single user object in JSON format
	@GET
	@PermitAll
	@Path("/user/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int id) {
		if (userDao.getUserById(id) != null) {
			return Response
					.ok(new Gson().toJson(userDao.getUserById(id)), MediaType.APPLICATION_JSON)
					.status(Response.Status.ACCEPTED)
					.build();
		} else {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		}
	}
	
	// Method which should return a list of all user objects in JSON format
	@GET
	@PermitAll
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() throws SQLException, ClassNotFoundException {
		if (userDao.getAllUsers().size() > 0) {
			return Response
					.ok(new Gson().toJson(userDao.getAllUsers()), MediaType.APPLICATION_JSON)
					.status(Response.Status.ACCEPTED)
					.build();
		} else {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
	
	// Method which insert a new user
	//@RolesAllowed("ADMIN")
	@POST
	@PermitAll
	@Path("/user")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	@Formatted
	public Response saveNewUser(@FormParam("name") String name,
								@FormParam("roleid") List<String> roleid) {
		User user = new User();
		user.setName(name);
		
		if (!userDao.saveUser(user, roleid)) {
			return Response
					.ok(new Gson().toJson(user), MediaType.APPLICATION_JSON)
					.status(Response.Status.CREATED)
					.build();
		} else {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
	
	@DELETE
	@PermitAll
	@Path("/user/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON })
	@Formatted
	public Response deleteUser(@PathParam("id") int id) {
		User user = new User();
		user.setId(id);
		
		if (!userDao.deleteUser(user)) {
			return Response
					.ok(new Gson().toJson(user), MediaType.APPLICATION_JSON)
					.status(Response.Status.ACCEPTED)
					.build();
		} else {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
	
}
