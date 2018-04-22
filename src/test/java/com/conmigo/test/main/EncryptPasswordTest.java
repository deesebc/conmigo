package com.conmigo.test.main;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Descripcion de clase
 *
 * @author dsbc
 * @version 1.0
 * @created: 16 sept. 2016
 */
public class EncryptPasswordTest {

    public static void main(final String... args) {
        try {
            // String password = generatePassword();
            String password = "usuarioPrueba1";
            System.out.println("password: " + password);
            String encrypt = encryptPassword(password);
            System.out.println("encrypt: " + encrypt);
            System.out.println("19#84#8->" + encryptPassword("19#84#8"));
            System.out.println("19#84#8->" + encryptPassword("19#84#8"));
        } catch (Exception except) {
            except.printStackTrace();
        }
    }

    private static String generatePassword() {
        return RandomStringUtils.randomAlphanumeric(17);
    }

    private static String encryptPassword(final String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
