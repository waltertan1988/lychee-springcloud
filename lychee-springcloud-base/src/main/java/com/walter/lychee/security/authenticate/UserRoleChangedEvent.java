package com.walter.lychee.security.authenticate;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationEvent;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserRoleChangedEvent extends ApplicationEvent{
	
	private Set<SimpleGrantedAuthority> removedRoles = new HashSet<SimpleGrantedAuthority>();
	private Set<SimpleGrantedAuthority> newRoles = new HashSet<SimpleGrantedAuthority>();

	private static final long serialVersionUID = 1L;

	public UserRoleChangedEvent(Object source, Set<SimpleGrantedAuthority> removedRoles, Set<SimpleGrantedAuthority> newRoles) {
		super(source);
		this.removedRoles.addAll(removedRoles);
		this.newRoles.addAll(newRoles);
	}

	public Set<SimpleGrantedAuthority> getRemovedRoles() {
		return removedRoles;
	}

	public Set<SimpleGrantedAuthority> getNewRoles() {
		return newRoles;
	}
}
