package hu.dupetya.common.account.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hu.dupetya.common.account.dao.AccountDAO;
import hu.dupetya.common.account.dao.DataAccessException;
import hu.dupetya.common.account.model.Account;

public class AccountDAOImpl implements AccountDAO {
	private Connection connection;

	public AccountDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public Long save(Account account) throws DataAccessException {

		Long res = null;
		PreparedStatement query = null;
		ResultSet rs = null;

		try {
			String sql = "INSERT INTO users(username, pass, email) VALUES (?, ?, ?)";
			query = connection.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

			query.setString(1, account.getUsername());
			query.setString(2, account.getEncryptedPassword());
			query.setString(3, account.getEmail());

			query.executeUpdate();

			rs = query.getGeneratedKeys();

			if (rs.next()) {
				res = rs.getLong(1);
			}

		} catch (SQLException e) {
			throw new DataAccessException("Error while saving account");
		} finally {
			try {
				query.close();
			} catch (Exception e2) {
			}
			try {
				rs.close();
			} catch (Exception e2) {
			}

		}

		return res;
	}

	@Override
	public Account find(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Account account) throws DataAccessException {
		PreparedStatement query = null;

		try {
			String sql = "UPDATE users SET username=?, pass=?, email=? where id=?";
			query = connection.prepareStatement(sql);

			query.setString(1, account.getUsername());
			query.setString(2, account.getEncryptedPassword());
			query.setString(3, account.getEmail());
			query.setLong(4, account.getId());

			query.executeUpdate();
		} catch (SQLException e) {

		} finally {
			try {
				query.close();
			} catch (Exception e2) {
			}
		}

	}

	@Override
	public void delete(Long id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
