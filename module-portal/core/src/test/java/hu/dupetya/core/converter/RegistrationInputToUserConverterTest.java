package hu.dupetya.core.converter;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.dupetya.common.converter.ConversionException;
import hu.dupetya.common.converter.Converter;
import hu.dupetya.common.entity.UserEntity;
import hu.dupetya.common.model.RegistrationInput;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-core-test.xml")
public class RegistrationInputToUserConverterTest {

	@Autowired
	Converter<RegistrationInput, UserEntity> registrationInputToUserConverter;

	@Test
	public void testConvert() throws ConversionException {
		RegistrationInput input = new RegistrationInput("testUN", "123", "123", "adsads@asdas.ccc", "1990-01-01");
		UserEntity user = registrationInputToUserConverter.convert(input);

		assertNotNull(user);
		assertEquals("testUN", user.getUsername());
		assertNotEquals("123", user.getPassword());
	}

}
