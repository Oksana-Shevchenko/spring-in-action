package com.spring.dao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Rant {
	private Integer id;
	private String rantText;
	private Date postedDate;
	public Rant() {}
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	 
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="rantText", unique=true) 
	public String getRantText() {
		return rantText;
	}
	
	public void setRantText(String rantText) {
		this.rantText = rantText;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="postedDate", unique=true) 
	public Date getPostedDate() {
		return postedDate;
	}
	
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}
}
