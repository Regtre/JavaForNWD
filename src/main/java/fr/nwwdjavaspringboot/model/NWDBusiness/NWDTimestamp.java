package fr.nwwdjavaspringboot.model.NWDBusiness;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class NWDTimestamp {


    public static int ToTimestampUnix(LocalDateTime sDateTime) {
        return (int) sDateTime.toEpochSecond(ZoneOffset.UTC);
    }

}
