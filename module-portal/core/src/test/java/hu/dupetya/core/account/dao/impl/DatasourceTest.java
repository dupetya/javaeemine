package hu.dupetya.core.account.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import hu.dupetya.core.connection.Datasource;

public class DatasourceTest {
	Datasource ds;

	@Test
	public void testGetInstance() {
		try {
			ds = Datasource.getInstance();
		} catch (PropertyVetoException e) {
			fail("Shouldn't have thrown exception");
		}

		assertNotNull(ds);
	}

	@Test
	public void testGetConnection() {
		try {
			ds = Datasource.getInstance();
			Connection conn = ds.getConnection();
			assertNotNull(conn);
			conn.close();
		} catch (PropertyVetoException | SQLException e) {
			fail("Shouldn't have thrown exception");
		}
	}

}
