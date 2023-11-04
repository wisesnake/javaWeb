package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

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
		System.err.println("두겟 1");
		
		
		HttpSession session =  request.getSession();
		session.setAttribute("menu", "닭강정");
		System.out.println("세션 저장.");
		System.err.println("두겟 2");
		out.print("<a href=\"session1.jsp\">첫번째 페이지로 이동.</a>");
	
	}


}
