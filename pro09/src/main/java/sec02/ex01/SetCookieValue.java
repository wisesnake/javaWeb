package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/set")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Cookie c = new Cookie("cookieSample", "저녁머먹징");
		Date d = new Date();
		
		c.setMaxAge(24*60*60);
		response.addCookie(c);
		
		out.println("현재시간 : <br>" +d);
		out.println("<br>문자열을 Cookie에 저장합니다.<br>");
		out.println("<a href='/pro09/get'>get으로가기</>");
	}
	
}
