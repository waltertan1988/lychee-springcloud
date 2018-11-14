package com.walter.lychee.user.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.walter.lychee.entity.JpaSysUser;
import com.walter.lychee.repository.SysUserRepository;

@RestController
public class UserProvider extends BaseUserProvider {
	@Autowired
	private SysUserRepository sysUserRepository;

	@GetMapping("/get/{username}")
	public JpaSysUser getUser(@PathVariable("username") String username) {
		JpaSysUser user = sysUserRepository.findByUsername(username);
		return user;
	}
}
