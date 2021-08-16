package com.test.webapp.sessions;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class SecureUtils {

    public static byte[] getSalt(String password) {
        SecureRandom random = new SecureRandom();
        int length;
        if (password.length() == 0) {
            length = 4;
        } else length = password.length();
        byte[] salt = new byte[length];
        random.nextBytes(salt);
        return salt;
    }

    public static byte[] getHash(String password, byte[] salt) {
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
