package hu.dupetya.common.dao;

import java.util.List;

import hu.dupetya.common.entity.User;

public interface UserDAO {
	List<User> getAllUsers();

	User getUserByName(String name);

	Long saveUser(User user);

}
