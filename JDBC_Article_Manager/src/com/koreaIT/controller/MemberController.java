package com.koreaIT.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.JAM.dto.Member;
import com.koreaIT.JAM.util.DBUtil;
import com.koreaIT.JAM.util.SecSql;
import com.koreaIT.service.MemberService;

public class MemberController {
	
	MemberService memberService;
	Scanner sc = new Scanner(System.in);
	Connection connection = null;
	
	public MemberController(Connection connection, Scanner sc) {
		this.connection = connection;
		this.sc = sc;
		this.memberService = new MemberService(connection);
	}
	
	public void doJoin() {
		String loginId = null;
		String loginPw = null;
		String loginPwChk = null;
		String name = null;

		System.out.println("== 회원 가입 ==");

		while (true) {
			System.out.printf("아이디 : ");
			loginId = sc.nextLine().trim();

			if (loginId.length() == 0) {
				System.out.println("아이디는 필수 입력 정보입니다");
				continue;
			}
			
			boolean isLoginIdDup = memberService.isLoginIdDup(loginId);

			if (isLoginIdDup) {
				System.out.printf("[ %s ] 은(는) 이미 사용중인 아이디입니다\n", loginId);
				continue;
			}

			System.out.printf("[ %s ] 은(는) 사용가능한 아이디입니다\n", loginId);
			break;
		}

		while (true) {
			System.out.printf("비밀번호 : ");
			loginPw = sc.nextLine().trim();

			if (loginPw.length() == 0) {
				System.out.println("비밀번호는 필수 입력 정보입니다");
				continue;
			}

			System.out.printf("비밀번호 확인 : ");
			loginPwChk = sc.nextLine().trim();

			if (loginPw.equals(loginPwChk) == false) {
				System.out.println("비밀번호가 일치하지 않습니다");
				continue;
			}
			break;
		}

		while (true) {
			System.out.printf("이름 : ");
			name = sc.nextLine().trim();

			if (name.length() == 0) {
				System.out.println("이름은 필수 입력 정보입니다");
				continue;
			}
			break;
		}
		
//    	SecSql sql = new SecSql();
//    	sql.append("INSERT INTO `member`");
//    	sql.append("SET regDate = NOW()");
//    	sql.append(", updateDate = NOW()");
//    	sql.append(", loginId = ?", loginId);
//    	sql.append(", loginPw = ?", loginPw);
//    	sql.append(", `name` = ?", name);
//
//    	DBUtil.insert(connection, sql);
		memberService.doJoin(loginId, loginPwChk, name);

		System.out.printf("[ %s ] 님의 가입을 환영합니다~\n", loginId);
		
	}
	
	public void doLogin() {
		String loginId = null;
		String loginPw = null;
		
		System.out.println("== 로그인 ==");
		
		while (true) {
			System.out.println("아이디 : ");
			loginId = sc.nextLine().trim();
			System.out.println("비밀번호 : ");
			loginPw = sc.nextLine().trim();
			
			if (loginId.length() == 0 ) {
				System.out.println("아이디를 입력해주세요");
				continue;
			}
			if (loginPw.length() == 0 ) {
				System.out.println("비밀번호를 입력해주세요");
				continue;
			}
			
			Member member = memberService.getMemberBuLoginId(loginId);
			
			if (member == null) {
				System.out.println("[ %s ] 은(는) 존재하지않는 아이디입니다");
				continue;
			}
			if (member.loginPw.equals(loginPw) == false) {
				System.out.println("비밀번호가 일치하지 않습니다");
				continue;
			}
			break;
		}
		System.out.printf("[ %s ]님 환영합니다\n", loginId);
	}
}
