package sec03.brd07;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

//@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE_REPO = "c:/board/article_image";

	BoardService boardService;
	ArticleVO articleVO;
	HttpSession session;

	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();
		articleVO = new ArticleVO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action: " + action);
		try {

			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			if (action == null || action.equals("/listArticles.do")) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board06/listArticles.jsp";
			} else if (action.equals("/articleForm.do")) {
				nextPage = "/board06/articleForm.jsp";
			} else if (action.equals("/addArticle.do")) {
				int articleNO = 0;
				Map<String, String> articleMap = upload(request, response);
				// 키,값 형태의 문자열을 제너릭으로 사용하는 map 컬렉션 데이터 생성 후,
				// upload메서드를 이용해 파일, 제목, 글 등으로 키/값 컬렉션 형태로 넘어온
				// 글쓰기 등록된 게시판 데이터 파일을 저장함.
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");

				articleVO.setParentNO(0);
				articleVO.setId("hong");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				articleNO = boardService.addArticle(articleVO);
				// 글 등록 후 새 글의 글번호 저장.

				if (imageFileName != null && imageFileName.length() != 0) {
					// 그림파일이 있을경우에만.
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					// temp에서 읽어오고
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
					destDir.mkdirs();
					// temp에서 글번호 폴더로 옮김
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					// 그리고 temp에서 글번호 폴더로 파일 옮김.
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('새글을 추가했습니다.');" + " location.href='" + request.getContextPath()
						+ "/board/listArticles.do';" + "</script>");

				return;

			} else if (action.equals("/viewArticle.do")) {
				String articleNO = request.getParameter("articleNO");
				articleVO = boardService.viewArticle(Integer.parseInt(articleNO));
				request.setAttribute("article", articleVO);
				nextPage = "/board06/viewArticle.jsp";
			} else if (action.equals("/modArticle.do")) {
				Map<String, String> articleMap = upload(request, response);
				int articleNO = Integer.parseInt(articleMap.get("articleNO"));
				articleVO.setArticleNO(articleNO);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");

				articleVO.setParentNO(0);
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				articleVO.setId("hong");
				boardService.modArticle(articleVO);
				if (imageFileName != null && imageFileName.length() != 0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
					srcFile.delete();
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('글을 수정했습니다.');" + " location.href='" + request.getContextPath()
						+ "/board/listArticles.do';" + "</script>");
				return;

			} else if (action.equals("/removeArticle.do")) {
				int articleNO = Integer.parseInt(request.getParameter("articleNO"));
				List<Integer> articleNOList = boardService.removeArticle(articleNO);
				for (int _articleNO : articleNOList) {
					File imgDir = new File(ARTICLE_IMAGE_REPO + "\\" + _articleNO);
					if (imgDir.exists()) {
						FileUtils.deleteDirectory(imgDir);
					}
				}

				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('글을 삭제했습니다.');" + " location.href='" + request.getContextPath()
						+ "/board/listArticles.do';" + "</script>");
				return;

			} else if (action.equals("/replyForm.do")) {
				int parentNO = Integer.parseInt(request.getParameter("parentNO"));
				session = request.getSession();
				session.setAttribute("parentNO", parentNO);
				nextPage = "/board06/replyForm.jsp";

			} else if (action.equals("/addReply.do")) {
				session = request.getSession();
				int parentNO = (Integer) session.getAttribute("parentNO");
				System.out.println("파렌트노 : "+parentNO);
				session.removeAttribute("parentNO");
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				String id = articleMap.get("id");
				
				articleVO.setParentNO(parentNO);
				articleVO.setId(id);
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				int articleNO = boardService.addReply(articleVO);
				if (imageFileName != null && imageFileName.length() != 0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
					destDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, destDir, true);
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('답글을 추가했습니다.');" + " location.href='" + request.getContextPath()
						+ "/board/viewArticle.do?articleNO=" + articleNO + "';" + "</script>");
				return;

			} else {
				nextPage = "/board06/listArticles.jsp";
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 업로드() 메소드 : request로 넘어온 데이터 델꼬가서 폼필드와 파일로 나누어서 매핑하도 반환하는 매소드
		Map<String, String> articleMap = new HashMap<String, String>();
		// 제목:제목문자열/ 내용:내용문자열 / 파일:파일명 형태로 반환하기 위한 MAP컬렉션 생성.
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			// HTTP 요청에서 파일 및 폼 필드 데이터를 파싱(데이터 분해,분석)하여 LIST컬렉션형태로 반환.
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				// 각 fileItem 객체는 request에서 받은 파라미터 각 하나를 의미함.
				if (fileItem.isFormField()) {
					// 파라미터가 글,내용 등일 경우에는 바로 매핑 후 반환.
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				} else {
					System.out.println("파라미터명:" + fileItem.getFieldName());
					// System.out.println("파일명:" + fileItem.getName());
					System.out.println("파일크기:" + fileItem.getSize() + "bytes");
					// articleMap.put(fileItem.getFieldName(), fileItem.getName());
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}

						String fileName = fileItem.getName().substring(idx + 1);
						System.out.println("파일명:" + fileName);
						articleMap.put(fileItem.getFieldName(), fileName); // 익스플로러에서 업로드 파일의 경로 제거 후 map에 파일명 저장
						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);
						// 업로드된 파일의 이름은 articleMap에 저장되고, 파일은 디스크에 currentDirPath 디렉토리에 저장됩니다.

					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleMap;
	}

}
