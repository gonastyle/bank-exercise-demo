package com.cx.bank.util;

import org.hibernate.Session;

import com.cx.bank.model.User;

public class InitData {

	public static void main(String[] args) {
		Session session = null; 
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			
			User u1 = new User();
			u1.setUid("18070514453");
			u1.setUname("ÕÅÉØº­");
			u1.setUpwd("1234");
			u1.setUmoney(100.0);
			session.save(u1);
			
			User u2 = new User();
			u2.setUid("18720087044");
			u2.setUname("Áú»á¼ª");
			u2.setUpwd("1234");
			u2.setUmoney(100.0);
			session.save(u2);
			
			session.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSession(session);
		}

	}

}
