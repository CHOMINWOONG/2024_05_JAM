package com.koreaIT.BAM.Controller;

import java.util.List;
import java.util.Scanner;

import com.koreaIT.BAM.container.container;
import com.koreaIT.BAM.service.MemberService;
import com.koreaIT.dto.Member;

public class MemberController extends Controller {
	private MemberService memberServices;
	private List<Member> members;
	
		
	public MemberController(Scanner sc) {
		
		this.sc = sc;
		this.members = container.members;
		this.memberServices = new MemberService();		
		loginedMember = null;
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
		case "logout":
			doLogout();
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
		
		while(true) {
			
			System.out.printf("아이디: ");
			loginId = sc.nextLine().trim();
			
			if (loginId.length() == 0) {
				System.out.println("아이디는 필수 입력정보입니다.");
				continue;
			}
			if (memberServices.loginIdDupChk(loginId) == false) {
				System.out.println("중복된 아이디입니다.");
				continue;
			}
			
			for (Member member : members) {
				if (member.getLoginId().equals(loginId)) {
					System.out.println("[" + loginId + "]는(은) 이미 사용 중인 아이디입니다.");
					break;							
				}
			
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
		
		memberServices.joinMember(loginId, loginPwChk, name);
		
		System.out.println("[" + loginId + "]번 회원이 가입되었습니다.");
		
	}
	public void doLogin() {						
			
					
			System.out.printf("아이디 : ");
			String loginId = sc.nextLine().trim();
			System.out.printf("비밀번호 : ");
			String loginPw = sc.nextLine().trim();
			
			Member foundMember = getMemberByLoginId(loginId);
			
			if (foundMember == null) {
				System.out.println("존재하지 않는 아이디입니다");
				return;
			}
			
			if(foundMember.getLoginPw().equals(loginPw) == false) {
				System.out.println("비밀번호를 확인해주세요");
				return;
			}
			
			
			loginedMember = foundMember;
				
		System.out.println("로그인 성공 !");
				
	}
	private Member getMemberByLoginId(String loginId) {
		return memberServices.getMemberByLoginId(loginId);
	}

	public void doLogout() {
	
		loginedMember = null;
		System.out.println("로그아웃 !");
	}

	
	
	
	
	
	

	@Override
	public void makeTestDate() {
		System.out.println("테스트용 회원 데이터를 3개 생성했습니다");

		for (int i = 1; i <= 3; i++) {
			memberServices.joinMember("user" + i, "user" + i, "user" + i);
		}
	}
}
