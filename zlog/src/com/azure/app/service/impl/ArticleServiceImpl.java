package com.azure.app.service.impl;

import java.util.List;

import com.azure.app.entity.Article;
import com.azure.app.mapper.ArticleMapper;
import com.azure.app.service.ArticleService;

public class ArticleServiceImpl implements ArticleService {
	private ArticleMapper articleMapper;

	public ArticleMapper getArticleMapper() {
		return articleMapper;
	}

	public void setArticleMapper(ArticleMapper articleMapper) {
		this.articleMapper = articleMapper;
	}

	@Override
	public void addArticle(Article article) {
		articleMapper.addArticle(article);
	}

	@Override
	public void deleteById(String id) {
		articleMapper.deleteById(id);

	}

	@Override
	public List<Article> listAllArticle() {
		return articleMapper.listAllArticle();
	}

	@Override
	public void updateArticle(Article article) {
		articleMapper.updateArticle(article);
	}

	@Override
	public Article getArticleById(String id) {
		return articleMapper.getArticleById(id);
	}
}
