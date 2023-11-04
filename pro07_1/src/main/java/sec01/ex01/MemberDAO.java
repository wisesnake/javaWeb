package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//DB에 접근(Access)하여 생성/조회/수정/삭제(CRUD)
public class MemberDAO {
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String user = "scott";
	private static final String pwd = "12341234";

	Connection conn;
	//커넥션클래스 설명 적기
	Statement stmt;
	//스테이트먼트클래스 설명 적기
	
	// 조회하는 메서드
	List<MemberVO2> listMembers() {
		// 리턴값이 list<MemberVO>인 메서드, 그러나 결과적으로 리턴할 때 바로 밑에 선언한
		// memberlist를 반환할 것이기 때문에, ArrayList배열 형태로 뽑은 데이터를 리턴하게 될 것임.
		List<MemberVO2> memberList = new ArrayList<>();
//		한 레코드당 하나씩 배열의 형태로 저장하기 위한 어레이리스트 제너릭 타입
//		리스트 객체인 memberList 객체 생성.

		connDB();
		String query = "select * from t_member";
		System.out.println("실행하고자하는 쿼리 : " + query);

		try {
			ResultSet rs = stmt.executeQuery(query);
			// Resultset 은 excuteQuery(String sql문) 매서드를 통해 쿼리를 실행하면
			// ResultSet타입으로 반환해주어 결과값을 저장할 수 있음.
			// 여기서 ResultSet타입은 저장된 값을 한 레코드 단위로 불러올 수 있음.

			// Set계열 데이터
			while (rs.next()) {
				// ResultSet.next() 메서드 : Moves the cursor forward one row from its current
				// position
				// 즉 한 행씩(ResultSet타입 변수에 저장된 테이블 데이터의 한 레코드씩) 커서를 이동시킴.
				String id = rs.getString("id");
				// ResultSet.getString
				// Retrieves the value of the designated column in the current rowof this
				// ResultSet object as a String in the Java programming language.
				// 즉, 현재 커서가 가르키고 있는 레코드에서, 매개값과 일치하는 문자열을 지닌 필드의 값을 뽑아 반환받음.
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");

				System.out.println(id + pwd + name + email + joinDate);

				MemberVO2 vo = new MemberVO2();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				memberList.add(vo);
				// 한 루프당 한 레코드의 모든 필드값을 저장한 vo객체를 위에서 만든 Arraylist배열의
				// 한 요소에 저장하여 결과적으로 루프가 끝나면 해당 테이블의 모든 데이터를 빼와서
				// memberList객체에 Arraylist컬렉션의 형태로 저장함.
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("쿼리관련 예외 발생!");
		}
		return memberList;
		// 위의 루프에서 완성시킨 테이블을 ArrayList배열의 형태로 리턴시킴.

	}

	// DB에 연결하는 메서드
	void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			// Driver : the basic service for managing a set of JDBC drivers.
			conn = DriverManager.getConnection(url, user, pwd);

			stmt = conn.createStatement();
			// Creates a Statement object for sendingSQL statements to the database
			// ㄴ쉽게말해 DB 에 SQL을 보내기 위한 객체를 만듦.

		} catch (Exception e) {
			System.out.println("오라클드라이버 에러!");
		}

	}
}
