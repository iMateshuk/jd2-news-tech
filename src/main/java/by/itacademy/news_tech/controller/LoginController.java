package by.itacademy.news_tech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@GetMapping("/showLoginPage")
	public String showLoginPage() {

		return "login-form";
	}

	@GetMapping("/access-denied")
	public String showAccessDenied() {

		return "access-denied";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login-form";
	}	
}
