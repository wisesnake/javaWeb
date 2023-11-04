package com.spring.ex03;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void listMembers() {
		System.out.println("listMembers 메서드 호출");
		System.out.println("회원정보를 조회합니다.");
	}

}
