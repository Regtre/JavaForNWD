package fr.nwwdjavaspringboot.model.NWD.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class NWDTimestamp {
    public static int toTimestampUnix(LocalDateTime sDateTime) {
        return (int) sDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    public static long toTimestamp(LocalDateTime sDateTime) {
        return sDateTime.toEpochSecond(ZoneOffset.UTC);
    }

    public static int getTimestampUnix() {
        return (int) Instant.now().getEpochSecond();
    }

    public static LocalDateTime timestampUnixToDatetime(int sTimeStamp) {
        return LocalDateTime.ofEpochSecond(sTimeStamp, 0, ZoneOffset.UTC);
    }
}
