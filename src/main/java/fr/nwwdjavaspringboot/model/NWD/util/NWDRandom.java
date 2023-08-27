package fr.nwwdjavaspringboot.model.NWD.util;

import java.util.Random;

public class NWDRandom {

    public static String RandomStringCypher(int sLength) {
        StringBuilder rReturn = new StringBuilder();
        String cChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                //"()[]{}" +
                //"+=_" +
                //"#$%&" +
                //"<^>" +
                //".!?:;" +
                "0123456789" +
                "";
        int tCharLength = cChars.length();
        //Random r = new Random();
        while (rReturn.length() < sLength) {
            rReturn.append(cChars.charAt(new Random().nextInt(tCharLength)));
        }
        return rReturn.toString();
    }
}
