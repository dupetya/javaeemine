package hu.dupetya.common.service;

import hu.dupetya.common.entity.User;

public interface UserService {
	public Long registerUser(User user);

	public void deleteUser(Long id);
}
