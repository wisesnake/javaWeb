package sec05.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextFileServlet
 */
@WebServlet("/contextFile")
public class ContextFileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
		//입력스트림 변수 is 에 init.txt 가져옴
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		//버퍼리더 객체 buffer에 is를 버퍼화하여 읽어옴.
		
		String menu = null;
		String menu_order = null;
		String menu_member = null;
		String menu_goods = null;

		while ((menu = buffer.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(menu, ",");
			menu_member = tokens.nextToken();
			menu_order = tokens.nextToken();
			menu_goods = tokens.nextToken();
		}
//buffer.readLine(): 이 메서드는 BufferedReader 객체인 buffer를 사용하여 파일에서 한 줄씩 읽어옵니다. 파일의 끝에 도달하면 null을 반환합니다.
//menu = buffer.readLine(): buffer.readLine()의 반환값을 menu 변수에 할당합니다. 즉, 현재 읽은 한 줄의 내용을 menu 변수에 저장합니다.
//while ((menu = buffer.readLine()) != null): 이 조건문은 menu 변수에 저장된 값이 null이 아닌 경우에만 루프를 실행합니다. 즉, 파일의 끝에 도달하면 루프가 종료됩니다.
//따라서 이 while 루프는 파일에서 한 줄씩 읽어와서 각 줄의 내용을 menu, menu_order, menu_member, menu_goods 변수에 저장하고, 파일의 끝에 도달하면 루프를 종료합니다. 
//이렇게 읽은 데이터를 출력하여 웹 페이지에 표시할 수 있습니다.

		out.print("<html><body>");
		out.print(menu_member + "<br>");
		out.print(menu_order + "<br>");
		out.print(menu_goods + "<br>");
		out.print("</body></html>");
		out.close();
	}

}
