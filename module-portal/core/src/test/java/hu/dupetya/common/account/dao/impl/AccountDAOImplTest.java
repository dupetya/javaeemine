package hu.dupetya.common.account.dao.impl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import hu.dupetya.common.account.dao.DataAccessException;
import hu.dupetya.common.account.model.Account;

public class AccountDAOImplTest {
	private static Connection conn;
	private static final String URL = "jdbc:mysql://localhost:3306/portaldb";
	private static final String USER = "root";
	private static final String PASS = "mysql";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		conn = DriverManager.getConnection(URL, USER, PASS);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		try {
			conn.close();
		} catch (Exception e) {
		}
	}

	@Test
	public void testSave() {
		Account acc = new Account();
		acc.setUsername("dudee");
		acc.setEmail("dupetya@gmail.com");
		acc.setEncryptedPassword("asdsfasfrgsjdsnfls");

		AccountDAOImpl dao = new AccountDAOImpl(conn);
		try {
			dao.save(acc);
		} catch (DataAccessException e) {
			fail("Shouldn't have failed");
		}
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

}
