package hu.dupetya.core.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.dupetya.common.model.RegistrationInput;
import hu.dupetya.common.repository.UserRepository;
import hu.dupetya.common.validator.Validator;
import hu.dupetya.common.validator.ViolationException;

@Service("registrationInputValidator")
public class RegistrationInputValidator implements Validator<RegistrationInput> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailValidator emailValidator;

	@Override
	public void validate(RegistrationInput input) throws ViolationException {

		if (userRepository.findByUsername(input.getUsername()) != null) {
			throw new ViolationException("User already exists");
		}

		if (!input.getPassword().equals(input.getPasswordAgain())) {
			throw new ViolationException("Password does not match");
		}

		emailValidator.validate(input.getEmail());

		// TODO
		// VALIDATE DATE OF BIRTH

	}

}
