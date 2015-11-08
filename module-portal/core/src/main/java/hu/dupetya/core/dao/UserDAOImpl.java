package hu.dupetya.core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import hu.dupetya.common.dao.UserDAO;
import hu.dupetya.common.entity.User;
import hu.dupetya.common.repository.UserRepository;

public class UserDAOImpl implements UserDAO {

	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getUserByName(String name) {
		return userRepo.findByUsername(name);
	}

	@Override
	public Long saveUser(User user) {
		return userRepo.save(user).getId();
	}

}
