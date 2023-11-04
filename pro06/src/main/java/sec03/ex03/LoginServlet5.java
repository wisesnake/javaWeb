package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
//		String address = request.getParameter("user_address");

		System.out.println("아이디 :" + id);
		System.out.println("비밀번호 :" + pw);

		
		if (id != null && (id.length() != 0)) {
			out.print("<html>");
			out.print("<body>");
			out.print(id + "님이 로그인 하셨습니다.<br>");
			out.print("</html>");
			out.print("</body>");
		} else {
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요!!");
			out.print("<br>");
			out.print("<a href='http://localhost:8090/pro06/login3.html'>로그인창으로  </a>");
			out.print("</html>");
			out.print("</body>");
		}
		
//		String data = "<html>";
//		data += "<body>";
//		data += "아이디 : " + id;
//		data += "<br>";
//		data += "비밀번호 : " + pw;
//		data += "<br>";
//		data += "주소 : " + address;
//		data += "</body>";
//		data += "</html>";
//		out.print(data);

	}

}
