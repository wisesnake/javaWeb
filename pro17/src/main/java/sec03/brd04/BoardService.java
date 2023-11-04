package sec03.brd04;

import java.util.List;

public class BoardService {
	BoardDAO boardDAO;
	
	public BoardService() {
		boardDAO = new BoardDAO();
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
}
