package fr.nwwdjavaspringboot.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

import com.google.common.base.Strings;
import fr.nwwdjavaspringboot.model.NWDSecurityAesTypeEnum;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


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

    public static String CryptAes(String sText, String sKey, String sVector, NWDSecurityAesTypeEnum sAes) throws UnsupportedEncodingException, ArgumentNullException {

        String rParamB64 = "";

        if (sText != null && !sText.isEmpty()) {
            // Set AES bits size

            int tAesSize = 128;
            String tKey = KeyLengthFix(sKey, 24);
            String tVector = KeyLengthFix(sVector, 16);
            // Encrypt the String to an array of bytes.
            byte[] tEncrypted = new byte[0];

            try {
                tEncrypted = InternalCryptAes(sText, tKey.getBytes(), tVector.getBytes(), tAesSize);
            } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | NoSuchPaddingException |
                     NoSuchAlgorithmException | InvalidAlgorithmParameterException | IOException |
                     NoSuchProviderException e) {
                throw new RuntimeException(e);
            }

            rParamB64 = Base64.getEncoder().encodeToString(tEncrypted);
        }
        // Encode parameters
        return rParamB64;

    }

    public static String CryptAes(String sText, String sKey, String sVector) throws UnsupportedEncodingException, ArgumentNullException {
        return CryptAes(sText, sKey, sVector, NWDSecurityAesTypeEnum.Aes128);
    }

    private static String KeyLengthFix(String sKey, int sSize) {
        StringBuilder rReturn;
        if (Strings.isNullOrEmpty(sKey)) {
            sKey = "";
        }

        if (sKey.length() == sSize) {
            rReturn = new StringBuilder(sKey);
        } else if (sKey.length() > sSize) {
            rReturn = new StringBuilder(sKey.substring(0, sSize));
        } else {
            rReturn = new StringBuilder(sKey);
            while (rReturn.length() < sSize) {
                rReturn.append("A");
            }
        }

        return rReturn.toString();
    }

    private static byte[] InternalCryptAes(String sPlainText, byte[] sKey, byte[] sIv, int sAesSize) throws ArgumentNullException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, IOException, NoSuchProviderException {
        // Check arguments.
        if (sPlainText == null || sPlainText.isEmpty()) {
            throw new ArgumentNullException("sPlainText null");
        }

        if (sKey == null || sKey.length == 0) {
            throw new ArgumentNullException("sKey null");
        }

        if (sIv == null || sIv.length == 0) {
            throw new ArgumentNullException("sIv null");
        }

        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        // Create an AES cipher object
        Cipher tAes = Cipher.getInstance("AES/ECB/PKCS7Padding","BC");

        // Set the key and IV
        SecretKeySpec keySpec = new SecretKeySpec(sKey, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(sIv);
        tAes.init(Cipher.ENCRYPT_MODE, keySpec);

        // Create a ByteArrayOutputStream to store the encrypted data
        ByteArrayOutputStream tBaosEncrypt = new ByteArrayOutputStream();

        // Create an OutputStreamWriter to write the encrypted data to the ByteArrayOutputStream
        OutputStreamWriter tOswEncrypt = new OutputStreamWriter(tBaosEncrypt);

        // Write the plaintext to the OutputStreamWriter
        tOswEncrypt.write(sPlainText);

        // Flush and close the OutputStreamWriter
        tOswEncrypt.flush();
        tOswEncrypt.close();

        // Get the encrypted data from the ByteArrayOutputStream
        byte[] rEncrypted = tBaosEncrypt.toByteArray();

        return rEncrypted;
    }

}
