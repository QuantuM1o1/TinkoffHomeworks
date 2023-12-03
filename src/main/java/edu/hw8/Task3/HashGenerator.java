package edu.hw8.Task3;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
    private HashGenerator() {
    }

    public static String generateMD5Hash(String input) {
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] out = messageDigest.digest(bytes);
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : out) {
            stringBuilder.append(Integer.toHexString(b));
        }
        return stringBuilder.toString();
    }
}
