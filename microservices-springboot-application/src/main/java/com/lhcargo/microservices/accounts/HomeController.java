package com.lhcargo.microservices.accounts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home page controller.
 * 
 * @author Lufthansa Industry Solutions
 */
@Controller
public class HomeController {
	@Autowired
	public AccountRepository accountRepository;

	@RequestMapping("/")
	public String home(Model model) {
		List<Account> accounts = accountRepository.findAll();
		model.addAttribute("accounts", accounts);
		return "index";
	}

}
