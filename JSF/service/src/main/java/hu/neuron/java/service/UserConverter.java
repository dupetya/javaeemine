package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.neuron.java.service.vo.UserVO;
import hu.schonherz.java.entities.User;

public class UserConverter {

	private static Mapper mapper = new DozerBeanMapper();

	public static UserVO toVo(User user) {
		if (user == null) {
			return null;
		}
		return mapper.map(user, UserVO.class);
	}

	public static User toEntity(UserVO user) {
		if (user == null) {
			return null;
		}
		return mapper.map(user, User.class);
	}

	public static List<UserVO> toVo(List<User> users) {
		List<UserVO> res = new ArrayList<>();

		for (User user : users) {
			res.add(toVo(user));
		}

		return res;
	}

	public static List<User> toEntity(List<UserVO> users) {
		List<User> res = new ArrayList<>();

		for (UserVO user : users) {
			res.add(toEntity(user));
		}

		return res;
	}

}
