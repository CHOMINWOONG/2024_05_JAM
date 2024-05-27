package com.koreaIT.service;

import java.sql.Connection;
import java.util.Map;

import com.koreaIT.JAM.dto.Member;
import com.koreaIT.dao.Memberdao;

public class MemberService {
	
	private Memberdao memberDao;
	
	public MemberService(Connection connection) {
		this.memberDao = new Memberdao(connection);
	}
	
	public boolean isLoginIdDup(String loginId) {
		return memberDao.isLoginIdDup(loginId);
	}
	
	public void doJoin(String loginId, String loginPw, String name) {
		 memberDao.doJoin(loginId, loginPw, name);
	}
	
	public Member getMemberBuLoginId(String loginId) {		
		Map<String, Object> memberMap = memberDao.getMemberBuLoginId(loginId);
		
		if (memberMap.isEmpty()) {
			return null;
		}
		return new Member(memberMap);
	}
}
