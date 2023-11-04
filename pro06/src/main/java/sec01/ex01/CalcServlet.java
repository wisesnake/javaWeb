package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcservlet")
public class CalcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static float USD_RATE = 1124.70F;
	private static float JPY_RATE = 10.113F;
	private static float CNY_RATE = 163.30F;
	private static float GBP_RATE = 1444.35F;
	private static float EUR_RATE = 1295.97F;

	private static String calc(float won, String operator) {
		String result = null;
		if (operator.equals("dollar")) {
			result = String.format("%.6f", won / USD_RATE) + "달러";
		} else if (operator.equals("en")) {
			result = String.format("%.6f", won / JPY_RATE) + "엔";
		} else if (operator.equals("wian")) {
			result = String.format("%.6f", won / CNY_RATE) + "위안";
		} else if (operator.equals("pound")) {
			result = String.format("%.6f", won / GBP_RATE) + "파운드";
		} else if (operator.equals("euro")) {
			result = String.format("%.6f", won / EUR_RATE) + "유로";
		}
		return result;
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		String command = request.getParameter("command");
		//hidden태그를 이용하여 submit을 눌렀는지 안눌렀는지 확인하는 용도
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		
		if (command != null && command.equals("calculate")) {
			String result = calc(Float.parseFloat(won), operator);
			pw.print("<html><font size=10>변환결과</font><br>");
			pw.print("<html><font size=10>" + result + "</font><br>");
			pw.print("<a href='/pro06/calcservlet'>이전 화면으로</a>");
			return;
//			현재 서블릿 객체의 get메서드 종료시켜 각종 변수값들 초기화하는 용도.
		}

		pw.print("<html><title>환율계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form  method='get'  action=''/>  ");
//		메서드 디폴트 get, 액션 디폴트 현재서블릿.
		pw.print("원화: <input type='text' name='won' size=10  />  ");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollar'>달러</option>");
		pw.print("<option value='en'>엔화</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate'  />  ");
		pw.println("<input type='submit' value='변환'  />");
//		submit 을 눌러야 form태그 내의 value 들이 각각 조건에 맞추어서 넘어오는데, submit 인풋을
//		하지 않으면 hidden타입의 value calculate가 넘어오지 않고, command는 null인채로 넘어올테니
//		hidden은 이걸 이용하는거임. 아마 주로 submit이랑 같이 페어로 많이들 쓰일듯?
//		따라서 calc메서드를 if문을 이용하여 command가 null이 아닐 때, 호출하게끔 코딩을 해두면
//		그와 맞게끔 서블릿이 response 를 넘기게 되는거임
		pw.println("</form>");
		pw.print("</html>");
		pw.close();
		
		
	}

}
