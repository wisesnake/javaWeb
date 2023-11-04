package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.print("세션아이디 : " + session.getId() + "<br>");
		out.print("최초 세션 생성 시각 : " + new Date(session.getCreationTime()) + "<br>");
		out.print("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime()) + "<br>");
		out.print("세션 유효 시각 : " + (session.getMaxInactiveInterval()/60) + "분" + "<br>");
		if(session.isNew()) {
			out.print("새 새션 생성!");
		}		
		
	
	}

}
