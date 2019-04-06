package org.seongjong.article_1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ArticleService를 테스트하는 main
 * 
 * @author Jacob
 */
public class ArticleMainUsingSpring {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"article_component.xml");
		ArticleService articleService = context.getBean("articleService", ArticleService.class);
		articleService.listArticles();
		articleService.addArticle();
		context.close();

	}
	

}