package com.koreaIT.BAM;

import java.util.Scanner;

import com.koreaIT.BAM.Controller.*;

public class App {


	public App() {

		
	}

	public void run() {
		System.out.println("== 프로그램 시작 ==");

		
		Scanner sc = new Scanner(System.in);

		MemberController memberController = new MemberController(sc);
		ArticleController articleController = new ArticleController(sc);
		
		memberController.makeTestDate();
		articleController.makeTestDate();
		
		while (true) {
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}

			else if (cmd.length() == 0) {
				System.out.println("명령어를 입력해주세요");
				continue;
			}
			
			String[] cmdBitz = cmd.split(" ");
			
			if (cmdBitz.length < 2) {
				System.out.println("존재하지 않는 명령어입니다");
				continue;
			}
			
			String controllerName = cmdBitz[0];
			String methodName = cmdBitz[1];
			
			switch(methodName) {
			case "write":
			case "modify":
			case "delete":
			case "logout":
				if () {
					System.out.println("로그인을 해주세요");
					continue;
				}
				break;
			case "join":
			case "login":
				if () {
					System.out.println("로그아웃을 해주세요");
					continue;
				}
				break;
			}
			
			if(controllerName.equals("article")) {
				articleController.doAction(cmd, methodName);
			} else if(controllerName.equals("member")) {
				memberController.doAction(cmd, methodName);
			}
			
			
			
			

//			if (cmd.equals("member join")) {
//				memberController.doJoin();				
//			} else if (cmd.equals("article write")) {
//				articleController.doWrite();				
//			} else if (cmd.startsWith("article list")) {
//				articleController.doList(cmd);
//			} else if (cmd.startsWith("article detail ")) {
//				articleController.doDetail(cmd);				
//			} else if (cmd.startsWith("article modify ")) {
//				articleController.doModify(cmd);
//			} else if (cmd.startsWith("article delete ")) {
//				articleController.doDelete(cmd);
//			} 
//			else {
//				System.out.println("존재하지 않는 명령어 입니다");
//			}

		}

		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}
}