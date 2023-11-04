package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
       

	public void init(ServletConfig config) throws ServletException {
		
	}

	public void destroy() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기는 세컨드 오바");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print("세컨드 서블릿 입니당.<br>");
		
//		String name = request.getParameter("name");
//		System.out.println("첫번째 서블릿에서 받아온 name파라미터값 :"+ name);
//		pw.print("name : " + name);
		String address = (String)request.getAttribute("address");
		pw.print(address);
	}
}
