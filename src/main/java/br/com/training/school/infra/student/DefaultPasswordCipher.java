package br.com.training.school.infra.student;

import br.com.training.school.domain.student.PasswordCipher;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DefaultPasswordCipher implements PasswordCipher {
    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes(), 0, password.length());
            return new BigInteger(1,messageDigest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean validatePassword(String password, String passwordEncrypted) {
        return passwordEncrypted.equals(encryptPassword(password));
    }
}
