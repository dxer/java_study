package com.azure.app.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azure.app.entity.User;
import com.azure.app.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 展现用户列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin-user-list", method = RequestMethod.GET)
	public String userList(ModelMap model) {
		List<User> userList = userService.listAllUser();
		model.addAttribute("list", userList);
		return "admin-user-list.ftl";
	}

	/**
	 * 添加用户
	 * 
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addUser(ModelMap model, @RequestBody User user) {
		userService.addUser(user);
		Map<String, String> map = new HashMap<String, String>(1);
		map.put("success", "true"); // 正确返回的obj格式为：{"success":true,"id":"1"}就可以正常执行success回调了
		return map;
	}

	/**
	 * 根据id删除用户
	 * 
	 * @param id
	 * @param out
	 */
	@RequestMapping(value = "/delUser")
	public void delete(@RequestParam String id, PrintWriter out) {
		userService.deleteUserById(Integer.parseInt(id));
		out.write("success");
		out.close();
	}
}
