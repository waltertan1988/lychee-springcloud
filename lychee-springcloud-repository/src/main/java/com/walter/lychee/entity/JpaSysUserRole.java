package com.walter.lychee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SYS_USER_ROLE")
public class JpaSysUserRole extends AbstractAuditable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name="USERNAME", length=255, nullable=false)
	private String username;
	
	@Column(name="ROLE_CODE", length=255, nullable=false)
	private String roleCode;
	
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

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public void setId(long id) {
		this.id = id;
	}
}
