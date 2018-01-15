package com.jkang.technicaltest.dao;

import com.jkang.technicaltest.model.UserRole;
import com.jkang.technicaltest.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author erick
 */
public class UserRoleDao {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<UserRole> getRolesByUserId(int userid) {
		List<UserRole> roles = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.getTransaction();
			
			roles = session.createQuery("from UserRole u where u.userid = :userid")
								.setParameter("userid", userid)
								.list();
		} catch (Exception ex) {
			if (session != null) {
				System.out.println("Exception :: " + ex.getMessage());
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return roles;
	}
	
	public List<UserRole> getAllUsersRoles() {
		List<UserRole> usersRoles = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			usersRoles = session.createQuery("from UserRole").list();
			session.getTransaction().commit();
		} catch (Exception ex) {
			if (session != null) {
				System.out.println("Exception :: " + ex.getMessage());
				session.getTransaction().rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return usersRoles;
	} 
	
	// this method create the relationships between user and role tables
	public boolean saveUserRoles(UserRole userRole) {
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(userRole);
			session.getTransaction().commit();
		} catch (Exception ex) {
			if (session != null) {
				System.out.println("Exception :: " + ex.getMessage());
				session.getTransaction().rollback();
			}
			hasErrors = true;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return hasErrors;
	}
}
