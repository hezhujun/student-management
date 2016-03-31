package com.studentManagement.action;

import java.sql.Timestamp;

import com.studentManagement.model.Sign;

/**
 * 签到请求对应的action
 * 
 * @author Hezhujun
 * 
 */
public class SignAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8677804331709858490L;
	private long studentId;
	private String location;
	private long date;
	private Timestamp time;

	@Override
	public String execute() throws Exception {
		// 判断之前是否签到过
		if (getService().isAlreadySigned(studentId, time)) {
			sendObject("success", true);
			return SUCCESS;
		} else {
			// 签到记录保存
			Sign sign = new Sign(studentId, time, location);
			if (getService().insertObjectForm(sign)) {
				sendObject("success", true);
			} else {
				sendObject("success", false);
			}
			return SUCCESS;
		}
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
		time = new Timestamp(date);
	}

}
