package com.lhcargo.microservices.services.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller.
 * 
 * @author Lufthansa Industry Solutions
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "index";
	}

}
