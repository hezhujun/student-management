package com.studentManagement.model;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3298722462311396341L;
	private Long studentId;
	private String name;
	private String sex;
	private Integer year;
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
	private String note;
	private Integer score1;
	private Integer score2;
	private Integer score3;
	private Integer score4;
	private String reward;
	private String tutor;
	private String educationLevel;
	private Integer studentPeriod;
	private String studyMode;
	private String qq;
	private String email;
	private String picture;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Long studentId, String name) {
		this.studentId = studentId;
		this.name = name;
	}

	/** full constructor */
	public Student(Long studentId, String name, String sex, Integer year,
			String nation, String political, String yearAndMonthOfBirth,
			String class_, String tel, String location, String idcard,
			String familyLocation, String postcode, String telOfFather,
			String telOfMother, String province, String studentStatus,
			String job, Boolean isInSchool, String note, Integer score1,
			Integer score2, Integer score3, Integer score4, String reward,
			String tutor, String educationLevel, Integer studentPeriod,
			String studyMode, String qq, String email, String picture) {
		this.studentId = studentId;
		this.name = name;
		this.sex = sex;
		this.year = year;
		this.nation = nation;
		this.political = political;
		this.yearAndMonthOfBirth = yearAndMonthOfBirth;
		this.class_ = class_;
		this.tel = tel;
		this.location = location;
		this.idcard = idcard;
		this.familyLocation = familyLocation;
		this.postcode = postcode;
		this.telOfFather = telOfFather;
		this.telOfMother = telOfMother;
		this.province = province;
		this.studentStatus = studentStatus;
		this.job = job;
		this.isInSchool = isInSchool;
		this.note = note;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.score4 = score4;
		this.reward = reward;
		this.tutor = tutor;
		this.educationLevel = educationLevel;
		this.studentPeriod = studentPeriod;
		this.studyMode = studyMode;
		this.qq = qq;
		this.email = email;
		this.picture = picture;
	}

	// Property accessors

	public Long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPolitical() {
		return this.political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public String getYearAndMonthOfBirth() {
		return this.yearAndMonthOfBirth;
	}

	public void setYearAndMonthOfBirth(String yearAndMonthOfBirth) {
		this.yearAndMonthOfBirth = yearAndMonthOfBirth;
	}

	public String getClass_() {
		return this.class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getFamilyLocation() {
		return this.familyLocation;
	}

	public void setFamilyLocation(String familyLocation) {
		this.familyLocation = familyLocation;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelOfFather() {
		return this.telOfFather;
	}

	public void setTelOfFather(String telOfFather) {
		this.telOfFather = telOfFather;
	}

	public String getTelOfMother() {
		return this.telOfMother;
	}

	public void setTelOfMother(String telOfMother) {
		this.telOfMother = telOfMother;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getStudentStatus() {
		return this.studentStatus;
	}

	public void setStudentStatus(String studentStatus) {
		this.studentStatus = studentStatus;
	}

	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Boolean getIsInSchool() {
		return this.isInSchool;
	}

	public void setIsInSchool(Boolean isInSchool) {
		this.isInSchool = isInSchool;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getScore1() {
		return this.score1;
	}

	public void setScore1(Integer score1) {
		this.score1 = score1;
	}

	public Integer getScore2() {
		return this.score2;
	}

	public void setScore2(Integer score2) {
		this.score2 = score2;
	}

	public Integer getScore3() {
		return this.score3;
	}

	public void setScore3(Integer score3) {
		this.score3 = score3;
	}

	public Integer getScore4() {
		return this.score4;
	}

	public void setScore4(Integer score4) {
		this.score4 = score4;
	}

	public String getReward() {
		return this.reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public String getTutor() {
		return this.tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public String getEducationLevel() {
		return this.educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public Integer getStudentPeriod() {
		return this.studentPeriod;
	}

	public void setStudentPeriod(Integer studentPeriod) {
		this.studentPeriod = studentPeriod;
	}

	public String getStudyMode() {
		return this.studyMode;
	}

	public void setStudyMode(String studyMode) {
		this.studyMode = studyMode;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

}