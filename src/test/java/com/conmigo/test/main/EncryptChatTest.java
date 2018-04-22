package com.conmigo.test.main;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptChatTest {

    public static void main(final String[] args) throws UnsupportedEncodingException {
        try {
            String text = "19#05#45";
            String key = "Bar12345Bar12345"; // 128 bit key
            // Create key and cipher
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            System.err.println(new String(encrypted));
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            String decrypted = new String(cipher.doFinal(encrypted));
            System.err.println(decrypted);
        } catch (Exception except) {
            except.printStackTrace();
        }

        System.out.println(metodo("19#05#45"));
    }

    private static String metodo(final String cadena) throws UnsupportedEncodingException {
        int hashcode = cadena.hashCode();
        System.out.println("hashcode: " + hashcode);
        byte[] bytes = BigInteger.valueOf(hashcode).toByteArray();

        return new String(bytes, "UTF-8");
    }
}
