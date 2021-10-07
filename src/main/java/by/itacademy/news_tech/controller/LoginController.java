package by.itacademy.news_tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itacademy.news_tech.entity.User;
import by.itacademy.news_tech.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;

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
	
	@GetMapping("/showFormForAddUser")
	public String showFormForAdd(Model theModel) {

		theModel.addAttribute("user", new User());

		return "user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveNews(@ModelAttribute("user") User theUser) {

		userService.saveOrUpdateUser(theUser);

		return "redirect:login-form";
	}
	
	@GetMapping("/userDelete")
	public String deleteNews(@ModelAttribute("user") User theUser) {

		userService.deleteUser(theUser);

		return "redirect:list";
	}
	
	@RequestMapping("/listUser")
	public String getNewses(Model theModel) {

		List<User> users = userService.getUsers();
		theModel.addAttribute("users", users);

		return "user-list";
	}
}
