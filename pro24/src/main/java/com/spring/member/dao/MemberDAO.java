package com.spring.member.dao;

import java.util.List;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {

	public List<MemberVO> selectAllMemberList();

}
