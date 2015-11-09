package hu.dupetya.common.dao;

import hu.dupetya.common.entity.UserEntity;

public interface UserDAO extends BaseDAO<UserEntity> {
	UserEntity findUserByName(String name) throws DAOException;
}
