package com.cx.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.cx.bank.bll.UserManager;
import com.cx.bank.form.UserOperationActionForm;
import com.cx.bank.model.User;

/**
 * 统一处理所有的请求
 * @author Administrator
 *
 */
public class UserOperationAction extends BaseAction {

	
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
	
	public ActionForward find(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UserOperationActionForm iaf = (UserOperationActionForm)form;
		UserManager am = UserManager.getInstance();
		User u = (User) request.getSession().getAttribute("user");
		String id = u.getUid();
		String money=am.findUserMoney(id);
		request.setAttribute("money",money);
		return mapping.findForward("find");
	}
	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取从页面表单中提交过来的值
		UserOperationActionForm iaf = (UserOperationActionForm)form;
		String money=iaf.getUmoney();
		UserManager am = UserManager.getInstance();
		User u = (User) request.getSession().getAttribute("user");
		String id = u.getUid();
		if(am.saveMoney(id, money)){
			request.setAttribute("msg", "存款成功");
		}else{
			request.setAttribute("msg", "存款失败");
		}
		
		return mapping.findForward("save");
	}
	public ActionForward take(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取从页面表单中提交过来的值
		UserOperationActionForm iaf = (UserOperationActionForm)form;
		String money=iaf.getUmoney();
		UserManager am = UserManager.getInstance();
		User u = (User) request.getSession().getAttribute("user");
		String id = u.getUid();
		if(am.takeMoney(id, money)){
			request.setAttribute("msg", "取款成功");
		}else{
			request.setAttribute("msg", "系统出错或余额不足");
		}
		return mapping.findForward("take");
	}
	public ActionForward transfer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取从页面表单中提交过来的值
		UserOperationActionForm iaf = (UserOperationActionForm)form;
		String money=iaf.getUmoney();
		UserManager am = UserManager.getInstance();
		User u = (User) request.getSession().getAttribute("user");
		String id1 = u.getUid();
		String id2 = iaf.getUid();
		if (am.transferMoney(id1, id2,money)) {
			request.setAttribute("msg", "转账成功");
		}else{
			request.setAttribute("msg", "转入账号不存在或余额不足");
		}
		return mapping.findForward("transfer");
	}
	
	public ActionForward modify(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//获取从页面表单中提交过来的值
		UserOperationActionForm iaf = (UserOperationActionForm)form;
		String money=iaf.getUmoney();
		UserManager am = UserManager.getInstance();
		User u = (User) request.getSession().getAttribute("user");
		String id = u.getUid();
		String pwd=iaf.getUpwd();
		if(am.modifyUserPwd(id, pwd)){
			request.setAttribute("msg", "修改成功");
		}else{
			request.setAttribute("msg", "修改失败");
		}
		return mapping.findForward("modify");
	}
	


}