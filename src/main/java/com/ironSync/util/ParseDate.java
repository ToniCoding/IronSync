package main.java.com.ironSync.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParseDate {
    private final LocalDateTime dateTime = LocalDateTime.now();
    private DateTimeFormatter dateTimeFormatter;

    public String getCurrentDate() {
        return dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getCurrentTime() {
        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getCurrentDateTimeFormatted(int formatRequested) {
        return switch (formatRequested) {
            case 1 -> getCurrentDate() + " " + getCurrentTime();
            case 2 -> getCurrentTime() + " " + getCurrentDate();
            default -> throw new IllegalArgumentException("Invalid format option: " + formatRequested);
        };
    }
}
