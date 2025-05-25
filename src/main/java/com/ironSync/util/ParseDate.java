package main.java.com.ironSync.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for parsing and formatting current date and time.
 */
public class ParseDate {
    private final LocalDateTime dateTime = LocalDateTime.now();
    private DateTimeFormatter dateTimeFormatter;

    /**
     * Returns the current date formatted as "dd-MM-yyyy".
     *
     * @return A string representing the current date.
     */
    public String getCurrentDate() {
        return dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    /**
     * Returns the current time formatted as "HH:mm:ss".
     *
     * @return A string representing the current time.
     */
    public String getCurrentTime() {
        return dateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    /**
     * Returns the current date and time formatted based on the requested format.
     *
     * @param formatRequested An integer indicating the desired format:
     *                        1 - "dd-MM-yyyy HH:mm:ss"
     *                        2 - "HH:mm:ss dd-MM-yyyy"
     * @return A string representing the formatted current date and time.
     * @throws IllegalArgumentException if the formatRequested is invalid.
     */
    public String getCurrentDateTimeFormatted(int formatRequested) {
        return switch (formatRequested) {
            case 1 -> getCurrentDate() + " " + getCurrentTime();
            case 2 -> getCurrentTime() + " " + getCurrentDate();
            default -> throw new IllegalArgumentException("Invalid format option: " + formatRequested);
        };
    }
}
