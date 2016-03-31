package com.studentManagement.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.studentManagement.model.Teacher;
import com.studentManagement.service.MyService;

public class TeacherAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1894065749113668306L;
	private String account;
	private String name;
	private String password;
	private MyService service;

	@Override
	public String execute() throws Exception {
		if("".equals(account) || "".equals(name) || "".equals(password)){
			ServletActionContext.getRequest().setAttribute("description", "所有信息都必须填写");
			return ERROR;
		}
		String sql = "from Teacher where account='" + account + "'";
		Teacher teacher = (Teacher) service.getObjectForm(sql);
		if(teacher != null){
			ServletActionContext.getRequest().setAttribute("description", "该用户已注册");
			return ERROR;
		}
		teacher = new Teacher(account, name, password);
		if (service.insertObjectForm(teacher))
			return SUCCESS;
		else{
			ServletActionContext.getRequest().setAttribute("description", "发生未知错误");
			return ERROR;
		}
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
