package com.walter.lychee.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.walter.lychee.entity.JpaSysUser;
import com.walter.lychee.entity.JpaSysUserRole;
import com.walter.lychee.repository.SysUserRepository;
import com.walter.lychee.repository.SysUserRoleRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private SysUserRepository sysUserRepository;
	@Autowired
	private SysUserRoleRepository sysUserRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		JpaSysUser sysUser = sysUserRepository.findByUsername(username);
		
		if(sysUser != null) {
			Set<GrantedAuthority> authoritySet = new HashSet<GrantedAuthority>();
			for(JpaSysUserRole jpaSysUserRole : sysUserRoleRepository.findByUsername(username)) {
				authoritySet.add(new SimpleGrantedAuthority(jpaSysUserRole.getRoleCode()));
			}
			UserDetails userDetails = new User(username, sysUser.getPassword(), authoritySet);
			
			return userDetails;
		}
		
		return null;
	}
}
