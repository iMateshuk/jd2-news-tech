package by.itacademy.news_tech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.itacademy.news_tech.entity.User;

@Repository
public class UserSQL implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {

		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from Users order by date desc", User.class);
		return theQuery.getResultList();
	}

	@Override
	public void saveOrUpdateUser(User user) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(user);
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}

}
