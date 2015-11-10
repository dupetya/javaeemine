package hu.dupetya.core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.dupetya.common.dao.DAOException;
import hu.dupetya.common.dao.RoleDAO;
import hu.dupetya.common.entity.RoleEntity;
import hu.dupetya.common.repository.RoleRepository;

@Service("roleDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public List<RoleEntity> findRolesByUserId(Long id) throws DAOException {
		return roleRepository.findRolesByUserId(id);
	}

	@Override
	public void addRoleToUser(Long roleId, Long userId) throws DAOException {
		roleRepository.addRoleToUser(roleId, userId);
	}

	@Override
	public void removeRoleFromUser(Long roleId, Long userId) throws DAOException {
		roleRepository.removeRoleFromUser(roleId, userId);
	}

	@Override
	public RoleEntity findRoleByName(String name) throws DAOException {
		return roleRepository.findRoleByName(name);
	}

}
