package hu.dupetya.common.model;

public class RegistrationInput {
	private String username;
	private String password;
	private String passwordAgain;
	private String email;
	private String dateOfBirth;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegistrationInput [username=").append(username).append(", password=").append(password)
				.append(", passwordAgain=").append(passwordAgain).append(", email=").append(email)
				.append(", dateOfBirth=").append(dateOfBirth).append("]");
		return builder.toString();
	}

	public RegistrationInput() {
	}

	public RegistrationInput(String username, String password, String passwordAgain, String email, String dateOfBirth) {
		super();
		this.username = username;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public String getEmail() {
		return email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
