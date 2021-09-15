package by.itacademy.news_tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import by.itacademy.news_tech.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	
	
	
	
	/*
	 * public List<News> getNewses();
	 * 
	 * public News getNews(int theId);
	 * 
	 * public void saveOrUpdateNews(News news);
	 * 
	 * public void deleteNews(int theId);
	 */

}
