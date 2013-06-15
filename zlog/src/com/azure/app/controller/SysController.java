package com.azure.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SysController {

	@RequestMapping(value = "/admin-preference", method = RequestMethod.GET)
	public String to() {
		return "admin-preference.ftl";
	}
}
