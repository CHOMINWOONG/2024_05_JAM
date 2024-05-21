package com.koreaIT.BAM.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.BAM.container.container;
import com.koreaIT.BAM.service.ArticleService;
import com.koreaIT.dto.Article;
import com.koreaIT.dto.Member;


public class ArticleController extends Controller {
	
	private List<Article> articles;
	private ArticleService articleService;
	
	public ArticleController(Scanner sc) {
		
		this.sc = sc; 
		this.articles = container.articles;
		this.articleService = new ArticleService();
		
		
	}
	
	@Override
	public void doAction(String cmd, String methodName) {
		this.cmd = cmd; 
		
		switch(methodName) {
		case "write":
			doWrite();
			break;
		case "list":
			doList();
			break;
		case "detail":
			doDetail();
			break;
		case "modify":
			doModify();
			break;
		case "delete":
			doDelete();
			break;		
		default :
		System.out.println("존재하지 않는 명령어입니다");
		break;
	}	
}
	
	public void doWrite() {
		
		System.out.printf("제목 : ");
		String title = sc.nextLine().trim();
		System.out.printf("내용 : ");
		String body = sc.nextLine().trim();

		int articleNumber = articleService.writeArticle(1, title, body, 0);
		
		System.out.println(articleNumber + "번 글이 생성되었습니다");
	}	
	public void doList() {
		String searchKeyword = cmd.substring("article list".length()).trim();
		
		List<Article> printArticles = articleService.getPrintArticles(searchKeyword);
			
			if (printArticles.size() == 0) {
				System.out.println("검색결과가 없습니다");
				return;
			}
		
		
		System.out.println("번호	|	제목	|		날짜		|    작성자 |  조회수");

		for (int i = printArticles.size() - 1; i >= 0; i--) {
			Article article = printArticles.get(i);
			
			String writerLoginId = getLoginIdByMemberId(article.getMemberId());
			
		
			System.out.printf("%d	|	%s	|	%s	|	%d   |   %d\n", article.getId(), article.getTitle(),
					article.getRegDate(), writerLoginId, article.getViewCnt());
		}
	}

	public void doDetail() {
		int id = getCmdNum(cmd);
		

		if (id == 0) {
			System.out.println("명령어가 올바르지 않습니다");
			return;
		}

		Article foundArticle = articleService.getArticleById(id);

		if (foundArticle == null) {
			System.out.println(id + "번 게시물이 존재하지 않습니다");
			return;
		}

		
		foundArticle.incrementViews();
		String writerLoginId = getLoginIdByMemberId(foundArticle.getMemberId());
		
		System.out.println("번호 : " + foundArticle.getId());
		System.out.println("날짜 : " + foundArticle.getRegDate());
		System.out.println("작성자 : " + writerLoginId);
		System.out.println("제목 : " + foundArticle.getTitle());
		System.out.println("내용 : " + foundArticle.getText());
		System.out.println("조회수 : " + foundArticle.getViewCnt());

	}
	public void doDelete() {
		
		int id = getCmdNum(cmd);

		if (id == 0) {
			System.out.println("명령어가 올바르지 않습니다");
			return;
		}

		Article foundArticle = articleService.getArticleById(id);

		if (foundArticle == null) {
			System.out.println(id + "번 게시물이 존재하지 않습니다");
			return;
		}
		
		if (foundArticle.getMemberId() != loginedMember.getId()) {
			System.out.println("삭제할 수 있는 권한이 없습니다");
		}

		articles.remove(foundArticle);

		System.out.println(id + "번 게시물이 삭제되었습니다");
	}
	public void doModify() {
		
		int id = getCmdNum(cmd);

		if (id == 0) {
			System.out.println("명령어가 올바르지 않습니다");
			return;
		}

		Article foundArticle = articleService.getArticleById(id);
		
		if (foundArticle == null) {
			System.out.println(id + "번 게시물이 존재하지 않습니다");
			return;
		}
		
		if (foundArticle.getMemberId() != loginedMember.getId()) {
			System.out.println("수정할 수 있는 권한이 없습니다");
			return;
		}

		

		System.out.printf("수정할 제목 : ");
		String title = sc.nextLine().trim();
		System.out.printf("수정할 내용 : ");
		String body = sc.nextLine().trim();

		foundArticle.setTitle(title);
		foundArticle.setText(body);

		System.out.println(id + "번 게시물이 수정되었습니다");
	}
	
	private String getLoginIdByMemberId(int memberId) {
		for (Member member : members) {
			if (memberId == member.getId()) {
				return member.getLoginId();
			}
		}
		return null;
	}
	
	private int getCmdNum(String cmd) {
		String[] cmdBits = cmd.split(" ");
		
		

		try {
			int id = Integer.parseInt(cmdBits[2]);
			return id;
		} catch (NumberFormatException e) {
			return 0;
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}

	}
	
	@Override
	public void makeTestDate() {
		System.out.println("테스트용 게시글 데이터를 5개 생성했습니다");

		for (int i = 1; i <= 5; i++) {
			articleService.writeArticle((int) (Math.random() * 3) + 1, "제목" + i, "내용" + i, i * 10);
			
		}
	}
}
