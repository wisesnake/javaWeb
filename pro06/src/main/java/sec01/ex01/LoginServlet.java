package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
	}

	@Override
	public void destroy() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=utf-8");
////		클라이언트에게 응답으로 보낼 컨텐트의 타입을 결정, meta charset을 utf-8로 함으로써 한글 나옴.
//		
////		System.out.println("여기는 로그인서블릿");
//		String user_id = request.getParameter("user_id");
////		html의 form으로부터 들어온 name의 매개값을 이용해 넘어온 input 값을 get해오는 메서드.
////		String user_pw = request.getParameter("user_pw");
////		System.out.println("환영합니다. " + user_id);
//		
//		
//		PrintWriter pw = response.getWriter();
////		응답으로 보낼 컨텐트에 출력 스트림인 printwriter를 활용하여 응답 페이지를 print메서드로 작성하기 위함.
//		pw.print("<html><head></head><body>"+"<h1>반갑습니다! "+user_id+"</h1>"+"</body></html>");
		doHandle(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text/html;charset=utf-8");
//		String user_id = req.getParameter("user_id");
		
		
//		String[] lunches = req.getParameterValues("lunch");
//		String outputLunch = "";
//		for(String lunch : lunches) {
//			outputLunch += (" " + lunch);
//		}
		
//		Enumeration<String> enu = req.getParameterNames();
//		
//		System.out.println(enu);
//		
//		while(enu.hasMoreElements()) {
//			String str = enu.nextElement();
//			System.out.println(str);
//		}
		
//		System.out.println("post가 동작했다...");
//		PrintWriter pw = resp.getWriter();
//		pw.print("<html>"
//				+ "<head>"
//				+ "</head>"
//				+ "<body>"
//				+"<h1>반갑습니다! "+user_id+"</h1>"
////				+"오늘의 점심으로" + outputLunch + "을 선택하셨군요!"
//				+"</body>"
//				+ "</html>");
		doHandle(req,resp);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String user_id = request.getParameter("user_id");
		pw.print("<html>"
				+ "<head>"
				+ "</head>"
				+ "<body>"
				+"<h1>반갑습니다! "
				+user_id
				+"</h1>"
				+"</body>"
				+ "</html>");
	}

}
