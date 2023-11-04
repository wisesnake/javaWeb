package com.spring.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

public class AccountDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("세션주입");
		this.sqlSession = sqlSession;
	}

	public void updateBalance1() throws DataAccessException{
		System.out.println("업데이트1 sql");
		sqlSession.update("mapper.account.updateBalance1");
	}
	
	public void updateBalance2() throws DataAccessException{
		System.out.println("업데이트2 sql");
		sqlSession.update("mapper.account.updateBalance2");
	}
	
}
