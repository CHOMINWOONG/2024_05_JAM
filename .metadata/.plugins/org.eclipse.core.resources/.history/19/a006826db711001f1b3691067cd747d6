package com.koreaIT.dto;

public class Article {
	private int id;
	private String regDate;
	private String title;
	private String text;
	private int viewCnt;
	
	

public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	//	생성자를 만들어줘서 Main 클래스 안 지역변수에 코드를 최적화 시킬 수 있다.
	public Article(int id, String regDate, String title, String text, int viewCnt) {
		this.id = id;
		this.regDate = regDate;
		this.title = title;
		this.text = text;
		this.viewCnt = viewCnt;
		
				
	}
	
	public void incrementViews() {
		this.viewCnt++;
	}
}