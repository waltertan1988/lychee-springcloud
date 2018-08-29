package com.walter.lychee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="SYS_ROLE")
public class JpaSysRole extends AbstractAuditable {
	
	@Column(name="ROLE_CODE", length=255, unique=true, nullable=false)
	private String roleCode;
	
	@Column(name="ROLE_NAME", length=255)
	private String roleName;

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
}
