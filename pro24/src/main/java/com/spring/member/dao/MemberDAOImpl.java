package com.spring.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.member.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
@Override
public List<MemberVO> selectAllMemberList() {
	List<MemberVO> membersList = null;
	membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
	System.out.println("DAO sql 실행");
	return membersList;
}
}
