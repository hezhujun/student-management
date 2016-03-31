package com.studentManagement.action;

import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionSupport;
import com.studentManagement.model.News;
import com.studentManagement.service.MyService;

/**
 * 保存新闻action
 * 
 * @author Hezhujun
 * 
 */
public class SaveNewsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -275367813128886151L;
	private String title;
	private String subtitle;
	private String link;
	private String picLink;
	private String time;
	private MyService service;
	
	@Override
	public String execute() throws Exception {
		try {
			Timestamp date = Timestamp.valueOf(time + " 00:00:00");
	
			News news = new News(title, subtitle, date, link, picLink);
			if (service.insertObjectForm(news)) {
				return SUCCESS;
			} else {
				return ERROR;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPicLink() {
		return picLink;
	}

	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public MyService getService() {
		return service;
	}

	public void setService(MyService service) {
		this.service = service;
	}

}
