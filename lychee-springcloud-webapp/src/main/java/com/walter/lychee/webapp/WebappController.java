package com.walter.lychee.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebappController {
	
	@GetMapping("/index")
	@ResponseBody
	public String index() {
		return "Hello World!";
	}
}
