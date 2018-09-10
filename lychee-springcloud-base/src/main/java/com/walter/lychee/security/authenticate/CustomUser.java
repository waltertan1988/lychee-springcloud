package com.walter.lychee.security.authenticate;

import java.util.Collection;

import org.springframework.context.ApplicationListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User implements ApplicationListener<UserRoleChangedEvent>{

	private static final long serialVersionUID = 1L;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	@Override
	public void onApplicationEvent(UserRoleChangedEvent event) {
		Collection<GrantedAuthority> grantedAuthorities = this.getAuthorities();
		grantedAuthorities.removeAll(event.getRemovedRoles());
		
		for(GrantedAuthority newRole : event.getNewRoles()) {
			if(!grantedAuthorities.contains(newRole)) {
				grantedAuthorities.add(newRole);
			}
		}
	}
}
