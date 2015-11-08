package hu.dupetya.common.cipher;

public interface CipherService {
  String encrypt(String unencrypted) throws EncryptionException;
}
