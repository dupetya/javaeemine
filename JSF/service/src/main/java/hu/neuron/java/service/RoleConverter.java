package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.neuron.java.service.vo.RoleVO;
import hu.schonherz.java.entities.Role;

public class RoleConverter {

	private static Mapper mapper = new DozerBeanMapper();

	public static RoleVO toVo(Role Role) {
		if (Role == null) {
			return null;
		}
		return mapper.map(Role, RoleVO.class);
	}

	public static Role toEntity(RoleVO Role) {
		if (Role == null) {
			return null;
		}
		return mapper.map(Role, Role.class);
	}

	public static List<RoleVO> toVo(List<Role> Roles) {
		List<RoleVO> res = new ArrayList<>();

		for (Role Role : Roles) {
			res.add(toVo(Role));
		}

		return res;
	}

	public static List<Role> toEntity(List<RoleVO> Roles) {
		List<Role> res = new ArrayList<>();

		for (RoleVO Role : Roles) {
			res.add(toEntity(Role));
		}

		return res;
	}

}
