package hu.schonherz.training.java.solid.dao.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.Validate;

import hu.dupetya.common.account.dao.AccountDAO;
import hu.dupetya.common.account.dao.DataAccessException;
import hu.dupetya.common.account.model.Account;

public class AccountDAOImpl implements AccountDAO {
	private String dbFile;

	public AccountDAOImpl(String dbFile) {
		Validate.notBlank(dbFile);
		this.dbFile = dbFile;
	}

	@Override
	public Long save(Account account) throws DataAccessException {
		try (FileWriter writer = new FileWriter(dbFile, true)) {
			writer.append(account.getUsername()).append(',').append(account.getEmail()).append(',')
					.append(account.getEncryptedPassword()).append('\n');
		} catch (IOException e) {
			throw new DataAccessException("Unable to save account", e);
		}
		return 1L;
	}

	@Override
	public List<Account> findAll() {
		// TODO LOL
		return null;
	}

	@Override
	public Account find(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Account dto) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

}
