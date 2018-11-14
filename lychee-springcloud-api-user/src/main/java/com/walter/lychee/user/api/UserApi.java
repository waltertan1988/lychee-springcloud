package com.walter.lychee.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.walter.lychee.entity.JpaSysUser;

@FeignClient("user")
@RequestMapping("/api/user")
public interface UserApi {

	@GetMapping("/get/{username}")
	public JpaSysUser getUser(@PathVariable("username") String username);
}
