package com.jkang.technicaltest.service;

import com.google.gson.Gson;
import com.jkang.technicaltest.dao.UserRoleDao;
import java.sql.SQLException;
import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author erick
 */
@Path("userroleservice")
public class UserRoleService {

	private UserRoleDao userRoleDao = new UserRoleDao();
	
	@GET
	@PermitAll
	@Path("/rolesbyuserid/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRolesByUserId(@PathParam("userid") int userid) {
		if (userRoleDao.getRolesByUserId(userid).size() > 0) {
			return Response
					.ok(new Gson().toJson(userRoleDao.getRolesByUserId(userid)), MediaType.APPLICATION_JSON)
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
	@Path("/usersroles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsers() throws SQLException, ClassNotFoundException {
		if (userRoleDao.getAllUsersRoles().size() > 0) {
			return Response
					.ok(new Gson().toJson(userRoleDao.getAllUsersRoles()), MediaType.APPLICATION_JSON)
					.status(Response.Status.ACCEPTED)
					.build();
		} else {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
	
}
