package sec05.ex01;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadAppConfig
 */
@WebServlet(name = "loadConfig",urlPatterns = "/loadConfig", loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
	private ServletContext context;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig의 init 메서드 호출");
		context = config.getServletContext();
		
		//톰캣 실행시 init()매서드를 통해서 getinitparameter()메서ㅓ드를 이용해 web.xml의 메뉴정보를
		//읽어들인 후 다시 servletcontext 객체에서 메뉴 항목을 가져온 후 출력하기 때문에 파일에서 읽어
		//들여와 출력하는 것보다 빨리 출력할 수 있다.
		
		String menu_member = context.getInitParameter("menu_member");
		
		context.setAttribute("menu_member", menu_member);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu_member = (String)context.getAttribute("menu_member");
		
		System.out.println(menu_member);
	}

}
