package hu.dupetya.core.service;

import hu.dupetya.common.entity.User;
import hu.dupetya.common.repository.UserRepository;
import hu.dupetya.common.service.UserService;

public class DefaultUserService implements UserService {

	private UserRepository userRepository;

	@Override
	public Long registerUser(User user) {
		User newUser = userRepository.save(user);
		return newUser.getId();
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

}
