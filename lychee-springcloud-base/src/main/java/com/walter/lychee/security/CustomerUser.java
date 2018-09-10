package com.walter.lychee.security;

import java.util.Collection;
import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomerUser extends User {
	
	private static final long serialVersionUID = 1L;
	
	private Date obtainAuthorityTime;
	
	public CustomerUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Date obtainAuthorityTime) {
		super(username, password, authorities);
		this.obtainAuthorityTime = obtainAuthorityTime;
	}

	public Date getObtainAuthorityTime() {
		return obtainAuthorityTime;
	}

	public void setObtainAuthorityTime(Date obtainAuthorityTime) {
		this.obtainAuthorityTime = obtainAuthorityTime;
	}
}
