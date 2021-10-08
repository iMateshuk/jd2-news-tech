package by.itacademy.news_tech.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.itacademy.news_tech.entity.News;
import by.itacademy.news_tech.service.NewsService;

@Controller
@Validated
//@RequestMapping("/news")
public class NewsController {

	@Autowired
	NewsService newsService;

	@RequestMapping("/list")
	public String getNewses(Model theModel) {

		// get newses from the service
		List<News> newses = newsService.getNewses();
		// add the newses to the model
		theModel.addAttribute("newses", newses);

		return "news-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data

		theModel.addAttribute("news", new News());

		return "news-form";
	}

	@PostMapping("/saveNews")
	public String saveNews(@ModelAttribute("news") @Valid News theNews, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			
			return "news-form";
		}

		// save the news using our service
		theNews.setDate(new Timestamp(System.currentTimeMillis()));
		
		newsService.saveOrUpdateNews(theNews);

		return "redirect:list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("newsId") int theId, Model theModel) {

		// get the news from our service
		News theNews = newsService.getNews(theId);

		// set news as a model attribute to pre-populate the form
		theModel.addAttribute("news", theNews);

		// send over to our form
		return "news-form";
	}
	
	@GetMapping("/newsDelete")
	public String deleteNews(@RequestParam("newsId") int theId) {

		// delete the news
		newsService.deleteNews(theId);

		return "redirect:list";
	}
	
	@GetMapping("/readNews")
	public String readNews(@RequestParam("newsId") int theId, Model theModel) {

		// get the news
		theModel.addAttribute("news", newsService.getNews(theId));

		return "news-read";
	}

}
