package com.cx.bank.bll;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cx.bank.model.User;

//业务逻辑层，管理user的数据
public class UserManagerImpl extends HibernateDaoSupport implements UserManager{

	// 查找
	public User findUserById(String id) {
		
		User u = (User) this.getSession().get(User.class, id);
		
		return u;
	}

	// 修改密码
	public boolean modifyUserPwd(String id, String pwd) {

		try {
			this.getSession().createQuery(
					"update User u set u.upwd=? where u.uid=?").setParameter(0,
					pwd).setParameter(1, id).executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

			return false;
		}

		return true;
	}

	// 登陆
	public boolean userLogin(String id, String pwd) {

		// 查询是否有这条记录。
		Query user = this.getSession().createQuery(
				"select count(*) from User u where uid=? and upwd=?")
				.setParameter(0, id).setParameter(1, pwd);
		Long count = (Long) user.uniqueResult();

		if (count != 0) {
			return true;
		} else {
			return false;
		}

	}

	// 查询余额
	public String findUserMoney(String id) {

		// 不使用懒加载
		User u = (User) this.getSession().get(User.class, id);
		if (u != null) {
			Double m = u.getUmoney();
			String money = String.valueOf(m);
			return money;
		} else {
			return null;
		}

	}

	// 取款
	public boolean takeMoney(String id, String money) {

		Double curr = Double.valueOf(findUserMoney(id));
		Double m = Double.valueOf(money);
		// 判断余额是否够用
		if (curr != null && curr > m) {
			m = curr - m;
			try {
				this.getSession().createQuery(
						"update User u set u.umoney=? where u.uid=?")
						.setParameter(0, m).setParameter(1, id).executeUpdate();

			} catch (NumberFormatException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				// 记录日志,log4j等......
				e.printStackTrace();
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

		// 更新余额
		m = curr + m;
		try {
			this.getSession().createQuery(
					"update User u set u.umoney=? where u.uid=?").setParameter(
					0, m).setParameter(1, id).executeUpdate();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		}

		return true;

	}

	// 转账
	public boolean transferMoney(String id1, String id2, String money) {

		if (takeMoney(id1, money) && saveMoney(id2, money)) {
			return true;
		}
		return false;

	}

	// 注册
	public boolean registerUser(User u) {

		try {

			this.getSession().save(u);

		} catch (Exception e) {

			return false;
		}

		return true;
	}

}
