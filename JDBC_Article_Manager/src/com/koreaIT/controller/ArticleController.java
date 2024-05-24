package com.koreaIT.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.koreaIT.JAM.dto.Article;
import com.koreaIT.JAM.util.DBUtil;
import com.koreaIT.JAM.util.SecSql;
import com.koreaIT.dao.ArticleDao;
import com.koreaIT.service.ArticleService;

public class ArticleController {
	
		Scanner sc;
		Connection connection;
		private ArticleService articleService;
		List<Article> articles = new ArrayList<>();
		
		public ArticleController(Connection connection, Scanner sc) {
			this.articleService = new ArticleService(connection);
			this.connection = connection;
			this.sc = sc;
		}
		
		public void doWrite() {
			System.out.println("== 게시물 작성 ==");

			System.out.printf("제목 : ");
			String title = sc.nextLine();
			System.out.printf("내용 : ");
			String body = sc.nextLine();

	        int id = articleService.doWrite(title, body);
	        
			System.out.printf("%d번 게시물이 작성되었습니다\n", id);
		}
		public void showList() {
			System.out.println("== 게시물 목록 ==");
			
			List<Article> articles = articleService.showList();
			if (articles.size() == 0) {
				System.out.println("게시물이 존재하지 않습니다");
				return;
			}
			
			System.out.println("=== 게시물 목록 ===");
			System.out.println("번호|	제목  |         작성일        ");
			
			for (Article article : articles) {
				System.out.printf("%d   |   %s   |   %s   \n", article.id, article.title, article.regDate);
			}
		}
		
		public void doModify(String cmd) {
			System.out.println("== 게시물 수정 ==");
			
			int id = Integer.parseInt(cmd.split(" ")[2]);
			
			SecSql sql = new SecSql();
			sql.append("SELECT COUNT(*)");
			sql.append("FROM article");
			sql.append("WHERE id = ?", id);
			
			
			
			System.out.printf("수정할 제목 : ");
			String title = sc.nextLine();
			System.out.printf("수정할 내용 : ");
			String body = sc.nextLine();
			
			
			
			

	        System.out.printf("%d번 게시물이 수정되었습니다\n", id);
		}
		public void showDetail(String cmd) {
			System.out.println("== 게시물 상세 정보 ==");
			
			int id = Integer.parseInt(cmd.split(" ")[2]);
			
	    	if (id == -1) {
	    		System.out.println("게시물이 존재하지않습니다");
	    		
	    		return;
	    	}
	    	
	    	Article article = articleService.showDetail(id);
	    	
	    	System.out.printf("== %d번 게시물 상세보기 ==\n", id);
	    	
	    	System.out.printf("번호 : %d\n", article.id);
	    	System.out.printf("작성일 : %s\n", article.regDate);
	    	System.out.printf("수정일 : %s\n", article.updateDate);
	    	System.out.printf("제목 : %s\n", article.title);
	    	System.out.printf("내용 : %s\n", article.body);
		}
		public void doDelete(String cmd) {
			int id = Integer.parseInt(cmd.split(" ")[2]);
			
			if (id == 0) {
				System.out.println("게시물이 존재하지않습니다.");
			}
	    	
			articleService.doDelete(id);
	    	
	    	
	    	System.out.printf("%d번 게시물이 삭제되었습니다\n", id);
		}
		
}
