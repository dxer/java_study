package com.azure.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.azure.app.entity.Article;
import com.azure.app.entity.User;
import com.azure.app.service.ArticleService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@RequestMapping(value = "/admin-article-list", method = RequestMethod.GET)
	public String listArticle(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		List<User> list = new ArrayList<User>();
		model.addAttribute("list", list);
		return "admin-article-list.ftl";
	}

	@RequestMapping(value = "/admin-article", method = RequestMethod.GET)
	public String toAddArticle() {
		return "admin-article.ftl";
	}

	@RequestMapping(value = "/addArticle", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addArticle(ModelMap model,
			@RequestBody Article article) {
		String id = UUID.randomUUID().toString();
		article.setId(id);
		articleService.addArticle(article);
		Map<String, String> map = new HashMap<String, String>(1);
		map.put("success", "true"); // 正确返回的obj格式为：{"success":true,"id":"1"}就可以正常执行success回调了
		return map;
	}

	@RequestMapping(value = "/admin-draft-list", method = RequestMethod.GET)
	public String listDraft(ModelMap model) {
		return "admin-draft-list.ftl";
	}

}
