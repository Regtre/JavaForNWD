package fr.nwwdjavaspringboot.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NWDSecurityTools {

    public static String GenerateSha(String sPlainText) {
        byte[] tData = sPlainText.getBytes(StandardCharsets.US_ASCII);
        try {

                MessageDigest tShaManager = MessageDigest.getInstance("SHA-1");
                byte[] tHash = tShaManager.digest(tData);
                StringBuilder tHashedInputStringBuilder = new StringBuilder();
                for (byte b : tHash) {
                    tHashedInputStringBuilder.append(String.format("%02x", b));
                }
                return tHashedInputStringBuilder.toString().replace("-", "").toLowerCase();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
