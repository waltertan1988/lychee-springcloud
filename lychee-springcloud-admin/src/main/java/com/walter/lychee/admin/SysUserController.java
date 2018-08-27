package com.walter.lychee.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walter.lychee.entity.JpaSysUser;
import com.walter.lychee.repository.SysUserRepository;

@Controller
public class SysUserController extends BaseAdminController {
	
	@Autowired
	private SysUserRepository sysUserRepository;

	@GetMapping("/getUser")
	@ResponseBody
	public JpaSysUser getUser(@RequestParam String username) {
		JpaSysUser user = sysUserRepository.findByUsername(username);
		return user;
	}
}
