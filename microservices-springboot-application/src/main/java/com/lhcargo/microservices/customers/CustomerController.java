package com.lhcargo.microservices.customers;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/")
	public String home(Model model) {
		List<Customers> customers = customerService.findAllCustomers();
		model.addAttribute("customers", customers);
		return "index";
	}

	@RequestMapping(value = "/customer/details")
	public String getCustomerDetails(@QueryParam("id") int id, Model model) {
		Customers customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		return "custdetails";
	}

}
