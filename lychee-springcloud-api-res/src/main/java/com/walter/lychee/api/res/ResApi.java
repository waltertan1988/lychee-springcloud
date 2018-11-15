package com.walter.lychee.api.res;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.walter.lychee.entity.JpaSysMenu;

@FeignClient("res")
@RequestMapping("/api/res")
public interface ResApi {

	@GetMapping("/menu/{username}")
	public List<JpaSysMenu> listMenu(@PathVariable("username") String username);
}
