package sec02.ex02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO;

	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		if (action == null || action.equals("/listMembers.do")) {
			//최초 혹은 회원정보 조회 요청일 시 DAO한테 회원목록 받아서 내보냄
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
		} else if (action.equals("/addMember.do")) {
			//memberForm.jsp에서 완성된 폼을 확인 눌러서 보내면 여기로 와짐.
			//회원가입일 시, 폼에 있는 파라미터 전부 가져와서 addmember돌리고, 다시 회원목록으로 보냄
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			request.setAttribute("msg", "addMember");
			nextPage = "/member/listMembers.do";
		} else if (action.equals("/memberForm.do")) {
			//회원목록창에서 회원가입 버튼 누르면 회원가입 폼 jsp로 넘김.
			nextPage = "/test03/memberForm.jsp";
		} else if (action.equals("/modMemberForm.do")) {
			//회원목록에서 수정하기 누르면 파라미터에 해당 행의 id 컬럼의
			//파라미터가 바인딩되어서 날아오고, 이를 이용해 회원정보조회
			//메서드를 돌려서 정보 vo 를 통째로 리턴받아, 바인딩해서
			//회원정보 수정 jsp 에 보내서 기존 정보를 출력함과 동시에,
			//다시 수정하여 컨트롤러로 리턴받을 수 있게 함.
			String id = request.getParameter("id");
			MemberVO memInfo = memberDAO.findMember(id);
			request.setAttribute("memInfo", memInfo);
			nextPage = "/test03/modMemberForm.jsp";
		} else if (action.equals("/modMember.do")) {
			//수정 폼 페이지에서 바인딩되어서 받은 파라미터들을 DAO에
			//VO에 담아서 수정 메소드를 돌린 뒤, 메세지 출력을 위한 
			//파라미터 바인딩해서 다시 회원목록 창으로 돌려보냄.ㄴ
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.modMember(memberVO);
			request.setAttribute("msg", "modified");
			nextPage = "/member/listMembers.do";
		} else if (action.equals("/delMember.do")) {
			//회원삭제는 그냥 회원삭제
			String id = request.getParameter("id");
			memberDAO.delMember(id);
			request.setAttribute("msg", "deleted");
			nextPage = "/member/listMembers.do";
		} else {
			//그외 뭘 입력하든 어차피 목적없는 요청이니 멤버목록으로
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test03/listMembers.jsp";
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
