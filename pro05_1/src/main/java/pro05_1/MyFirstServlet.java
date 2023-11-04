package pro05_1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/first")
public class MyFirstServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("최초실행 서블릿 init()실행되며 객체 초기화");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("주소창에 urlpatterns 에 적힌 /first 에 접속할때마다 doget() 실행");
	}
	
	@Override
	public void destroy() {
		System.out.println("컨테이너 종료시 객체 소멸시키는 destroy() 발동...");
	}
}
