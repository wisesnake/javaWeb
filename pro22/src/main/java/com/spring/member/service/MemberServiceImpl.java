package com.spring.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		System.out.println("serviceimpl-setter dao주입");
		this.memberDAO = memberDAO;
	}

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		System.out.println("다오한테 셀렉얼멤버스 쿼리 보내도록 요청");
		membersList = memberDAO.selectAllMembers();
		return membersList;
	}
	
	@Override
	public void addMember(MemberVO memberVO) throws DataAccessException{
		int result = memberDAO.addMember(memberVO);
		System.out.println("이숫자는 무엇일꼬" + result);
	}
	

}
