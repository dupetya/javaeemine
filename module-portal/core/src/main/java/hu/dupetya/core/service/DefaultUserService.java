package hu.dupetya.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.dupetya.common.dao.DAOException;
import hu.dupetya.common.dao.RoleDAO;
import hu.dupetya.common.dao.UserDAO;
import hu.dupetya.common.entity.RoleEntity;
import hu.dupetya.common.entity.UserEntity;
import hu.dupetya.common.service.UserService;

@Service("userService")
public class DefaultUserService implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleDAO roleDAO;

	@Override
	public Long registerUser(UserEntity user) {
		try {
			return userDAO.save(user);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public void deleteUser(Long id) {
		try {
			userDAO.delete(id);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setUpRoles(UserEntity user) {
		try {
			List<RoleEntity> roles = roleDAO.findRolesByUserId(user.getId());
			user.setRoles(roles);
		} catch (DAOException e) {
			e.printStackTrace();
		}

	}

}
