package com.walter.lychee.api.user.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.walter.lychee.api.res.ResApi;
import com.walter.lychee.api.user.UserApi;
import com.walter.lychee.entity.JpaSysUser;
import com.walter.lychee.repository.SysUserRepository;

@RestController
public class UserApiImpl extends BaseUserApiImpl implements UserApi {
	
	@Autowired
	private ResApi resApi;
	
	@Autowired
	private SysUserRepository sysUserRepository;

	@Override
	@HystrixCommand(fallbackMethod="getUserError")
	public JpaSysUser getUser(@PathVariable("username") String username) {
		JpaSysUser user = sysUserRepository.findByUsername(username);
		
		resApi.listMenu(username);
		
		return user;
	}
	
	public JpaSysUser getUserError(@PathVariable("username") String username){
		
		JpaSysUser user = new JpaSysUser();
		
		user.setCreatedDate(LocalDateTime.now());
		user.setLastModifiedDate(LocalDateTime.now());
		
		return user;
	}
}
