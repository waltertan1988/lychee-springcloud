package com.walter.lychee.user.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.walter.lychee.entity.JpaSysUser;
import com.walter.lychee.repository.SysUserRepository;
import com.walter.lychee.user.api.UserApi;

@RestController
public class UserApiImpl extends BaseUserApiImpl implements UserApi {
	
	@Autowired
	private SysUserRepository sysUserRepository;

	@Override
	public JpaSysUser getUser(@PathVariable("username") String username) {
		JpaSysUser user = sysUserRepository.findByUsername(username);
		return user;
	}
}
