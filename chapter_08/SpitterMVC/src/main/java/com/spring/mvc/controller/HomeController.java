package com.spring.mvc.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
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
}
