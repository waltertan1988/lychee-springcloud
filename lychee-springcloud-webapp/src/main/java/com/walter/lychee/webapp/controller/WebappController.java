package com.walter.lychee.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebappController {
	
	@GetMapping("/index")
	public String index() {
		return "/admin/index";
	}
}
