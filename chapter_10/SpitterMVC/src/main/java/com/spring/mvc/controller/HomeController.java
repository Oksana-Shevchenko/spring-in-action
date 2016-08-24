package com.spring.mvc.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.service.IUserService;

@Controller
public class HomeController {
	
	public static final int DEFAULT_MESSAGES_PER_PAGE = 25;
	
	@Resource(name = "userService")
	private IUserService userService;
	
	@Inject
	public HomeController(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String showHomePage(Map<String, Object> model) {
		model.put("messages", userService.getRecentMessages(DEFAULT_MESSAGES_PER_PAGE));
		return "home";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/admin")
	public String adminPage() {
		return "admin/admin";
	}

	@RequestMapping(value = "/403error")
	public String redirectToErrorPage() {
		return "403error";
	}

}
