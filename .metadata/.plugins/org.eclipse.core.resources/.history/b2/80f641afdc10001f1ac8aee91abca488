package com.koreaIT.BAM;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.dto.Article;
import com.koreaIT.dto.Member;
import com.koreaIT.util.Util;

import ArticleController.ArticleController;
import MemberController.MemberController;

public class App {
	
	
	
	
	public App() {
		
	}


	public void run() {



		System.out.println("== 프로그램 시작 ==");						
//		데이터타입을 받을 함수 Scanner
		Scanner sc = new Scanner(System.in);
		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		
		memberController.makeTestMemberData();
		articleController.makeTestData();
		
									
		while(true) {
									
			System.out.printf("명령어) ");
//			Trim 공백을 제거해주는 함수
//			nextLine은 값을 입력하게 받을 함수
			String cmd = sc.nextLine().trim();
			
			if (cmd.equals("exit")) {
				break;
			}
			
			if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요.");

//				Continue 만나면 아래 조건을 보지않고 다시 위로 올라간다.
				continue;
			}
			
			if (cmd.equals("member join")) {
				memberController.doJoin();
			} 
			
			else {
					System.out.println("존재하지 않는 명령어 입니다");
				}								
			}			
			sc.close();
			System.out.println("== 프로그램 끝 ==");
	}							
}

