package com.studentManagement.action;

import java.util.List;

import com.studentManagement.model.Student;

/**
 * 多条件查找学生
 * @author Hezhujun
 *
 */
public class SearchStudentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5961989480514105568L;
	private long studentId;
	private String name;
	private int year;
	private String nation;
	private String political;
	private String class_;
	private String tel;
	private String idcard;
	private String province;

	@Override
	public String execute() throws Exception {
		List<Student> studentList = getService().searchStudent(studentId, name,
				year, nation, political, class_, tel, idcard, province);
		sendObject("student", studentList);
		return SUCCESS;
	}
	
	public String getStudent() throws Exception {
		List<Student> studentList = getService().searchStudent(studentId, null,
				0, null, null, null, null, null, null);
		if(studentList != null && studentList.size() != 0){
			sendObject("student", studentList.get(0));
		}
		return SUCCESS;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPolitical() {
		return political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

}