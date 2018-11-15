package com.walter.lychee.api.res;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.walter.lychee.entity.JpaSysMenu;

@FeignClient("res")
public interface ResApi {

	@GetMapping("/api/res/menu/{username}")
	public List<JpaSysMenu> listMenu(@PathVariable("username") String username);
}
