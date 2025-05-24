package main.java.com.ironSync.exceptions;

public class Exceptions {
    public static class InvalidOptionException extends IllegalArgumentException {
        public InvalidOptionException (String message) {
            super(message);
        }
    }
}
