package com.studentManagement.action;

import com.studentManagement.model.Teacher;

public class TeacherLogin extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1810184899704546712L;
	private String account;
	private String password;
	
	@Override
	public String execute() throws Exception {
		String sql = "from Teacher where account='" + account + "' and password='"
				+ password + "'";
		Teacher teacher = (Teacher) getService().getObjectForm(sql);
		if (teacher == null)
			return ERROR;
		else{
			sendObject("teacher", teacher);
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
	
	
}
