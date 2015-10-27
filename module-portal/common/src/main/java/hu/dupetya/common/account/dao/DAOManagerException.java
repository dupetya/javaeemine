package hu.dupetya.common.account.dao;

public class DAOManagerException extends Exception {

	private static final long serialVersionUID = -381950761464563206L;

	public DAOManagerException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DAOManagerException(String arg0) {
		super(arg0);
	}

	public DAOManagerException(Throwable arg0) {
		super(arg0);
	}

}
