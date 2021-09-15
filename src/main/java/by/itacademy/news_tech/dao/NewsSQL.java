package by.itacademy.news_tech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import by.itacademy.news_tech.bean.News;

public class NewsSQL implements NewsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<News> getNewses() {

		Session currentSession = sessionFactory.getCurrentSession();

		Query<News> theQuery = currentSession.createQuery("from News order by Date", News.class);

		return theQuery.getResultList();
	}

	@Override
	public News getNews(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		return currentSession.get(News.class, theId);
	}

	@Override
	public void saveOrUpdateNews(News news) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(news);
	}

	@Override
	public void deleteNews(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from News where id=:Id");

		theQuery.setParameter("Id", theId);

		theQuery.executeUpdate();
	}
}
