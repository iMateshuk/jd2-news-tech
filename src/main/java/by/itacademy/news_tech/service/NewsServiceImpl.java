package by.itacademy.news_tech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import by.itacademy.news_tech.bean.News;
import by.itacademy.news_tech.dao.NewsDAO;

public class NewsServiceImpl implements NewsService {
	
	@Autowired
	NewsDAO newsDAO;

	@Override
	@Transactional
	public List<News> getNewses() {

		return newsDAO.getNewses();
	}

	@Override
	@Transactional
	public News getNews(int theId) {
		
		return newsDAO.getNews(theId);
	}

	@Override
	@Transactional
	public void saveOrUpdateNews(News news) {
		
		newsDAO.saveOrUpdateNews(news);
	}

	@Override
	@Transactional
	public void deleteNews(int theId) {
		
		newsDAO.deleteNews(theId);
	}

}
