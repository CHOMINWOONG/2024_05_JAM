package com.koreaIT.BAM.service;

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
}
