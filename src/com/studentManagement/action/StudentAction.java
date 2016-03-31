package com.studentManagement.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.studentManagement.model.Student;
import com.studentManagement.service.MyService;
import com.studentManagement.service.ReadExcelUtil;

/**
 * 学生信息的增删查改
 * 
 * @author Hezhujun
 * 
 */
public class StudentAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7361558206746648063L;
	private MyService service; // 提供数据库操作的服务
	// 学生的信息
	private long studentId;
	private String name;
	private String sex;
	private int year;
	private String nation;
	private String political;
	private String yearAndMonthOfBirth;
	private String class_;
	private String tel;
	private String location;
	private String idcard;
	private String familyLocation;
	private String postcode;
	private String telOfFather;
	private String telOfMother;
	private String province;
	private String studentStatus;
	private String job;
	private Boolean isInSchool;
	private int score1;
	private int score2;
	private int score3;
	private int score4;
	private String reward;
	private String tutor;
	private String educationLevel;
	private int studentPeriod;
	private String studyMode;
	private String qq;
	private String email;
	private File picture; // 学生照片

	private File fileName; // xls文件

	/**
	 * 保存一个学生信息
	 * 
	 * @return
	 */
	public String saveStudent() {
		// 学号和姓名没有的不保存
		if (studentId == 0 || name == null || name.equals(""))
			return ERROR;
		String pic = studentId + ".jpg";
		Student student = new Student(studentId, name, sex, year, nation,
				political, yearAndMonthOfBirth, class_, tel, location, idcard,
				familyLocation, postcode, telOfFather, telOfMother, province,
				studentStatus, job, isInSchool, "", score1, score2, score3,
				score4, reward, tutor, educationLevel, studentPeriod,
				studyMode, qq, email, pic);
		// 移动图片文件到images
		if (picture != null) {
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("/images");
			// D:\apache-tomcat-6.0.18\webapps\项目名\images

			File savefile = new File(new File(realpath), pic);
			// 创建目录
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			if (savefile.exists()) {
				savefile.delete();
			}
			// 复制文件
			// FileUtils.copyFile(picture, savefile);
			picture.renameTo(savefile);
		}
		if (service.insertObjectForm(student)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 * 读取文件保存学生信息
	 * 
	 * @return
	 */
	public String saveManyStudents() {
		ReadExcelUtil readExcelUtil = new ReadExcelUtil();
		readExcelUtil.setService(service);
		try {
			List<String> stuName = readExcelUtil.readExcel(fileName);
			if (stuName.size() != 0) {
				ServletActionContext.getRequest().setAttribute("description",
						stuName + "没有录入成功");
			}
			return SUCCESS;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("description","请确认格式是否正确");
			return ERROR;
		}
	}

	/**
	 * 更新学生信息
	 * 
	 * @return
	 */
	public String updateStudent() {
		if (studentId == 0) {
			ServletActionContext.getRequest().setAttribute("description",
					"学号必须填写,注意要与原来的学号相同");
			return ERROR;
		}
		if ("".equals(name)) {
			ServletActionContext.getRequest().setAttribute("description",
					"姓名必须填写");
			return ERROR;
		}
		String findStudent = "from Student where studentId = " + studentId;
		Student student = (Student) service.getObjectForm(findStudent);
		if (student == null) {
			ServletActionContext.getRequest().setAttribute("description",
					"没有这个学生,请确认学号是否修改过");
			return ERROR;
		}
		student.setName(name);
		student.setSex(sex);
		student.setYear(year);
		student.setNation(nation);
		student.setPolitical(political);
		student.setYearAndMonthOfBirth(yearAndMonthOfBirth);
		student.setClass_(class_);
		student.setTel(tel);
		student.setLocation(location);
		student.setIdcard(idcard);
		student.setFamilyLocation(familyLocation);
		student.setPostcode(postcode);
		student.setTelOfFather(telOfFather);
		student.setTelOfMother(telOfMother);
		student.setProvince(province);
		student.setStudentStatus(studentStatus);
		student.setJob(job);
		student.setIsInSchool(isInSchool);
		student.setScore1(score1);
		student.setScore2(score2);
		student.setScore3(score3);
		student.setScore4(score4);
		student.setEducationLevel(educationLevel);
		student.setReward(reward);
		student.setTutor(tutor);
		student.setStudentPeriod(studentPeriod);
		student.setStudyMode(studyMode);
		student.setQq(qq);
		student.setEmail(email);
		// 移动图片文件到images
		if (picture != null) {
			String realpath = ServletActionContext.getServletContext()
					.getRealPath("/images");
			// D:\apache-tomcat-6.0.18\webapps\项目名\images

			File savefile = new File(new File(realpath), student.getPicture());
			// 创建目录
			if (!savefile.getParentFile().exists())
				savefile.getParentFile().mkdirs();
			if (savefile.exists()) {
				savefile.delete();
			}
			// 复制文件
			// FileUtils.copyFile(picture, savefile);
			picture.renameTo(savefile);
		}
		if (service.updateObjectForm(student))
			return SUCCESS;
		else {
			ServletActionContext.getRequest().setAttribute("description",
					"发生未知错误");
			return ERROR;
		}
	}

	/**
	 * 通过学号查找学生信息
	 * 
	 * @return
	 */
	public String searchStudent() {
		if(studentId == 0){
			return ERROR;
		}
		String findStudent = "from Student where studentId ='" + studentId
				+ "'";
		Student student = (Student) service.getObjectForm(findStudent);
		if (student == null) {
			return ERROR;
		}
		ServletActionContext.getRequest().setAttribute("student", student);
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public String getYearAndMonthOfBirth() {
		return yearAndMonthOfBirth;
	}

	public void setYearAndMonthOfBirth(String yearAndMonthOfBirth) {
		this.yearAndMonthOfBirth = yearAndMonthOfBirth;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getFamilyLocation() {
		return familyLocation;
	}

	public void setFamilyLocation(String familyLocation) {
		this.familyLocation = familyLocation;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelOfFather() {
		return telOfFather;
	}

	public void setTelOfFather(String telOfFather) {
		this.telOfFather = telOfFather;
	}

	public String getTelOfMother() {
		return telOfMother;
	}

	public void setTelOfMother(String telOfMother) {
		this.telOfMother = telOfMother;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStudentStatus() {
		return studentStatus;
	}

	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Boolean getIsInSchool() {
		return isInSchool;
	}

	public void setIsInSchool(Boolean isInSchool) {
		this.isInSchool = isInSchool;
	}

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
	}

	public int getScore3() {
		return score3;
	}

	public void setScore3(int score3) {
		this.score3 = score3;
	}

	public int getScore4() {
		return score4;
	}

	public void setScore4(int score4) {
		this.score4 = score4;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getTutor() {
		return tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public int getStudentPeriod() {
		return studentPeriod;
	}

	public void setStudentPeriod(int studentPeriod) {
		this.studentPeriod = studentPeriod;
	}

	public String getStudyMode() {
		return studyMode;
	}

	public void setStudyMode(String studyMode) {
		this.studyMode = studyMode;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public File getPicture() {
		return picture;
	}

	public void setPicture(File picture) {
		this.picture = picture;
	}

	public File getFileName() {
		return fileName;
	}

	public void setFileName(File fileName) {
		this.fileName = fileName;
	}

	public MyService getService() {
		return service;
	}

	public void setService(MyService service) {
		this.service = service;
	}

}
