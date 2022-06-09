package br.com.training.school.domain.student;

public interface PasswordCipher {
    String encryptPassword(String password);
    boolean validatePassword(String password, String passwordencrypted);

}
