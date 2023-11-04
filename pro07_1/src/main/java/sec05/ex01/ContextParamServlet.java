package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextParamServlet
 */
@WebServlet("/initParam")
public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		ServletContext context = getServletContext();
		String menuMember = context.getInitParameter("menu_member");
		//Returns a String containing the value of the namedcontext-wide initialization parameter, or null ifthe parameter does not exist
		//같은 컨텍스트의 web.xml에 param name과 value로 지정한 키,값을 바인딩해서 데려오는 메서드.
		
		System.out.println(menuMember);
	}

}
