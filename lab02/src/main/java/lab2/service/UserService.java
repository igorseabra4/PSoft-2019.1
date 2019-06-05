package lab2.service;

import org.springframework.stereotype.Service;

import lab2.dao.UserDAO;
import lab2.model.User;

@Service
public class UserService {
	private final UserDAO userDAO;
	
	UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public User create(User user) {
		return userDAO.save(user);
	}

	public User findByLogin(String id) {
		return userDAO.findByLogin(id);
	}
}