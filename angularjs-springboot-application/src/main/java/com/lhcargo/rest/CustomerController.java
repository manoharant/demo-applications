package com.lhcargo.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@RequestMapping("/customermgt")
	public String getIndexPage(){
		return "CustomerManagement";
	}
}
