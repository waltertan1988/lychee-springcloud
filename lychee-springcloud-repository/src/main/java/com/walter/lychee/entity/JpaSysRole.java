package com.walter.lychee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SYS_ROLE")
public class JpaSysRole extends AbstractAuditable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name="ROLE_CODE", length=255, unique=true, nullable=false)
	private String roleCode;
	
	@Column(name="ROLE_NAME", length=255)
	private String roleName;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return false;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setId(long id) {
		this.id = id;
	}
}
