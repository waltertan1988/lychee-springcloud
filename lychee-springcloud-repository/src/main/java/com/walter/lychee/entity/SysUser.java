package com.walter.lychee.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

@Entity
@Table(name = "SYS_USER")
public class SysUser implements Persistable<Long> {
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

	@ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinTable(name = "SYS_USER_ROLE", 
		// 关系被维护端的外键名
		inverseJoinColumns = @JoinColumn(name = "ROLE_CODE", referencedColumnName = "ROLE_CODE"),
		// 关系维护端的外键名
		joinColumns = @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")
	)
	private Set<SysRole> sysRoles;

	public Set<SysRole> getSysRoles() {
		return sysRoles;
	}

	public void setRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

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
