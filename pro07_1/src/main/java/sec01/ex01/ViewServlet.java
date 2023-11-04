package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		
		//listMembers()메서드를 실행하여 반환받은, 테이블의 ArrayList배열을
		//다시 List타입 memberList 변수에 저장함.
		
		out.print("<html><body>");
		out.print("<table border = 1> <tr align = 'center' bgcolor= 'lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td>");
	
		List<MemberVO2> memberList = (List<MemberVO2>)request.getAttribute("memberList");
		
		for(int i = 0 ; i < memberList.size() ; i++) {
			MemberVO2 memberVO = memberList.get(i);
			//Returns the element at the specified position in this list.
			//get()는, ArrayList배열로 저장되어있는 한 배열 요소씩, 즉 한 레코드씩
			//빼와서 memberVO 변수에 저장함. 이후에 밑에서 getter로 빼오면
			//결국 한 루프가 돌 때마다 한 레코드의 모든 값이 각 변수에 맞게 뽑히게 되는것.
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			out.print("<tr><td>" + id + "</td>" + "<td>" + pwd + "</td>" + "<td>" + name + "</td>" + "<td>" + email + "</td>" + "<td>" + joinDate + "</td>" + "</tr>");
		}
		out.print("</table></body></html>");
	}
	

}
