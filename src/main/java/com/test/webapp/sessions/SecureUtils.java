package com.test.webapp.sessions;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class SecureUtils {

    public static byte[] getHash(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[password.length()];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        SecretKeyFactory factory = null;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hash = new byte[0];
        try {
            if (factory != null) {
                hash = factory.generateSecret(spec).getEncoded();
            }
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return hash;
    }

}
