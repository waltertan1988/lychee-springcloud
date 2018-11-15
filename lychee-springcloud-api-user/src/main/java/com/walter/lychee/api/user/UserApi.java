package com.walter.lychee.api.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.walter.lychee.entity.JpaSysUser;

@FeignClient("user")
public interface UserApi {

	@GetMapping("/api/user/get/{username}")
	public JpaSysUser getUser(@PathVariable("username") String username);
}
