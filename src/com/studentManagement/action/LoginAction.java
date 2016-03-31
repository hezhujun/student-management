package com.studentManagement.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.studentManagement.model.Teacher;
import com.studentManagement.service.MyService;

/**
 * 后台登陆
 * 
 * @author Hezhujun
 * 
 */
public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7466352948284668916L;
	private String account;
	private String password;
	MyService service;

	@Override
	public String execute() throws Exception {
		String sql = "from Teacher where account='" + account + "' and password='"
				+ password + "'";
		Teacher teacher = (Teacher) service.getObjectForm(sql);
		if (teacher == null)
			return ERROR;
		else{
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", teacher.getAccount());
			return SUCCESS;
		}
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MyService getService() {
		return service;
	}

	public void setService(MyService service) {
		this.service = service;
	}

}
