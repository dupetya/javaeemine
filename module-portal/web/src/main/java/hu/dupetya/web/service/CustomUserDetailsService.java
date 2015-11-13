package hu.dupetya.web.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hu.dupetya.common.dao.RoleDAO;
import hu.dupetya.common.dao.UserDAO;
import hu.dupetya.common.entity.RoleEntity;
import hu.dupetya.common.entity.UserEntity;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserDAO userDAO;

	@Autowired
	RoleDAO roleDAO;

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		UserEntity user;
		try {
			user = userDAO.findUserByName(username);

			if (user == null) {
				throw new UsernameNotFoundException(username);
			}
			List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());

			return buildUserForAuthentication(user, authorities);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException(e.getMessage());
		}

	}

	private User buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<RoleEntity> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (RoleEntity userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
