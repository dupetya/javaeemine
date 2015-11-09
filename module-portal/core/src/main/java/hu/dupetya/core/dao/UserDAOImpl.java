package hu.dupetya.core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.dupetya.common.dao.DAOException;
import hu.dupetya.common.dao.UserDAO;
import hu.dupetya.common.entity.UserEntity;
import hu.dupetya.common.repository.UserRepository;

@Service("userDAO")
@Transactional(propagation = Propagation.SUPPORTS)
public class UserDAOImpl implements UserDAO {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Long save(UserEntity entity) throws DAOException {
		return userRepository.save(entity).getId();
	}

	@Override
	public void update(UserEntity entity) throws DAOException {
		if (userRepository.findOne(entity.getId()) == null) {
			throw new DAOException("No matching record to update");
		}

		userRepository.save(entity);
	}

	@Override
	public void delete(Long id) throws DAOException {
		if (userRepository.findOne(id) == null) {
			throw new DAOException("No matching record to delete");
		}
		userRepository.delete(id);

	}

	@Override
	public UserEntity find(Long id) throws DAOException {
		return userRepository.findOne(id);
	}

	@Override
	public List<UserEntity> findAll() throws DAOException {
		return userRepository.findAll();
	}

	@Override
	public UserEntity findUserByName(String name) throws DAOException {
		return userRepository.findByUsername(name);
	}
}
