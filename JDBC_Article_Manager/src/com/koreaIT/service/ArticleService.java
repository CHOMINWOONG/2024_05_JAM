package com.koreaIT.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.koreaIT.JAM.dto.Article;
import com.koreaIT.dao.ArticleDao;

public class ArticleService {
	
	private ArticleDao articleDao;
	
	public ArticleService(Connection connection) {
		this.articleDao = new ArticleDao(connection);
	}
	
	public int doWrite(String title, String body) {
		return articleDao.doWrite(title, body);
	}
	
	public List<Article> showList() {
		List<Map<String, Object>> articleListMap = articleDao.showList();
		
		List<Article> articles = new ArrayList<>();
		
		for (Map<String, Object> articleMap : articleListMap) {
			articles.add(new Article(articleMap));
		}
		return articles;
	}
	
	public Article showDetail(int id) {
		Map<String, Object> articleMap = articleDao.showDetail(id);
		
		if (articleMap.isEmpty()) {
			return null;
		}
		
		return new Article(articleMap);
	}
	
	public void doDelete(int id) {
		articleDao.doDelete(id);
	}
	
	public void doModify(int id, String title, String body) {
		articleDao.doModify(id, title, body);
	}
	
}
