package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login2")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletContext context = null;
	List user_list = new ArrayList();
	//로그인한 모든 유저의 ID를 저장하는 리스트.

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_name");
		String user_pw = request.getParameter("user_pw");
		HttpSession session = request.getSession(); // 세션객체 생성
		//세션리스너에서 sessionCreated 메서드를 호출하는건 이 시점임.
		context = getServletContext(); // 컨텍스트 등록.
		LoginImpl2 loginUser = new LoginImpl2(user_id,user_pw);
		//LoginImpl2 객체 생성 후, html에서 전송된 Id와 비번을 객체에 저장.
		
		System.out.println("hi");
		if(session.isNew()) {
			session.setAttribute("loginuser", loginUser);
			user_list.add(user_id);
			//세션이 새로이 생성됐을 때, 아이디를 총 접속자 아이디 리스트에 저장함.
			context.setAttribute("user_list", user_list);
			//컨텍스트 속성 범위를 지닌 속성에 유저리스트를 바인딩함.
			//이래야 로그인, 로그아웃 서블릿과 해당 속성을 공유하는게 가능.
			//ex)logout서블릿의 List user_list = (ArrayList) context.getAttribute("user_list");
			//속성값 얻어와서 접속유저리스트를 삭제,재바인딩하여 갱신하여 서블릿끼리 공유가능.
		}
		
		int user_cnt = LoginImpl2.tot_user;
		//유저카운트를 올리기 위해 static 으로 선언되어있는 totuser필드를 가져옴.
		
		
		out.println("<html>"
				+ "<script> </script>"
				+ "<body>");
		out.println("이름은 " + loginUser.user_name + "<br>");
		out.println("비밀번호는 " + loginUser.user_pw + "<br>");
		out.println("접속자수는 " + user_cnt + "<br>");
		out.println("접속자 명단<br>");
		List currUserList = (ArrayList) context.getAttribute("user_list");
		//login, logout서블릿과 공유하는, 컨텍스트속성인 user_list list를 arraylist로 가져옴
		for(int i = 0 ; i < currUserList.size();i++) {
			out.println(currUserList.get(i)+"<br>");
		}
		out.println("<a href = 'logout?user_id="+user_id+"'>로그아웃</a>");
		out.println("</body></html>");
	}

}
