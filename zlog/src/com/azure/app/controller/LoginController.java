package com.azure.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/**
	 * 登录后台首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/admin-index", method = RequestMethod.GET)
	public String loginGet() {
		return "admin-index.ftl";
	}

	@RequestMapping(value = "/admin-main", method = RequestMethod.GET)
	public String toAdminIndex(ModelMap model) {
		model.addAttribute("message", "hello world");
		return "admin-main.ftl";
	}

}
