package com.jkang.technicaltest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author erick
 */
@Entity
@Table(name="TM_USERS_ROLES")
@XmlRootElement(name="userrole")
@XmlType(propOrder={"id", "userid", "roleid"})
public class UserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="userid")
	@FormParam("userid")
	private int userid;
	
	@Column(name="roleid")
	@FormParam("roleid")
	private int roleid;
	
	// getters and setters
	
	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@XmlElement
	public int getUserId() {
		return userid;
	}

	public void setUserId(int userid) {
		this.userid = userid;
	}
	
	@XmlElement
	public int getRoleId() {
		return roleid;
	}

	public void setRoleId(int roleid) {
		this.roleid = roleid;
	}
	
}
