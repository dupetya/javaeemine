package hu.dupetya.common.dao;

import java.util.List;

import hu.dupetya.common.entity.RoleEntity;

public interface RoleDAO {

	List<RoleEntity> findRolesByUserId(Long id) throws DAOException;

	void addRoleToUser(Long roleId, Long userId) throws DAOException;

	void removeRoleFromUser(Long roleId, Long userId) throws DAOException;

	RoleEntity findRoleByName(String name) throws DAOException;

}
