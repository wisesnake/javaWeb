package sec03.brd08;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;

	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List selectAllArticles() {
		List articlesList = new ArrayList();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT LEVEL,articleNO,parentNO,title,content,id,writeDate" + " from t_board"
					+ " START WITH  parentNO=0" + " CONNECT BY PRIOR articleNO=parentNO"
					+ " ORDER SIBLINGS BY articleNO DESC";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				ArticleVO article = new ArticleVO();
				article.setLevel(level);
				article.setArticleNO(articleNO);
				article.setParentNO(parentNO);
				article.setTitle(title);
				article.setContent(content);
				article.setId(id);
				article.setWriteDate(writeDate);
				articlesList.add(article);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articlesList;
	}
	
	public List selectAllArticles(Map pagingMap){
		List articlesList = new ArrayList();
		int section = (Integer)pagingMap.get("section");
		int pageNum=(Integer)pagingMap.get("pageNum");
		try{
		   conn = dataFactory.getConnection();
		   String query ="SELECT * FROM ( "
						+ "select ROWNUM  as recNum,"+"LVL,"
							+"articleNO,"
							+"parentNO,"
							+"title,"
							+"id,"
							+"writeDate"
				                  +" from (select LEVEL as LVL, "
								+"articleNO,"
								+"parentNO,"
								+"title,"
								+"id,"
								 +"writeDate"
							   +" from t_board" 
							   +" START WITH  parentNO=0"
							   +" CONNECT BY PRIOR articleNO = parentNO"
							  +"  ORDER SIBLINGS BY articleNO DESC)"
					+") "                        
					+" where recNum between(?-1)*100+(?-1)*10+1 and (?-1)*100+?*10";                
		   System.out.println(query);
		   pstmt= conn.prepareStatement(query);
		   pstmt.setInt(1, section);
		   pstmt.setInt(2, pageNum);
		   pstmt.setInt(3, section);
		   pstmt.setInt(4, pageNum);
		   ResultSet rs =pstmt.executeQuery();
		   while(rs.next()){
		      int level = rs.getInt("lvl");
		      int articleNO = rs.getInt("articleNO");
		      int parentNO = rs.getInt("parentNO");
		      String title = rs.getString("title");
		      String id = rs.getString("id");
		      Date writeDate= rs.getDate("writeDate");
		      ArticleVO article = new ArticleVO();
		      article.setLevel(level);
		      article.setArticleNO(articleNO);
		      article.setParentNO(parentNO);
		      article.setTitle(title);
		      article.setId(id);
		      article.setWriteDate(writeDate);
		      articlesList.add(article);	
		   } //end while
		   rs.close();
		   pstmt.close();
		   conn.close();
	  }catch(Exception e){
	     e.printStackTrace();	
	  }
	  return articlesList;
    } 
	private int getNewArticleNO() {
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT  max(articleNO) from t_board ";
			// 해당 테이블의 articleNo 컬럼의 최고수 받는 쿼리.
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery(query);
			if (rs.next())
				return (rs.getInt(1) + 1);// 최고숫자에 +1하면 새글의 번호가 됨.
			//이걸 리턴했으므로, 다음 새 게시글의 번호자 저장되어 넘어감.
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int insertNewArticle(ArticleVO article) {
		int articleNO = getNewArticleNO();
		try {
			conn = dataFactory.getConnection();
			int parentNO = article.getParentNO();
			String title = article.getTitle();
			String content = article.getContent();
			String id = article.getId();
			System.out.println(id);
			String imageFileName = article.getImageFileName();
			String query = "INSERT INTO t_board (articleNO, parentNO, title, content, imageFileName, id)"
					+ " VALUES (?, ? ,?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return articleNO;
	}

	public ArticleVO selectArticle(int articleNO) {
		ArticleVO article = new ArticleVO();
		try {
			conn = dataFactory.getConnection();
			String query = "select articleNO,parentNO,title,content, imageFileName,id,writeDate" + " from t_board"
					+ " where articleNO=?";
			// 매개값으로 전달받은 글번호를 사용해 해당 게시판 모든 데이터 불러옴.
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int _articleNO = rs.getInt("articleNO");
			int parentNO = rs.getInt("parentNO");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = rs.getString("imageFileName");
			String id = rs.getString("id");
			Date writeDate = rs.getDate("writeDate");

			article.setArticleNO(_articleNO);
			article.setParentNO(parentNO);
			article.setTitle(title);
			article.setContent(content);
			article.setImageFileName(imageFileName);
			article.setId(id);
			article.setWriteDate(writeDate);
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	public void updateArticle(ArticleVO article) {
		try {
			conn = dataFactory.getConnection();
			String title = article.getTitle();
			String content = article.getContent();
			String imageFileName = article.getImageFileName();
			int articleNO = article.getArticleNO();
			String query = "Update t_board set title=?,content=?";
			if (imageFileName != null && imageFileName.length() != 0) {
				query += ",imageFileName=?";
			}
			query += " where articleNO=?";

			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			if (imageFileName != null && imageFileName.length() != 0) {
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, articleNO);
			} else {
				pstmt.setInt(3, articleNO);
			}
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteArticle(int articleNO) {

		try {
			conn = dataFactory.getConnection();
			String query = "Delete from t_board where articleNo in " + "(select articleNO from t_board"
					+ " start with articleNO = ?" + " connect by prior articleNO = parentNO)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Integer> selectRemovedArticles(int articleNO) {
		List<Integer> removedArticleNOList = new ArrayList<>();
		try {
			conn = dataFactory.getConnection();
			String query = "select articleNO from t_board" + " start with articleNO = ?"
					+ "connect by prior articleNO = parentNO";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				articleNO = rs.getInt("articleNO");
				removedArticleNOList.add(articleNO);
			}
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return removedArticleNOList;
	}
	
	public int selectTotArticles() {
		try {
			conn = dataFactory.getConnection();
			String query = "select count(articleNO) from t_board ";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
				return (rs.getInt(1));
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
