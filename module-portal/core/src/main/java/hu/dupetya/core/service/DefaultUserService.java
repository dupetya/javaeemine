package hu.dupetya.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.dupetya.common.entity.UserEntity;
import hu.dupetya.common.repository.UserRepository;
import hu.dupetya.common.service.UserService;

@Service("userService")
public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Long registerUser(UserEntity user) {
		UserEntity newUser = userRepository.save(user);
		return newUser.getId();
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

}
