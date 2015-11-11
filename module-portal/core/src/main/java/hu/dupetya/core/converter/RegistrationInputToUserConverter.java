package hu.dupetya.core.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.dupetya.common.cipher.CipherService;
import hu.dupetya.common.cipher.EncryptionException;
import hu.dupetya.common.converter.ConversionException;
import hu.dupetya.common.converter.Converter;
import hu.dupetya.common.entity.UserEntity;
import hu.dupetya.common.model.RegistrationInput;

@Service("registrationInputToUserConverter")
public class RegistrationInputToUserConverter implements Converter<RegistrationInput, UserEntity> {

	@Autowired
	CipherService cipherService;

	@Override
	public UserEntity convert(RegistrationInput source) throws ConversionException {
		try {
			return new UserEntity(null, source.getUsername(), cipherService.encrypt(source.getPassword()),
					source.getEmail(), new SimpleDateFormat("yyyy-MM-dd").parse(source.getDateOfBirth()), null);
		} catch (ParseException | EncryptionException e) {
			throw new ConversionException("Could not convert to user", e);
		}

	}

}
