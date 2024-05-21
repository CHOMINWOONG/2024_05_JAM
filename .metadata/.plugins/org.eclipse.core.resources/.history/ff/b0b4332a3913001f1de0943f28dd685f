package com.koreaIT.BAM.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.koreaIT.dto.Member;
public abstract class Controller {
	
	public Scanner sc;
	public int lastId;
	public String cmd;
	public static Member loginedMember;
	public List<Member> members = new ArrayList<>();
	
	public abstract void doAction(String cmd, String methodName);
	public abstract void makeTestDate();
	
	public static boolean isLogined() {		
			return loginedMember != null;
}
}
