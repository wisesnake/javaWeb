package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
       

	public void init(ServletConfig config) throws ServletException {
		
	}

	public void destroy() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("second");
		//위는 redirect 포워딩
//		response.setContentType("text/html;charset=utf-8");
//		response.addHeader("refresh", "3;url=second");
//		pw.print("퍼스트 서블릿 입니당.");
		//위는 refresh 포워딩
//		PrintWriter pw = response.getWriter();
//		pw.print("<script>"
//				+ "location.href='second'"
//				+ "</script>");
		//위는 location 포워딩
		System.out.println("일단 퍼스트는 거쳐갔고");
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher("second?name=LimSeulBeom");
		request.setAttribute("address", "미금역");
		//웹 브라우저의 최초 요청 request에 address와 미금역을 쌍으로 바인딩함.
		RequestDispatcher dispatcher = request.getRequestDispatcher("second");
		dispatcher.forward(request, response);
		//forward를 통해 dispatcher에 초기화한 이 서블릿의 request와 response를 보냄		
		
		//위는 dispatcher 포워딩
		
	}
}
