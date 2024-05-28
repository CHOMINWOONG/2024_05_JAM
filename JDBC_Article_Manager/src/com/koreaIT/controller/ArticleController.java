package com.koreaIT.controller;

import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import com.koreaIT.JAM.dto.Article;
import com.koreaIT.JAM.session.Session;
import com.koreaIT.JAM.util.Util;
import com.koreaIT.service.ArticleService;
import com.koreaIT.service.MemberService;

public class ArticleController {
	
		Scanner sc;
		Connection connection;
		private ArticleService articleService;
		List<Article> articles = new ArrayList<>();
		MemberService memberService;
		
		public ArticleController(Connection connection, Scanner sc) {
			this.articleService = new ArticleService(connection);
			this.connection = connection;
			this.sc = sc;
			this.memberService = new MemberService(connection);
		}
		
		public void doWrite() {
			
			if (Session.isLogined() == false) {
				System.out.println("로그인 후 이용해주세요");
				return;
			}
			
			System.out.println("== 게시물 작성 ==");

			System.out.printf("제목 : ");
			String title = sc.nextLine();
			System.out.printf("내용 : ");
			String body = sc.nextLine();

	        int id = articleService.doWrite(Session.getLoginedMemberId(), title, body);
	        
			System.out.printf("%d번 게시물이 작성되었습니다\n", id);
		}
		public void showList(String cmd) {
			String searchKeyword = cmd.substring("article list".length()).trim();
			
			
			
			List<Article> articles = articleService.showList(searchKeyword);
			
			System.out.println("== 게시물 목록 ==");
			
			
			
			if (searchKeyword.length() > 0) {
				
				System.out.println("검색어 : " + searchKeyword);
				
				if (articles.size() == 0) {
					System.out.println("검색결과가 존재하지 않습니다");
					return;
				}
			} 
			if (articles.size() == 0) {
				System.out.println("존재하지 않는 게시물입니다");
				return;
			}
			
			System.out.println("=== 게시물 목록 ===");
			System.out.println("번호	|	제목	|	작성자	|		작성일		 |	  조회수     |");
			
			for (Article article : articles) {
				System.out.printf("%d	|	%s	|	%s	|	%s	 |           "
						+ "%s      |\n", article.id, article.title, article.writerName, Util.datetimeFormat(article.regDate), article.vCnt);
			}
		}
		public void showDetail(String cmd) {
			
			if (Session.isLogined() == false) {
				System.out.println("로그인 후 이용해주세요");
				return;
			}
			
			int id = articleService.getCmdNum(cmd);
			
			if (id == -1) {
				System.out.println("게시물 번호를 잘못 입력하셨습니다");
				return;
			}
			
			int affectedRow = articleService.increaseVCnt(id);
			
			if (affectedRow == 0) {
				System.out.printf("%번 게시물이 존재하지않습니다\n", id);
				return;
			}
			
			
	    	Article article = articleService.showDetail(id);
	    	
	    	System.out.printf("== %d번 게시물 상세보기 ==\n", id);
	    	
	    	System.out.printf("번호 : %d\n", article.id);
	    	System.out.printf("작성일 : %s\n", Util.datetimeFormat(article.regDate));
	    	System.out.printf("수정일 : %s\n", Util.datetimeFormat(article.updateDate));
	    	System.out.printf("조회수 : %s\n", article.vCnt);
	    	System.out.printf("작성자 : %s\n", article.writerName);
	    	System.out.printf("제목 : %s\n", article.title);
	    	System.out.printf("내용 : %s\n", article.body);
		}
		
		public void doModify(String cmd) {
			
			if (Session.isLogined() == false) {
				System.out.println("로그인 후 이용해주세요");
				return;
			}
			
			int id = articleService.getCmdNum(cmd);
			
			if (id == -1) {
				System.out.println("게시물 번호를 잘못 입력하셨습니다");
				return;
			}
			
			Article article = articleService.getArticleById(id);
			
			if (article == null) {
				System.out.printf("%번 게시물은 존재하지 않습니다\n", id);
			}
			if (article.memberId != Session.getLoginedMemberId()) {
				System.out.println("해당 게시물에 대한 권한이 없습니다");
				return;
			}
			System.out.println("== 게시물 수정 ==");
		
			System.out.printf("수정할 제목 : ");
			String title = sc.nextLine().trim();
			System.out.printf("수정할 내용 : ");
			String body = sc.nextLine().trim();
			
			
			articleService.doModify(id, title, body);
			

	        System.out.printf("%d번 게시물이 수정되었습니다\n", id);
		}
		
		public void doDelete(String cmd) {
			
			if (Session.isLogined() == false) {
				System.out.println("로그인 후 이용해주세요");
				return;
			}
			
			int id = articleService.getCmdNum(cmd);
			
			Article article = articleService.getArticleById(id);
			
			if (article == null) {
				System.out.println("게시물이 존재하지않습니다.");
				return;
			}
			
			if (article.memberId != Session.getLoginedMemberId()) {
				System.out.println("해당 게시물에 대한 권한이 없습니다");
				return;
			}
	    	
			articleService.doDelete(id);
	    	
	    	
	    	System.out.printf("%d번 게시물이 삭제되었습니다\n", id);
		}
		
}
