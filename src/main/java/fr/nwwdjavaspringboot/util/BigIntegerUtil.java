package fr.nwwdjavaspringboot.util;

import java.math.BigInteger;
import java.util.List;

public class BigIntegerUtil {

    public static BigInteger incrementTheBiggerValueInTheList(List<BigInteger> list){
        BigInteger max = BigInteger.ZERO ;
        for (BigInteger b :
                list) {
            if(max.compareTo(b) == -1) max = b;
        }

        max = max.add(BigInteger.ONE);
        return max;
    }
}
