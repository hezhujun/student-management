package com.studentManagement.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.studentManagement.service.MyService;

public class SignedAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -384351060698353137L;
	private String day; // 格式2015-10-08
	private MyService service;

	@Override
	public String execute() throws Exception {
		if (day == null || day.equals("")) {
			// day为空时查询今天
			day = new Timestamp(System.currentTimeMillis()).toString()
					.substring(0, 10);
		}
		Map<Integer, List<Object[]>> map = service.getSigned(day);
		if (map.isEmpty()) {
			ServletActionContext.getRequest().setAttribute("description",
					"发生未知错误");
			return ERROR;
		} else {
			ServletActionContext.getRequest().setAttribute("map",
					service.getSigned(day));
			ServletActionContext.getRequest().setAttribute("day", day);
			return SUCCESS;
		}
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public MyService getService() {
		return service;
	}

	public void setService(MyService service) {
		this.service = service;
	}
}
