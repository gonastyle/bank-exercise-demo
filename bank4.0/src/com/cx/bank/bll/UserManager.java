package com.cx.bank.bll;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.cx.bank.filter.HibernateFilter;
import com.cx.bank.model.User;


//业务逻辑层，管理user的数据
public class UserManager {
	
	//单例模式
	private static UserManager instance = new UserManager();

	public static UserManager getInstance() {
		return instance;
	}
	
	private UserManager(){
		
	}
	
	
	// 查找
	public User findUserById(String id) {

		Session session = null;
		User u = null;

		session = HibernateFilter.getSession();
		session.beginTransaction();
		//不使用懒加载
		u = (User) session.get(User.class, id);
		
		session.getTransaction().commit();
		
		return u;
	}

	// 修改密码
	public boolean modifyUserPwd(String id, String pwd) {

		Session session = null;
		try {
			session = HibernateFilter.getSession();
			session.beginTransaction();
			session.createQuery("update User u set u.upwd=? where u.uid=?")
					.setParameter(0, pwd).setParameter(1, id).executeUpdate();

			session.getTransaction().commit();
		} catch (Exception e) {
			// 记录日志,log4j等......
			e.printStackTrace();
			session.getTransaction().rollback();

			return false;
		}

		return true;
	}

	// 登陆
	public boolean userLogin(String id, String pwd) {

		Session session = null;

		session = HibernateFilter.getSession();
		session.beginTransaction();
		// 查询是否有这条记录。
		Query user = session.createQuery(
				"select count(*) from User u where uid=? and upwd=?")
				.setParameter(0, id).setParameter(1, pwd);
		Long count = (Long) user.uniqueResult();
		
		session.getTransaction().commit();
		//session.close();

		if (count != 0) {
			return true;
		} else {
			return false;
		}

	}

	// 显示所有用户
	public List showAllUser() {

		Session session = null;
		List u = null;

		session = HibernateFilter.getSession();
		session.beginTransaction();

		u = session.createQuery("from User").list();
		session.getTransaction().commit();
		//session.close();
		return u;
	}

	// 查询余额
	public String findUserMoney(String id) {

		Session session = null;
		session = HibernateFilter.getSession();
		
		session.beginTransaction();
		//不使用懒加载
		User u = (User) session.get(User.class, id);
		
		session.getTransaction().commit();

        if(u!=null){
		Double m = u.getUmoney();
		String money = String.valueOf(m);
		return money;
		}else{
			return null;
		}
        
	}

	// 取款
	public boolean takeMoney(String id, String money) {

		Double curr = Double.valueOf(findUserMoney(id));
		Double m = Double.valueOf(money);
		//判断余额是否够用
		if (curr != null&&curr>m) {
			Session session = null;
			m=curr-m;
			try {
				session = HibernateFilter.getSession();
				session.beginTransaction();
				session.createQuery(
						"update User u set u.umoney=? where u.uid=?")
						.setParameter(0, m).setParameter(1, id).executeUpdate();

				session.getTransaction().commit();

			} catch (NumberFormatException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				// 记录日志,log4j等......
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} 
			
			return true;
		} else {
			return false;
		}

	}

	// 存款
	public boolean saveMoney(String id, String money) {
		
		Double curr = Double.valueOf(findUserMoney(id));
		Double m = Double.valueOf(money);
			Session session = null;
			//更新余额
			m=curr+m;
			try {
				session = HibernateFilter.getSession();
				session.beginTransaction();
				session.createQuery(
						"update User u set u.umoney=? where u.uid=?")
						.setParameter(0, m).setParameter(1, id).executeUpdate();

				session.getTransaction().commit();

			} catch (NumberFormatException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				// 记录日志,log4j等......
				e.printStackTrace();
				session.getTransaction().rollback();
				return false;
			} 
			
			return true;
		
	}

	// 转账
	public boolean transferMoney(String id1, String id2, String money) {
		
		if(takeMoney(id1,money)&&saveMoney(id2,money)){
			return true;
		}
		return false;
		
	}

	// 注册
	public boolean registerUser(User u) {

		Session session=null;
		try{
			session = HibernateFilter.getSession();
		session.beginTransaction();
		
		session.save(u);
		
		session.getTransaction().commit();
		
		}catch(Exception e){
			session.getTransaction().rollback();
			return false;
		}
		
		return true;
	}

}
