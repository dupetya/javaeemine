package hu.dupetya.common.service;

import hu.dupetya.common.entity.UserEntity;

public interface UserService {
	public Long registerUser(UserEntity user);

	public void deleteUser(Long id);
}
