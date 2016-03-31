package com.studentManagement.model;

import java.sql.Timestamp;

/**
 * Sign entity. @author MyEclipse Persistence Tools
 */

public class Sign implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3326412837037085975L;
	private Long id;
	private Long studentId;
	private Timestamp date;
	private String location;

	// Constructors

	/** default constructor */
	public Sign() {
	}

	/** full constructor */
	public Sign(Long studentId, Timestamp date, String location) {
		this.studentId = studentId;
		this.date = date;
		this.location = location;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}