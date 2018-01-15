package com.jkang.technicaltest.dao;

import com.jkang.technicaltest.model.Role;
import com.jkang.technicaltest.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author erick
 */
public class RoleDao {
	
	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	public List<Role> getAllRoles() {
		
		List<Role> roles = null;
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			roles = session.createQuery("from Role").list();
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
		return roles;
	}
	
}
