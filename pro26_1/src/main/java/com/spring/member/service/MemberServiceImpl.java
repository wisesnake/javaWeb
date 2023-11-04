package com.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberVO memberVO;
	@Autowired
	MemberDAO memberDAO;
	
	 public List<MemberVO> listMembers() throws DataAccessException{
		 List<MemberVO> membersList = null; 
		 membersList = memberDAO.selectAllMemberList();
		 return membersList;
	 };

}
