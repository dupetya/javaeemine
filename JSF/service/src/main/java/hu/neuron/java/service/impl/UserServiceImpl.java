package hu.neuron.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.service.UserConverter;
import hu.neuron.java.service.UserService;
import hu.neuron.java.service.vo.UserVO;
import hu.schonherz.java.dao.RoleDAO;
import hu.schonherz.java.dao.UserDAO;
import hu.schonherz.java.entities.Role;
import hu.schonherz.java.entities.User;

@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;

	@Autowired
	RoleDAO roleDao;

	@Override
	public UserVO findUserByName(String name) throws Exception {
		User user = userDao.findByUsername(name);
		return UserConverter.toVo(user);
	}

	@Override
	public void registrationUser(UserVO userVO) throws Exception {
		User user = UserConverter.toEntity(userVO);
		user = userDao.save(user);

		List<Role> roles = user.getRoles();
		if (roles == null || roles.isEmpty()) {
			roles = new ArrayList<>();
		}

		Role role = getUserRole();
		roles.add(role);

		user.setRoles(roles);
		userDao.save(user);
	}

	public Role getUserRole() {
		Role role = roleDao.findByName("USER_ROLE");
		if (role == null) {
			role = new Role();
			role.setName("USER_ROLE");
			role = roleDao.save(role);
		}
		return role;
	}

	@Override
	public List<UserVO> getUserList(int i, int pageSize, String sortField, int dir, String filter,
			String filterColumnName) {
		return null;
	}

	@Override
	public Integer getUserCount() {
		return null;
	}

	@Override
	public void saveUser(UserVO selectedUser) {

	}

}
