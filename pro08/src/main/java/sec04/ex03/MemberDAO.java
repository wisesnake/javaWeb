package sec04.ex03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//DB에 접근(Access)하여 생성/조회/수정/삭제(CRUD)
public class MemberDAO {

	Connection con;
	PreparedStatement pstmt;
	DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			// jndi에 접근하기 위해 기본 경로를 지정
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			// 톰캣 context.xml에 설정한 resource의 name값인 jdbc/oracle을 이용해
			// 톰캣이 미리 연결한 DataSource를 받아옴
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 조회하는 메서드
	List<MemberVO> listMembers() {
		List<MemberVO> memberList = new ArrayList<>();

		try {
			con = dataFactory.getConnection();
			
			String query = "select * from t_member ";
			System.out.println("prepareStatememt: " + query);
			
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			// Set계열 데이터
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");

				System.out.println(id + pwd + name + email + joinDate);

				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				memberList.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("쿼리관련 예외 발생!");
		}
		return memberList;

	}

}
