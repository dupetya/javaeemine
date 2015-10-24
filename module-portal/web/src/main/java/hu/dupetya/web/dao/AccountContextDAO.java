package hu.dupetya.web.dao;

import java.util.List;

import javax.servlet.ServletContext;

import hu.dupetya.common.account.dao.AccountDAO;
import hu.dupetya.common.account.dao.DataAccessException;
import hu.dupetya.common.account.model.Account;

public class AccountContextDAO implements AccountDAO {

	private List<Account> accounts;

	@SuppressWarnings("unchecked")
	public AccountContextDAO(ServletContext servletContext) {
		accounts = (List<Account>) servletContext.getAttribute("users");
	}

	@Override
	public Long save(Account account) throws DataAccessException {
		account.setId(accounts.size());
		accounts.add(account);
		return account.getId();
	}

	@Override
	public List<Account> findAll() {
		return accounts;
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
