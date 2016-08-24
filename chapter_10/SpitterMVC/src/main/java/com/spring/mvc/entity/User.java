package com.spring.mvc.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="user")
@XmlRootElement
public class User {
	
	private Long id;
	
	@Size(min=3, max=20, message="Username must be between 3 and 20 characters long.")
	@Pattern(regexp="^[a-zA-Z0-9]+$",	message="Username must be alphanumeric with no spaces")
	private String username;
	
	@Size(min=6, max=20, message="The password must be at least 6 characters long.")
	private String password;
	
	@Size(min=3, max=50, message="Your full name must be between 3 and 50 characters long.")
	private String fullName;

	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message="Invalid email address.")
	private String email;
	private List<Message> messages;

	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;
	
	public User() {}
	
	public User(String username, String password, String fullName, String email) {
		this(null, username, password, fullName, email);
	}
	
	public User(Long id, String username, String password, String fullName, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy = AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="username", unique=true)
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="fullname")
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval=true, fetch = FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<Message> getMessages() {
		return messages;
	}
	
	public void setMessages(List<Message> messages) {
		 this.messages = messages;
	}

	public Role getRole(){
		return role;
	}

	public void setRole(Role role){
		this.role = role;
	}
}
