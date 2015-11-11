package hu.dupetya.core.validator;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.dupetya.common.dao.DAOException;
import hu.dupetya.common.dao.UserDAO;
import hu.dupetya.common.entity.UserEntity;
import hu.dupetya.common.model.RegistrationInput;
import hu.dupetya.common.validator.Validator;
import hu.dupetya.common.validator.ViolationException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-core-test.xml" })
public class RegistrationInputValidatorTest {

	@Autowired
	UserDAO userDAO;

	@Autowired
	private Validator<RegistrationInput> registrationInputValidator;

	@Test
	public void testValid() {
		RegistrationInput regInput = new RegistrationInput("Dudash", "asd", "asd", "dupetya@gmail.com", "1992-09-19");

		try {
			registrationInputValidator.validate(regInput);
		} catch (ViolationException e) {
			fail();
		}
	}

	@Test(expected = ViolationException.class)
	public void testUsernameAlreadyTaken() throws ViolationException, DAOException {
		RegistrationInput regInput = new RegistrationInput("TestAcc1", "testpass", "testpass", "test@testing.com",
				"1999-01-01");
		userDAO.save(new UserEntity(1L, "TestAcc1", "", "fff@aaaa.ccc", new Date(), new ArrayList<>()));
		registrationInputValidator.validate(regInput);
	}

	@Test(expected = ViolationException.class)
	public void testPasswordMismatch() throws ViolationException {
		RegistrationInput regInput = new RegistrationInput("TestPM", "12345", "12354", "test@test.com", "1991-09-19");

		registrationInputValidator.validate(regInput);
	}

	@Test(expected = ViolationException.class)
	public void testInvlaidEmail() throws ViolationException {
		RegistrationInput regInput = new RegistrationInput("TestPM", "12345", "12354", "test@.com", "1991-09-19");

		registrationInputValidator.validate(regInput);
	}

}
