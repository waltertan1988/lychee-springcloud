package com.walter.lychee.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walter.lychee.entity.SysUser;
import com.walter.lychee.repository.SysUserRepository;

@Controller
public class UserController extends BaseAdminController {
	
	@Autowired
	private SysUserRepository userRepository;

	@GetMapping("/getUser")
	@ResponseBody
	public SysUser getUser(@RequestParam String username) {
		SysUser user = userRepository.findByUsername(username);
		return user;
	}
}
