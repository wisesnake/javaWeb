package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/login")
public class LoginTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
//		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String user_name = request.getParameter("user_name");
		String user_pw = request.getParameter("user_pw");
		LoginImpl loginUser = new LoginImpl(user_name,user_pw);
		HttpSession session = request.getSession();
		if(session.isNew()) {
			session.setAttribute("loginuser", loginUser);
		}
		//httpsessionbindinglistener는 세션 속성이 바인드 될때마다 자동으로 
		//valuebound메서드를 실행함.
		
		int user_cnt = LoginImpl.tot_user;
		//유저카운트를 올리기 위해 static 으로 선언되어있는 totuser필드를 가져옴.
		
		
		out.println("<html>"
				+ "<script> </script>"
				+ "<body>");
		out.println("이름은 " + loginUser.user_name + "<br>");
		out.println("비밀번호는 " + loginUser.user_pw + "<br>");
		out.println("접속자수는 " + user_cnt + "<br>");
		out.println("</body></html>");
	}

}
