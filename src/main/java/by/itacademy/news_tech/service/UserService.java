package by.itacademy.news_tech.service;

import java.util.List;

import by.itacademy.news_tech.entity.User;

public interface UserService {
	
	public List<User> getUsers();
	
	public void saveOrUpdateUser(User user);

	public void deleteUser(User user);

}
