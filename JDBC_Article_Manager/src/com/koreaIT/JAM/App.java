package com.koreaIT.JAM;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.koreaIT.JAM.dto.Article;
import com.koreaIT.JAM.dto.Member;
import com.koreaIT.JAM.util.DBUtil;
import com.koreaIT.JAM.util.SecSql;
import com.koreaIT.controller.MemberController;
import com.koreaIT.controller.ArticleController;

public class App {
//	SecSql sql = new SecSql();
//	sql.append("CREATE TABLE `member`");
//	sql.append("id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT");
//	sql.append(",regDate DATETIME NOT NULL");
//	sql.append(",updateDate DATETIME NOT NULL");
//	sql.append(",loginId VARCHAR(20)");
//	sql.append(",loginPw VARCHAR(100)");
//	sql.append(",`name` VARCHAR(20)");
	private final String URL = "jdbc:mysql://localhost:3306/jdbc_article_manager?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
    private final String USER = "root";
    private final String PASSWORD = "";

	public void run() {

		System.out.println("== 프로그램 시작 ==");

		Scanner sc = new Scanner(System.in);
		
		List<Member> members = new ArrayList<>();
		Connection connection = null;
		int lastArticleId = 1;


		PreparedStatement pstmt = null;

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			ArticleController articleController = new ArticleController(connection, sc);
			MemberController memberController = new MemberController(connection, sc);
			
			while (true) {

				System.out.printf("명령어) ");
				String cmd = sc.nextLine().trim();

				if (cmd.equals("exit")) {
					break;
				} if (cmd.equals("member join")) {
					memberController.doJoin();
				} if (cmd.equals("member login")) {
					memberController.doLogin();
;				} if (cmd.equals("article write")) {
					articleController.doWrite();					
				} else if (cmd.equals("article list")) {
					articleController.showList();
				} else if (cmd.startsWith("article modify ")) {
					articleController.doModify(cmd);
				} else if (cmd.startsWith("article detail ")) {
					articleController.showDetail(cmd);		
				} else if (cmd.startsWith("article delete ")) {
					articleController.doDelete(cmd);
				} 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
		}
		sc.close();

		System.out.println("== 프로그램 끝 ==");
	}
}
