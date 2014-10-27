package com.cx.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cx.bank.bll.UserManager;
import com.cx.bank.form.UserOperationActionForm;
import com.cx.bank.model.User;

/**
 * 统一处理所有的请求
 * 
 * @author Administrator
 * 
 */
public class UserOperationAction extends BaseAction {

	// 使用IOC注入um
	private UserManager um;

	public void setUm(UserManager um) {
		this.um = um;
	}

	/**
	 * 如果没有传递任何标识参数（如command参数），则默认调用unspecified方法
	 */
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("ItemAction=>>unspecified()");
		ActionForward listActionForward = new ActionForward("/index.jsp", true);
		return listActionForward;
	}

	// 查询余额
	public ActionForward find(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserOperationActionForm iaf = (UserOperationActionForm) form;

		User u = (User) request.getSession().getAttribute("user");
		String id = u.getUid();
		String money = um.findUserMoney(id);
		request.setAttribute("money", money);

		return mapping.findForward("find");
	}

	// 存款
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取从页面表单中提交过来的值
		UserOperationActionForm iaf = (UserOperationActionForm) form;
		String money = iaf.getUmoney();

		User u = (User) request.getSession().getAttribute("user");
		String id = u.getUid();

		boolean flag = money.matches("^[1-9]+(.[0-9]{2})?$");
		if (flag) {
			if (um.saveMoney(id, money)) {
				request.setAttribute("msg", "存款成功");
			} else {
				request.setAttribute("msg", "存款失败");
			}
		} else {
			request.setAttribute("msg", "数据格式不正确");
		}

		return mapping.findForward("save");
	}

	// 取款
	public ActionForward take(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 获取从页面表单中提交过来的值
		UserOperationActionForm iaf = (UserOperationActionForm) form;
		String money = iaf.getUmoney();

		User u = (User) request.getSession().getAttribute("user");
		String id = u.getUid();
		// 验证有两位小数的正实数
		boolean flag = money.matches("^[1-9]+(.[0-9]{2})?$");

		if (flag) {

			if (um.takeMoney(id, money)) {
				request.setAttribute("msg", "取款成功");
			} else {
				request.setAttribute("msg", "系统出错或余额不足");
			}

		} else {
			request.setAttribute("msg", "数据格式不正确");
		}
		return mapping.findForward("take");
	}

	// 转账
	public ActionForward transfer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取从页面表单中提交过来的值
		UserOperationActionForm iaf = (UserOperationActionForm) form;
		String money = iaf.getUmoney();

		User u = (User) request.getSession().getAttribute("user");

		String id1 = u.getUid();
		String id2 = iaf.getUid();

		boolean flag = money.matches("^[1-9]+(.[0-9]{2})?$");
		if (flag) {

			if (um.findUserById(id2) != null) {
				if (!id1.equals(id2)) {
					if (um.transferMoney(id1, id2, money)) {
						request.setAttribute("msg", "转账成功");
					} else {
						request.setAttribute("msg", "余额不足");
					}
				} else {
					request.setAttribute("msg", "不能转给自己！");
				}

			} else {

				request.setAttribute("msg", "转入账号不存在！");
			}
		} else {
			request.setAttribute("msg", "数据格式不正确");
		}
		return mapping.findForward("transfer");
	}

	// 修改密码
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 获取从页面表单中提交过来的值
		UserOperationActionForm iaf = (UserOperationActionForm) form;
		String money = iaf.getUmoney();

		User u = (User) request.getSession().getAttribute("user");
		String id = u.getUid();
		String pwd = iaf.getUpwd();
		if (um.modifyUserPwd(id, pwd)) {

			request.setAttribute("msg", "修改成功");

		} else {

			request.setAttribute("msg", "修改失败");

		}
		return mapping.findForward("modify");
	}

}