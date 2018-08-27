package com.walter.lychee.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

@Entity
@Table(name="SYS_ROLE")
public class SysRole implements Persistable<Long> {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private long id;
	
	@Column(name="ROLE_CODE", length=255, unique=true, nullable=false)
	private String roleCode;
	
	@Column(length=255, name="ROLE_NAME")
	private String roleName;
	
	@ManyToMany(cascade={CascadeType.REFRESH}, 
			fetch=FetchType.EAGER, 
			mappedBy="sysRoles")// 由mappedBy指定关系被维护端
	private Set<SysUser> sysUsers;

	public Set<SysUser> getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}

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
