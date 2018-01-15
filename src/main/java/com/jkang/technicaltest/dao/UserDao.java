package com.jkang.technicaltest.dao;

import com.jkang.technicaltest.model.User;
import com.jkang.technicaltest.model.UserRole;
import com.jkang.technicaltest.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author erick
 */
public class UserDao {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public User getUserById(int id) {
		User user = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			user = (User) session.createQuery("from User u where u.id = :id")
								 .setParameter("id", id)
								 .uniqueResult();
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
		return user;
	}
	
	public List<User> getAllUsers() {
		List<User> users = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			users = session.createQuery("from User").list();
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
		return users;
	}
	
	// this method can both insert a new user and update existing one
	public boolean saveUser(User user, List<String> roleid) {
		Session session = null;
		boolean hasErrors = false;
		
		String role1 = "";
		String role2 = "";
		
		String stringRoles = roleid.get(0);
		String[] roles = stringRoles.split(",");
		
		UserRole userRole1 = new UserRole();
		UserRole userRole2 = new UserRole();
		UserRoleDao userRoleDao = new UserRoleDao();
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.saveOrUpdate(user);
			session.getTransaction().commit();
			// save the relationship between the user and role tables
			if (roles.length == 1) {
				role1 = roles[0];
				userRole1.setUserId(user.getId());
				userRole1.setRoleId(Integer.parseInt(role1));
				userRoleDao.saveUserRoles(userRole1);
			} else if (roles.length == 2) {
				role1 = roles[0];
				role2 = roles[1];
				userRole1.setUserId(user.getId());
				userRole1.setRoleId(Integer.parseInt(role1));
				userRoleDao.saveUserRoles(userRole1);
				
				userRole2.setUserId(user.getId());
				userRole2.setRoleId(Integer.parseInt(role2));
				userRoleDao.saveUserRoles(userRole2);
			}
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
	
	public boolean deleteUser(User user) {
		Session session = null;
		boolean hasErrors = false;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(user);
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
