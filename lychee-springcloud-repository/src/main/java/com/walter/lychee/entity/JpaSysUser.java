package com.walter.lychee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SYS_USER")
public class JpaSysUser extends AbstractAuditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;

	@Column(name = "username", length = 255, unique = true, nullable = false)
	private String username;

	@Column(length = 255, name = "user_real_name")
	private String userRealName;

	@Column(length = 255, nullable = false, name = "password")
	private String password;

	@Column(length = 1, nullable = false, name = "gender")
	private String gender;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return false;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setId(long id) {
		this.id = id;
	}
}
