package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHandler {
    public static String createCrypticPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(userPassword.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuffer hexString = new StringBuffer();
        for (int index=0; index<digest.length; index++){
            hexString.append(Integer.toHexString(0xFF & digest[index]));
        }
        System.out.println("Your cryptic password is "+hexString.toString());
        return hexString.toString();
    }
}
