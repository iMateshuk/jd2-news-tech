package by.itacademy.news_tech.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.itacademy.news_tech.dao.UserDAO;
import by.itacademy.news_tech.entity.User;
import by.itacademy.news_tech.entity.UserDetail;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	@Transactional
	public void saveOrUpdateUser(User user) {
		
		user.setSalt(BCrypt.gensalt());
		user.setPassword(BCrypt.hashpw(user.getPassword(), user.getSalt()));
		user.setUserDetail(new UserDetail(user.getUsername(), "ROLE_USER"));
		userDAO.saveOrUpdateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {

		userDAO.deleteUser(user);
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
