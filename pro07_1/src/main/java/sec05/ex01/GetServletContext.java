package sec05.ex01;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetServletContext
 */
@WebServlet("/getContext")
public class GetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		
		String address = (String)context.getAttribute("address");
		System.out.println(address);
		//setServlet 서블릿에 한번이라도 request를 했을 경우, 해당 서블릿의 context.setAttribute("address", "미금역"); 에 의해
		//해당 서블릿들이 속한 컨텍스트에 address와 미금역이 바인딩되기 때분에 다른 서블릿인 이 서블릿에서 get을 통해 address가 name인 value를 가져올 수 있는거임.
	}
}
