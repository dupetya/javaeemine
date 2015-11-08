package hu.dupetya.core.security.cipher;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import hu.dupetya.common.cipher.CipherService;
import hu.dupetya.common.cipher.EncryptionException;

@Service("cipherService")
public class DefaultCipherService implements CipherService {

	@Override
	public String encrypt(String unencrypted) throws EncryptionException {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(unencrypted);
	}

}
