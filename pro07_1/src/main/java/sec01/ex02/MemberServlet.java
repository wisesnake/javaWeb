package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러 역할. 컨트롤러 역할을 하게 하기 위해 MemberServlet 안에
//연결 객체(MemberDAO)가 필요함.
@WebServlet("/member2")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() {
		System.out.println("ㅎㅇ");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO2 dao = new MemberDAO2();
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		//addmember 용 데이터임을 알려주는 commander 매개값 가져오기
		if (command != null && command.equals("addMember")) {
			String _id = request.getParameter("id");
			String _pwd = request.getParameter("pwd");
			String _name = request.getParameter("name");
			String _email = request.getParameter("email");

			MemberVO2 vo = new MemberVO2();
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
			dao.addMember(vo);
			//vo에 회원가입 데이터 담아서 DAO의 addMember 메서드 실행하여 회원가입.
		} else if (command != null && command.equals("delMember")) {
			String id = request.getParameter("id");
			//회원삭제.
			dao.delMember(id);
		}
		List list = dao.listMembers();
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td >삭제</td></tr>");

		for (int i = 0; i < list.size(); i++) {
			MemberVO2 memberVO = (MemberVO2) list.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>"
					+ joinDate + "</td><td>" + "<a href='/pro07_1/member2?command=delMember&id=" + id
					+ "'>삭제 </a></td></tr>");

		}
		out.print("</table></body></html>");
		out.print("<a href='/pro07_1/memberForm.html'>새 회원 등록하기</a");
	}

}
