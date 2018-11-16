package com.walter.lychee.res.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.walter.lychee.entity.JpaSysMenu;

@FeignClient("res")
public interface ResApi {

	@GetMapping("/api/res/listMenu/{username}")
	public List<JpaSysMenu> listMenu(@PathVariable("username") String username);
}
