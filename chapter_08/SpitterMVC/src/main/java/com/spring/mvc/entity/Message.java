package com.spring.mvc.entity;

import java.util.Date;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;


@Entity
@Table(name="message")
public class Message {
	private long id;
	private String text;
	private User user;
	private Date createdAt;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Column(name="text")
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name="created_at")
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
