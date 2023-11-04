package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/show")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id ="", pwd="" ;
        Boolean isLogon=false;
        HttpSession session =  request.getSession(false);
		//이미 세션이 생성되어 있으면 세션을, 생성 안되어있으면 null 반환.			

        if( session != null){
		//세션이 생성되어있을 경우(로그인서블릿에서 ID PW DB대조 해서 session.getSession 이 작동했을 경우)
	    isLogon=(Boolean)session.getAttribute("isLogon");
		//이즈로그온을 세션에 true로 저장되어있는걸 받아오고
           if(isLogon==true){ 
	        id = (String)session.getAttribute("login.id");
	        pwd = (String)session.getAttribute("login.pwd");
			//아이디비번도 받아온다.
   	        out.print("<html><body>");
	        out.print("아이디: " + id+"<br>");
	        out.print("비밀번호: " + pwd+"<br>");
	        out.print("</body></html>");
	    }else{
	       response.sendRedirect("login3.html");
	    }
         }else{
            response.sendRedirect("login3.html");
        }
	}
	
}
