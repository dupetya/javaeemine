package hu.dupetya.core.security.cipher;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.dupetya.common.cipher.CipherService;
import hu.dupetya.common.cipher.EncryptionException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-core.xml")
public class DefaultCipherServiceTest {

	private static Logger logger = LoggerFactory.getLogger(DefaultCipherServiceTest.class);

	@Autowired
	CipherService cipherService;

	@Test
	public void testEncrypt() throws EncryptionException {
		assertNotNull(cipherService);

		String raw = "Some Text";
		logger.info(String.format("RAW: %s", raw));
		String got = cipherService.encrypt(raw);
		logger.info(String.format("ENC: %s", got));

		assertNotEquals(raw, got);

	}

}
