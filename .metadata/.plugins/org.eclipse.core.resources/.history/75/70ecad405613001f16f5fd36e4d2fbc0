package com.koreaIT.BAM.dao;

import java.util.List;

import com.koreaIT.BAM.container.container;
import com.koreaIT.dto.Article;
import com.koreaIT.util.Util;

public class ArticleDao {
	
	private List<Article> articles;
	private int lastId;
	
	public ArticleDao() {
		this.lastId = 1;
		this.articles = container.articles;
	}
	
	public int wrtieArticle(int memberId, String title, String body, int viewCnt) {
		articles.add(new Article(lastId, Util.getDateStr(), memberId, title, body, viewCnt));
		return lastId++;
	}
}
