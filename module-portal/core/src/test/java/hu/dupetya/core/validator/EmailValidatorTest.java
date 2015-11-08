package hu.dupetya.core.validator;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.dupetya.common.validator.Validator;
import hu.dupetya.common.validator.ViolationException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring-core.xml", "/spring-core-test.xml" })
public class EmailValidatorTest {

	private static Logger logger = LoggerFactory.getLogger(EmailValidatorTest.class);

	private static final String VALID_EMAIL = "dudee@asd.co.uk";
	private static final String INVALID_EMAIL = "dudaa@.in";

	@Autowired
	private Validator<String> emailValidator;

	@Test
	public void testValidValidate() {
		try {
			logger.info("Validating :" + VALID_EMAIL);
			emailValidator.validate(VALID_EMAIL);
		} catch (ViolationException e) {
			fail("Should have been valid");
		}
	}

	@Test(expected = ViolationException.class)
	public void testInvalidValidate() throws ViolationException {
		logger.info("Validating :" + INVALID_EMAIL);
		emailValidator.validate(INVALID_EMAIL);
	}

}
