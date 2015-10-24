package hu.schonherz.training.java.solid.account.impl;

import org.apache.commons.lang3.Validate;

import hu.dupetya.common.account.dao.AccountDAO;
import hu.dupetya.common.account.dao.DataAccessException;
import hu.dupetya.common.account.model.Account;
import hu.dupetya.web.account.AccountRegistrationException;
import hu.dupetya.web.account.AccountRegistrationRequest;
import hu.dupetya.web.account.AccountService;
import hu.schonherz.training.java.solid.converter.ConversionException;
import hu.schonherz.training.java.solid.converter.Converter;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO;
	private Converter<AccountRegistrationRequest, Account> converter;

	public AccountServiceImpl(AccountDAO accountDAO, Converter<AccountRegistrationRequest, Account> converter) {
		Validate.notNull(accountDAO);
		Validate.notNull(converter);

		this.accountDAO = accountDAO;
		this.converter = converter;
	}

	@Override
	public Account register(AccountRegistrationRequest request) throws AccountRegistrationException {
		try {
			Validate.notNull(request, "Registration request cannot be null");
			Account account = converter.convert(request);
			accountDAO.save(account);
			return account;
		} catch (DataAccessException | ConversionException e) {
			throw new AccountRegistrationException("Could not register user", e);
		}
	}

}
