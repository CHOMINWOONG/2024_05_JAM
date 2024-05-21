package com.koreaIT.BAM.Controller;

import java.util.ArrayList;


import java.util.List;
import java.util.Scanner;

import com.koreaIT.dto.Member;
import com.koreaIT.util.Util;

public class MemberController extends Controller {
	
	private List<Member> members = new ArrayList<>();
	
	
	public MemberController(Scanner sc) {
		
		this.sc = sc;
		this.members = new ArrayList<>();
		this.lastId = 1;
	}
	
	@Override
	public void doAction(String cmd, String methodName) {
		this.cmd = cmd; 
		
		switch(methodName) {
		case "join":
			doJoin();
			break;
		case "login":
			doLogin();
			break;
		default:
			System.out.println("존재하지 않는 명령어 입니다");
		}
	}
	
	public void doJoin() {
		String loginId = null;
		String loginPw = null;
		String loginPwChk = null;
		String name = null;
		boolean a = false;
		
		while(true) {
			
			System.out.printf("아이디: ");
			loginId = sc.nextLine().trim();
			
			if (loginId.length() == 0) {
				System.out.println("아이디는 필수 입력정보입니다.");
				continue;
			}
			if (loginIdDupChk(loginId) == false) {
				System.out.println("중복된 아이디입니다.");
				continue;
			}
			
			for (Member member : members) {
				if (member.getLoginId().equals(loginId)) {
					System.out.println("[" + loginId + "]는(은) 이미 사용 중인 아이디입니다.");
					a = true;
					break;							
				}
			}
			if (a == true) {
			continue;
			}
			break;
		}
						
		while (true) {
			System.out.printf("비밀번호 : ");
			loginPw = sc.nextLine().trim();
			
			if (loginPw.length() == 0) {
				System.out.println("비밀번호는 필수 입력정보입니다");
				continue;
			}
			
			System.out.printf("비밀번호 확인 : ");
			loginPwChk = sc.nextLine().trim();
			
			if (loginPw.equals(loginPwChk) == false) {
				System.out.println("비밀번호를 다시 입력해주세요");
				continue;
			}
			break;
		}
		
		
		while(true) {
		
		System.out.printf("이름 ");
		name = sc.nextLine().trim();
		if (name.length() == 0) {
			System.out.println("이름은 필수 입력정보입니다.");
			continue;
		}
		break;
		
		}
		
		Member member = new Member(lastId, Util.getDateStr(), loginId, loginPw, name);
		members.add(member);
		
		System.out.println(lastId + "번 회원이 가입되었습니다.");
		lastId++;
		
	}
	public void doLogin() {
		String loginId = null;
		String loginPw = null;
		

			System.out.printf("아이디 : ");
			loginId = sc.nextLine().trim();
			System.out.printf("비밀번호 : ");
			loginPw = sc.nextLine().trim();
			
			Member foundMember = getMemberByLoginId(loginId);
			
			for (Member member : members) {
				if(member.getLoginId().equals(loginId)) {
					foundMember = member;
					break;
				}	
			}
			if (foundMember == null) {
				System.out.println("존재하지 않는 아이디입니다");
				return;
			}
			
			if(foundMember.getLoginPw().equals(loginPw) == false) {
				System.out.println("비밀번호를 확인해주세요");
				return;
			}
			
			this.getMemberByLoginId(loginId);
				
		System.out.println("로그인 성공 !");
				
	}
	
	private boolean loginIdDupChk(String loginId) {		
		Member member = getMemberByLoginId(loginId);		 
			if (member != null) {
				return false;
			}		
		return true;
	}
	
	private Member getMemberByLoginId(String loginId) {
		for (Member member : members) {
			member.getLoginId().equals(loginId);
		}
		return null;
	}

	@Override
	public void makeTestDate() {
		System.out.println("테스트용 회원 데이터를 3개 생성했습니다");

		for (int i = 1; i <= 3; i++) {
			members.add(new Member(lastId++, Util.getDateStr(), "user" + i, "user" + i, "유저" + i));
		}
	}
}
