package com.koreaIT.JAM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.koreaIT.JAM.dto.Article;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/jdbc_article_manager?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
	public static void main(String[] args) throws SQLException {
		
		
		Scanner sc = new Scanner(System.in); 
		int lastArticleId = 1;
		
		System.out.println("== 프로그램 시작 ==");
		
		while(true) {
			
			List<Article> articles = new ArrayList<>();
			
			System.out.printf("명령어) ");
			String cmd = sc.nextLine().trim();
			
			if(cmd.equals("exit")) {
				break;
			}
			
			if(cmd.equals("article write")) {

				System.out.printf("제목 :");
				String title = sc.nextLine().trim();
				System.out.printf("내용 :");
				String body = sc.nextLine().trim();
				
				Connection connection = null;
		    	PreparedStatement pstmt = null;
		    	
				try {
		            connection = DriverManager.getConnection(URL, USER, PASSWORD);

		            String sql = "INSERT INTO article";
		            sql += " SET regDate = NOW()";
		            sql += ", updateDate = NOW()";
		            sql += ", title = '" + title + "'";
		            sql += ", `body` = '" + body + "';";
		            
		            pstmt = connection.prepareStatement(sql);
		            pstmt.executeUpdate();

		        } catch (SQLException e) {
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
//				Article article = new Article(lastArticleId, title, body);
				
//				articles.add(article);
								
				System.out.println(lastArticleId + "번 게시물이 작성되었습니다.");
				lastArticleId++;	
				
				continue;
			}
				if(cmd.equals("article list")) {
					
					
					Connection connection = null;
			    	PreparedStatement pstmt = null;
			    	ResultSet rs = null;
					
			    	try {
			            connection = DriverManager.getConnection(URL, USER, PASSWORD);

			            String sql = "SELECT * FROM article";
			            sql += " ORDER BY id DESC";
			            
			            
			            pstmt = connection.prepareStatement(sql);
			            rs = pstmt.executeQuery();
			            
			            while(rs.next()) {
			            	int id = rs.getInt("id");
			            	String regDate = rs.getString("regDate");
			            	String updateDate = rs.getString("updateDate");
			            	String title = rs.getString("title");
			            	String body = rs.getString("body");
			            	
			            	Article article = new Article(id, regDate, updateDate, title, body);
			            	articles.add(article);
			            }

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
					if (articles.size() == 0) {
						System.out.println("게시물이 존재하지 않습니다");
						continue;
					}
					for (Article article : articles) {
						
						System.out.printf("%d	|	%s\n", article.id, article.title);
					}
					
			        
			        
				continue;
			} else if (cmd.startsWith("article modify")) {
				
					int id = Integer.parseInt(cmd.split(" ")[2]);
					
					System.out.printf("수정할 제목 ");
					String title = sc.nextLine().trim();
					System.out.printf("수정할 내용 ");
					String body = sc.nextLine().trim();
					
					Connection connection = null;
			    	PreparedStatement pstmt = null;
			    	
					try {
			            connection = DriverManager.getConnection(URL, USER, PASSWORD);

			            String sql = "UPDATE article";
			            sql += ", updateDate = NOW()";
			            sql += ", title = '" + title + "'";
			            sql += ", `body` = '" + body + "';";
			            sql += "WHERE id = " + id + ";";
			            
			            pstmt = connection.prepareStatement(sql);
			            pstmt.executeUpdate();

			        } catch (SQLException e) {
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
					
					System.out.println(id + "번 게시물이 수정되었습니다");
					
				}
				
				
				
				sc.close();
				System.out.println("== 프로그램 끝 ==");

		}
		
	}
}
