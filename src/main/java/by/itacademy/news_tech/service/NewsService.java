package by.itacademy.news_tech.service;

import java.util.List;

import by.itacademy.news_tech.bean.News;

public interface NewsService {

	public List<News> getNewses();

	public News getNews(int theId);
	
	public void saveOrUpdateNews(News news);

	public void deleteNews(int theId);

}
