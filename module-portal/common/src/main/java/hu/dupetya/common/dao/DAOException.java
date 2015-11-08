package hu.dupetya.common.dao;

public class DAOException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 2098370556230154372L;

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

}
