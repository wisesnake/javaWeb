package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();

		HttpSession sess = request.getSession();

		String ctxMesg = (String) ctx.getAttribute("context");
		String sesMesg = (String) sess.getAttribute("session");

		String reqMesg = (String) request.getAttribute("request");
		out.print("context값 : " + ctxMesg + "<br>");
		// 어떤 브라우저에서 접근해도 속성 접근 가능
		out.print("session값 : " + sesMesg + "<br>");
		// 브라우저마다(세션마다) 각각 접근 가능, set한 브라우저와 다른 브라우저에서 접근 시
		// null 출력.
		out.print("request값 : " + reqMesg + "<br>");
		// 리퀘스트마다 접근 가능, 따라서 이건 set에서 setAttribute해줬어도 null나옴.
	}

}
