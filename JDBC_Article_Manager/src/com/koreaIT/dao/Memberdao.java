package com.koreaIT.dao;

import java.sql.Connection;
import java.util.Map;
import java.util.Scanner;

import com.koreaIT.JAM.util.DBUtil;
import com.koreaIT.JAM.util.SecSql;

public class Memberdao {
	
	Connection connection;
	
	public Memberdao(Connection connection) {
		this.connection = connection;
	}
	
	
	public void doJoin(String loginId, String loginPw, String name) {
		SecSql sql = new SecSql();
    	sql.append("INSERT INTO `member`");
    	sql.append("SET regDate = NOW()");
    	sql.append(", updateDate = NOW()");
    	sql.append(", loginId = ?", loginId);
    	sql.append(", loginPw = ?", loginPw);
    	sql.append(", `name` = ?", name);

    	DBUtil.insert(connection, sql);
	}
	
	public boolean isLoginIdDup(String loginId) {
		SecSql sql = new SecSql();
		
		sql.append("SELECT COUNT(id) > 0");
		sql.append("FROM `member`");
		sql.append("WHERE loginId = ?", loginId);

		return DBUtil.selectRowBooleanValue(connection, sql);
	}
	
	public Map<String, Object> getMemberBuLoginId(String loginId){
		SecSql sql = new SecSql();
		
		sql.append("SELECT *");
		sql.append("FROM `member`");
		sql.append("WHERE loginId = ?", loginId);
		
		return DBUtil.selectRow(connection, sql);
		
	}
	
	
}
