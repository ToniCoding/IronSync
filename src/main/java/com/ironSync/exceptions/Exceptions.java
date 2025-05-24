package main.java.com.ironSync.exceptions;

/**
 * Container class for custom exceptions used in the application.
 */
public class Exceptions {

    /**
     * Exception thrown when an invalid option is provided by the user.
     * Extends {@link IllegalArgumentException} as it indicates an illegal argument.
     */
    public static class InvalidOptionException extends IllegalArgumentException {

        /**
         * Constructs a new InvalidOptionException with the specified detail message.
         *
         * @param message The detail message explaining the reason for the exception.
         */
        public InvalidOptionException(String message) {
            super(message);
        }
    }
}
