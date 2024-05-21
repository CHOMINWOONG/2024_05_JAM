package com.koreaIT.BAM.service;

import java.util.List;

import com.koreaIT.BAM.dao.ArticleDao;
import com.koreaIT.dto.Article;
import com.koreaIT.util.Util;

public class ArticleService {
	
	private ArticleDao articledao;
	
	public ArticleService() {
		this.articledao = new ArticleDao();
	}
	
	public int writeArticle(int memberId, String title, String body, int viewCnt) {
		return articledao.wrtieArticle(memberId, title, body, viewCnt);
		
	}
	
	public List<Article> getPrintArticles(String searchKeyword){
		return articledao.getPrintArticles(searchKeyword);
	}
	
	public Article getArticleById(int id) {
		return articledao.getArticleById(id);
	}
}
