package hu.dupetya.core.account.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import hu.dupetya.common.account.dao.AccountDAO;
import hu.dupetya.common.account.dao.DAOManager;
import hu.dupetya.common.account.dao.DAOManagerException;
import hu.dupetya.core.account.dao.impl.AccountMySQLDAOImpl;
import hu.dupetya.core.connection.Datasource;

public class MySQLDAOManager implements DAOManager {
	private Datasource datasource;
	private Connection connection;

	public MySQLDAOManager() throws DAOManagerException {
		try {
			datasource = Datasource.getInstance();
		} catch (PropertyVetoException e) {
			throw new DAOManagerException(e);
		}
	}

	@Override
	public AccountDAO getDao() {
		return new AccountMySQLDAOImpl(connection);
	}

	public void open() throws DAOManagerException {
		try {
			if (connection == null || connection.isClosed()) {
				connection = datasource.getConnection();
			}
		} catch (Exception e) {
			throw new DAOManagerException(e);
		}
	}

	@Override
	public void close() throws DAOManagerException {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new DAOManagerException(e);
		}
	}
}
