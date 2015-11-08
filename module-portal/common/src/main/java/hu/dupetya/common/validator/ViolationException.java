package hu.dupetya.common.validator;

public class ViolationException extends Exception {

	private static final long serialVersionUID = -5540677736186915216L;

	public ViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ViolationException(String message) {
		super(message);
	}

	public ViolationException(Throwable cause) {
		super(cause);
	}

}
