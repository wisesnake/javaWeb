package sec02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;

	
	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		//URL에서 요청명 가져옴(URL패턴의 * 부분으로 들어오는놈들)
		System.out.println("action:" + action); 
		if (action == null || action.equals("/listMembers.do")) {
			//리퀘스트요청이 /member(즉, 최초요청) 이거나, /member/listMembers.do인놈들
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";
			//다음페이지를 회원목록으로.
		} else if (action.equals("/addMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			nextPage = "/member/listMembers.do";
			//회원가입 요청 들어올 경우,  회원가입 시키고 회원목록으로

		} else if (action.equals("/memberForm.do")) {
			//회원가입으로 들어올 경우 회원가입폼jsp로 보냄
			nextPage = "/test02/memberForm.jsp";
		} else {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
		//리퀘스트에 set된 attr들 태워서 각 정해진 nextPage String의 경로로 보냄. 
	}

}
