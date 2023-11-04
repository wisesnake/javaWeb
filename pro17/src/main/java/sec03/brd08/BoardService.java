package sec03.brd08;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardService {
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
	}
	
	public Map listArticles(Map<String, Integer> pagingMap) {
		Map articlesMap = new HashMap();
		List<ArticleVO> articlesList = boardDAO.selectAllArticles(pagingMap);
		int totArticles = boardDAO.selectTotArticles();
		articlesMap.put("articlesList", articlesList);
		articlesMap.put("totArticles", totArticles);
		//articlesMap.put("totArticles", 170);
		return articlesMap;
	}
	
	public List<ArticleVO> listArticles(){
		List<ArticleVO> articlesList = boardDAO.selectAllArticles();
		return articlesList;
	}
	
	public int addArticle(ArticleVO article){
		return boardDAO.insertNewArticle(article);	
		//컨트롤러의 upload메드 이후 알맞게 맵/키 형태로 바인드되어 나뉜 VO 를 인서트.
	}
	
	public ArticleVO viewArticle(int articleNO) {
		ArticleVO aritcleVO = null;
		aritcleVO = boardDAO.selectArticle(articleNO);
		return aritcleVO;
	}

	public void modArticle(ArticleVO article) {
		boardDAO.updateArticle(article);
	}

	public List<Integer> removeArticle(int articleNO) {
		List<Integer> listArticleNO = boardDAO.selectRemovedArticles(articleNO);
		boardDAO.deleteArticle(articleNO);
		return listArticleNO;
	}

	public int addReply(ArticleVO articleVO) {
		int articleNO = boardDAO.insertNewArticle(articleVO);
		return articleNO;
	}
}
