package com.studentManagement.action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.studentManagement.service.MyService;

/**
 * 发送json数据的action模版
 * @author Hezhujun
 *
 */
public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4528874435574596742L;
	private Map<String, Object> dataMap;  // 传输数据的属性，必须有get方法
	private MyService service;

	public BaseAction() {
		// 属性初始化
		// dataMap初始化
		dataMap = new HashMap<String, Object>();
		dataMap.clear();
		
	}

	public ServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public ServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	public ServletContext getContext() {
		return ServletActionContext.getServletContext();
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 * 发送数据
	 * @param name
	 * @param object
	 */
	public void sendObject(String name, Object object) {
		addData(name, object);
	}
	
	/**
	 * 添加需要发送的数据
	 * @param name
	 * @param object
	 */
	public void addData(String name, Object object){
		dataMap.put(name, object);
	}

	public MyService getService() {
		return service;
	}

	public void setService(MyService service) {
		this.service = service;
	}
}
