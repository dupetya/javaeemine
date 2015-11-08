package hu.dupetya.core.validator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.dupetya.common.model.RegistrationInput;
import hu.dupetya.common.validator.Validator;
import hu.dupetya.common.validator.ViolationException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-core.xml", "/spring-core-test.xml" })
public class RegistrationInputValidatorTest {

	@Autowired
	private Validator<RegistrationInput> registrationInputValidator;

	@Test
	public void testValidate() {
		RegistrationInput regInput = new RegistrationInput("Dudash", "asd", "asd", "dupetya@gmail.com", "1992-09-19");

		try {
			registrationInputValidator.validate(regInput);
		} catch (ViolationException e) {
			fail();
		}
	}

}
