package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json2")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandler(request, response);
	}

	protected void doHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		JSONObject totObj = new JSONObject(); // 배열 저장할 변수
		JSONArray membersArr = new JSONArray(); // 밑의 memberInfo json객체를 저장할 배열 선언. 
		JSONObject memberInfo = new JSONObject(); // 회원 각각 한명의 정보가 들어갈 객체 선언.
		

		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날센돌이");
        //  배열에 입력
		membersArr.add(memberInfo);
		System.out.println();
		System.out.println(membersArr); // [{"gender":"남자","name":"박지성","nickname":"날센돌이","age":"25"}]

		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "퀸연아");
		membersArr.add(memberInfo);
		System.out.println();
		System.out.println(membersArr); 
		totObj.put("members",membersArr);
		//위와 같은 과정을 예를들어 책이름, 가격등의 데이터로 한다면,
		//booksArr,bookInfo 와 같이 작성한다음
		//totObj.put("books" booksArr);
		//해서 넘기면, json6.jsp를 참조했을 때,
		//jsonData.members[i].name~~~~ 와 같이,
		//jsonData.books[i].name 같이 데이터에 접근할 수 있음.
	
		
		String jsonInfo = totObj.toJSONString();
		System.out.println();
		System.out.println(jsonInfo);
		pw.print(jsonInfo);
	}

}
