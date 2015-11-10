package hu.dupetya.core.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.dupetya.common.dao.RoleDAO;
import hu.dupetya.common.entity.RoleEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-core-test.xml")
public class RoleDAOImplTest {

	@Autowired
	RoleDAO roleDAO;

	@Test
	public void testFindRolesByUserId() throws Exception {
		RoleEntity re = roleDAO.findRolesByUserId(1L).get(0);

		assertEquals(new RoleEntity(1L, "ROLE_USER"), re);
	}

	@Test
	public void addRoleToUser() throws Exception {
		roleDAO.addRoleToUser(2L, 1L);

		List<RoleEntity> roles = roleDAO.findRolesByUserId(1L);

		assertTrue(roles.contains(new RoleEntity(2L, "")));
	}

	@Test
	public void testRemoveFromUser() throws Exception {
		roleDAO.addRoleToUser(3L, 1L);

		roleDAO.removeRoleFromUser(3L, 1L);
		assertFalse(roleDAO.findRolesByUserId(1L).contains(new RoleEntity(3L, "")));
	}

	@Test
	public void testFindRoleByName() throws Exception {
		String name = "ROLE_MOD";
		Long expId = 2L;

		assertEquals(new RoleEntity(expId, name), roleDAO.findRoleByName(name));
	}
}
