package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	public static SqlSessionFactory sqlMapper = null;
	//DB접속을 위한 공장, 연결이나 DataSource에서 SqlSession을 생성함.

	private static SqlSessionFactory getInstance() {
		
		if (sqlMapper == null) {
			//sqlMapper 유효성(null여부) 검사.
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				//MemberDAO 의 각 메서드 호출 시 src/mybatis/SqlMapConfig.xml 에서
				//설정 정보를 읽은 후 데이터베이스와의 연동 준비.
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				//마이바티스를 이용하는 sqlMapper객체를 가져옴.
				System.out.println("SqlSessionFactory 객체" + sqlMapper);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("sqlsession(DB 접속 후 sql문장 실행하는 객체 만드는 도중 에러남");
			}
		}
		return sqlMapper;

	}

	//마이바티스의 회원 정보 조회하는 메소드
	public List<MemberVO> selectAllMemberList() {
		sqlMapper = getInstance();
		//
		SqlSession session = sqlMapper.openSession();
		//session = 세션객체, member.xml의 sql 문을 호출하는데 사용되는 sqlsession객체임.
		List<MemberVO> memlist = null;
		memlist = session.selectList("mapper.member.selectAllMemberList");
		//매개값 안의 문자열은 모든 회원정보(여러개의 레코드)를 호출하므로,
		//리스트 안에다 초기화해줌.
		return memlist;
	}
	

}
