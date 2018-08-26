package com.walter.lychee.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.walter.lychee.entity.User;
import com.walter.lychee.repository.UserRepository;

@Controller
public class UserController extends BaseAdminController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/getUser")
	@ResponseBody
	public User getUser(@RequestParam(defaultValue="walter") String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}
}
