package hu.dupetya.common.dao;

import java.util.List;

import hu.dupetya.common.entity.Role;

public interface RoleDAO {
	List<Role> getAllRoles() throws DAOException;

	Role getRoleByName(String name) throws DAOException;

}
