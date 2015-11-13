package hu.dupetya.core.dao;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import hu.dupetya.common.dao.DAOException;
import hu.dupetya.common.dao.UserDAO;
import hu.dupetya.common.entity.RoleEntity;
import hu.dupetya.common.entity.UserEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-core-test.xml")
@Transactional
public class UserDAOTest {

	@Autowired
	UserDAO userDAO;

	@Test
	public void testSave() throws DAOException {
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(new RoleEntity(1L, "ROLE_USER"));
		UserEntity user = new UserEntity(null, "Test2", "asd", "asd@asd.asd", new Date(), roles);

		userDAO.save(user);
		UserEntity got = userDAO.findUserByName("Test2");
		System.out.println(got.getRoles());
		assertEquals(user, got);
	}

	@Test
	//@Ignore
	public void testUpdate() throws DAOException {
		List<RoleEntity> roles = new ArrayList<>();
		roles.add(new RoleEntity(1L, "ROLE_USER"));
		UserEntity user = new UserEntity(null, "Test11", "asd1", "asd@asd.asd", new Date(), roles);

		userDAO.save(user);
				
		UserEntity got = userDAO.findUserByName("Test11");
		got.setPassword("asd2");
		userDAO.update(got);
		
		assertEquals("asd2", userDAO.findUserByName("Test11").getPassword());

	}

	@Test(expected = DAOException.class)
	public void testInvalidUpdate() throws DAOException {
		UserEntity user = new UserEntity(34L, "Test4", "asd1", "asd@asd.asd", new Date(),
				Arrays.asList(new RoleEntity(1L, "ROLE_USER")));

		userDAO.update(user);

	}

	@Test
	public void testDelete() throws DAOException {
		userDAO.delete(1L);
		assertNull(userDAO.find(1L));
	}

	@Test(expected = DAOException.class)
	public void testInvalidDelete() throws DAOException {
		userDAO.delete(500L);
	}

	@Test
	public void testFind() throws DAOException {
		UserEntity user = new UserEntity(null, "Test3", "asd1", "asd@asd.asd", new Date(),
				Arrays.asList(new RoleEntity(1L, "ROLE_USER")));
		Long id = userDAO.save(user);
		assertEquals(id, userDAO.findUserByName("Test3").getId());
	}

	@Test
	public void testNullFind() throws DAOException {
		assertNull(userDAO.find(105L));
	}

	@Test
	public void testFindAll() throws DAOException {
		UserEntity user = new UserEntity(null, "Test7", "asd1", "asd@asd.asd", new Date(), Collections.emptyList());
		userDAO.save(user);

		assertNotNull(userDAO.findAll());
	}

	@Test
	public void testFindUserByName() throws DAOException {
		UserEntity user = new UserEntity(null, "Test8", "asd1", "asd@asd.asd", new Date(),
				Arrays.asList(new RoleEntity(1L, "ROLE_USER")));
		Long id = userDAO.save(user);

		assertEquals(id, userDAO.findUserByName("Test8").getId());
	}

}
