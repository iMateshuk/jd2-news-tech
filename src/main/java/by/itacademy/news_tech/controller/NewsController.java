package by.itacademy.news_tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.itacademy.news_tech.bean.News;
import by.itacademy.news_tech.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {

	@Autowired
	NewsService newsService;

	@RequestMapping("/newses")
	public String getNewses(Model theModel) {

		// get newses from the service
		List<News> newses = newsService.getNewses();
		// add the newses to the model
		theModel.addAttribute("newses", newses);

		return "news-list";
	}

	/*
	 * public List<News> getNewses();
	 * 
	 * public News getNews(int theId);
	 * 
	 * public void saveOrUpdateNews(News news); Use for save or update!!!!!!!!
	 * 
	 * public void deleteNews(int theId);
	 */

}
