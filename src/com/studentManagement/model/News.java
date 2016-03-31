package com.studentManagement.model;

import java.sql.Timestamp;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7263662551613733189L;
	private Long id;
	private String title;
	private String subtitle;
	private Timestamp date;
	private String link;
	private String picLink;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(String title, String link) {
		this.title = title;
		this.link = link;
	}

	/** full constructor */
	public News(String title, String subtitle, Timestamp date, String link,
			String picLink) {
		this.title = title;
		this.subtitle = subtitle;
		this.date = date;
		this.link = link;
		this.picLink = picLink;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPicLink() {
		return this.picLink;
	}

	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}

}