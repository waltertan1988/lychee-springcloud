package com.walter.lychee.admin;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walter.lychee.entity.JpaSysUser;
import com.walter.lychee.repository.SysUserRepository;
import com.walter.lychee.security.authenticate.UserRoleChangedEvent;
import com.walter.lychee.security.authorize.CustomFilterInvocationSecurityMetadataSource;
import com.walter.lychee.security.authorize.CustomRegexRequestMatcher;

@Controller
public class SysUserController extends BaseAdminController {
	
	@Autowired
	private SysUserRepository sysUserRepository;
	@Autowired
	private CustomFilterInvocationSecurityMetadataSource securityMetadataSource;
	@Autowired
	private ApplicationContext applicationContext;

	@GetMapping("/getUser")
	@ResponseBody
	public JpaSysUser getUser(@RequestParam String username) {
		JpaSysUser user = sysUserRepository.findByUsername(username);
		this.updateResRole();
		this.updateUserRole();
		return user;
	}
	
	private void updateResRole(){
		ConfigAttribute newConfigAttribute = SecurityConfig.createList("ROLE_LOGIN_USER").get(0);
		
		LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap = securityMetadataSource.getRequestMap();
		RequestMatcher requestMatcher1 = new CustomRegexRequestMatcher("/admin/.*", null);
		Collection<ConfigAttribute> ca = requestMap.get(requestMatcher1);
		if(!ca.contains(newConfigAttribute)){
			ca.add(newConfigAttribute);
		}
	}
	
	private void updateUserRole() {
		Set<SimpleGrantedAuthority> removedRoles = new HashSet<SimpleGrantedAuthority>();
		Set<SimpleGrantedAuthority> newRoles = new HashSet<SimpleGrantedAuthority>();
		newRoles.add(new SimpleGrantedAuthority("ROLE_LOGIN_USER"));
		
		UserRoleChangedEvent event = new UserRoleChangedEvent(this, removedRoles, newRoles);
		applicationContext.publishEvent(event);
	}
}
