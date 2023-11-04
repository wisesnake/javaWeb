package com.spring.member.service;

import java.util.ArrayList;
import java.util.List;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService{
	MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public List<MemberVO> selectAllMembers() {
		System.out.println("서비스selectAllMembers실행");
		List<MemberVO> membersList = null;
		membersList = memberDAO.selectAllMemberList();
		
		return membersList;
	}

}
