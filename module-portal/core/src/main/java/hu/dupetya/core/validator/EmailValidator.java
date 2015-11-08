package hu.dupetya.core.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import hu.dupetya.common.validator.Validator;
import hu.dupetya.common.validator.ViolationException;

@Service("emailValidator")
public class EmailValidator implements Validator<String> {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public void validate(String object) throws ViolationException {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(object);

		if (!matcher.matches()) {
			throw new ViolationException("Email is not valid");
		}
	}

}
