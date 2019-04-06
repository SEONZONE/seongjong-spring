package org.seongjong.article_1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * articleDao를 사용해서 글 목록, 조회, 추가, 수정, 삭제를 한다.
 * 
 * @author Jacob
 */
@Service
public class ArticleService {
	@Autowired
	ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	/**
	 * 글 목록
	 */
	public void listArticles() {
		List<Article> articles = articleDao.listArticles();
		System.out.println(articles);
	}

	/**
	 * 글 조회
	 */
	public void getArticle() {
		Article article = articleDao.getArticle("3");
		System.out.println(article);
	}

	/**
	 * 글 등록
	 */
	public void addArticle() {
		Article article = new Article();
		article.setTitle("새로운 '어벤져스 앤드게임' 영화의 스틸이 공개됐다가 안됨 ㅅ(사진 6장)");
		article.setContent(
				"어벤져스 앤드게임 너무 재밌겠당 기대된다 히히히히호호하하하호호호히히흐히ㅡ히ㅡ히ㅡ히흐히.");
		article.setUserId("5");
		article.setName("박성종");
		if (articleDao.addArticle(article) > 0)
			System.out.println("글을 추가했습니다.");
		else
			System.out.println("글을 추가하지 못했습니다.");
	}

	/**
	 * 글 수정
	 */
	public void updateArticle() {
		Article article = new Article();
		article.setArticleId("3");
		article.setTitle("This is modified title.");
		article.setContent("This is modified content");
		if (articleDao.updateArticle(article) > 0)
			System.out.println("글을 수정했습니다.");
		else
			System.out.println("글을 수정하지 못했습니다.");
	}

	/**
	 * 글 삭제
	 */
	public void deleteArticle() {
		if (articleDao.deleteArticle("8") > 0)
			System.out.println("글을 삭제했습니다.");
		else
			System.out.println("글을 삭제하지 못했습니다.");
	}
}
