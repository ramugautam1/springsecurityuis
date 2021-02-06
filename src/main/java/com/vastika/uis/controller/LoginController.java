package com.vastika.uis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		return "login";
	}
	
	@RequestMapping(value = "/accessdenied")
	public String accessDenied(ModelMap model) {
		model.addAttribute("error", "true");
		return "accessDenied";
	}
	
}