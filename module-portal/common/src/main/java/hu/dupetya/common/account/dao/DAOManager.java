package hu.dupetya.common.account.dao;

public interface DAOManager extends AutoCloseable {
	public AccountDAO getDao();
}
