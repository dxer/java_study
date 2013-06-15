package com.azure.app.service;

import java.util.List;

import com.azure.app.entity.Article;

public interface ArticleService {

	/**
	 * 添加文章
	 * 
	 * @param article
	 */
	public void addArticle(Article article);
	
	/**
	 * 获得指定文章的详细信息
	 * 
	 * @param id
	 * @return
	 */
	public Article getArticleById(String id);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	public void deleteById(String id);

	/**
	 * 获得文章信息列表
	 * 
	 * @return
	 */
	public List<Article> listAllArticle();

	/**
	 * 更新文章
	 * 
	 * @param article
	 */
	public void updateArticle(Article article);
}
