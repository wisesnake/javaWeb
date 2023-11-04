package com.spring.ex03;

public class MemberDAOImpl implements MemberDAO {

	private MemberDAO memberDAO; // 주입되는 빈을 저장할 다오 타입의 속성

	public void setMemberDAO(MemberDAO memberDAO) { // 설정 파일에서 memberDAO 빈을 생성한 후 setter로 속성 memberDAO에 주입합니다.
		this.memberDAO = memberDAO;
	}

	@Override
	public void listMembers() {
		memberDAO.listMembers(); // 주입된 빈을 이용해 listMembers()메서드를 호출함.
	}
}
