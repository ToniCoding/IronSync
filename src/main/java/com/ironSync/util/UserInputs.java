package com.ironSync.util;

import com.ironSync.exceptions.Exceptions;

import java.util.List;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Scanner;

/**
 * Utility class to handle user input from the console,
 * including parsing, validation, and prompt display.
 */
public class UserInputs {
    private final Scanner scanner = new Scanner(System.in);
    private final NumberUtils numberUtils = new NumberUtils();

    /**
     * Converts a string of repetitions separated by commas or spaces into a list of positive integers.
     *
     * @param repetitionsList A string containing repetitions separated by commas or whitespace.
     * @return A list of positive integers representing the repetitions.
     * @throws IllegalArgumentException if the input contains invalid number formats.
     */
    public List<Integer> repetitionsStringToIntegerList(String repetitionsList) {
        if (repetitionsList == null || repetitionsList.isBlank()) {
            return List.of();
        }

        try {
            return Arrays.stream(repetitionsList.trim().replace(",", " ").split("\\s+"))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .filter(i -> i > 0)
                    .collect(Collectors.toList());
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("You have to introduce only numbers for repetitions.");
        }
    }

    /**
     * Prompts the user for text input, requiring a non-empty string.
     * The input is trimmed and converted to lowercase.
     *
     * @param promptMessage The message displayed to the user.
     * @return A non-empty, trimmed, lowercase string input from the user.
     */
    public String promptText(String promptMessage) {
        while (true) {
            System.out.print(promptMessage + " ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (!input.isEmpty()) return input;

            System.out.println("Text cannot be empty, try again.");
        }
    }

    /**
     * Prompts the user for a positive integer input.
     * Keeps prompting until a valid positive integer is entered.
     *
     * @param promptMessage The message displayed to the user.
     * @return A positive integer input from the user.
     */
    public int promptInt(String promptMessage) {
        while (true) {
            System.out.print(promptMessage + " ");
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) return value;
                System.out.println("Number must be higher than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Introduce a valid number.");
            }
        }
    }

    /**
     * Displays a question with enumerated options and returns the formatted string for display.
     *
     * @param questionToUser The question to be displayed before the options.
     * @param availableOptions A comma-separated string of available options.
     */
    public void promptTextWithOptions(String questionToUser, String availableOptions) {
        List<String> availableOptionsArray = Arrays.stream(availableOptions.split(","))
                .map(String::trim)
                .toList();

        List<Integer> optionsNumerals = numberUtils.generateNumbersUntilLimit(availableOptionsArray.size());
        StringBuilder userVisibleOptions = new StringBuilder(questionToUser).append("\n");

        for (int i = 0; i < availableOptionsArray.size(); i++) {
            userVisibleOptions.append(optionsNumerals.get(i))
                    .append(". ")
                    .append(availableOptionsArray.get(i))
                    .append("\n");
        }

        System.out.println(userVisibleOptions);
    }

    /**
     * Validates the user input against a list of two valid options.
     * Returns true if the input matches the first option, false if it matches the second.
     *
     * @param validOptions A comma-separated string containing exactly two valid options.
     * @param userInput The user's input to validate.
     * @return True if userInput equals the first valid option; false otherwise.
     * @throws Exceptions.InvalidOptionException if userInput is not one of the valid options,
     *                               or if more than two options are provided.
     */
    public boolean processUserInputFromTwoOptions(String validOptions, String userInput) {
        List<String> validOptionsList = Arrays.stream(validOptions.split(","))
                .map(String::trim)
                .toList();

        if (validOptionsList.size() != 2) {
            throw new Exceptions.InvalidOptionException("There were given more than two valid options.");
        }

        if (!validOptionsList.contains(userInput)) {
            throw new Exceptions.InvalidOptionException("The user input is not between the valid options.");
        } else {
            return Objects.equals(userInput, validOptionsList.getFirst());
        }
    }

    public String removeIntermediateWhitespaceCharacters(String stringToProcess) {
        StringBuilder result = new StringBuilder();
        boolean lastCharWasSpace = false;

        for (int i = 0; i < stringToProcess.length(); i++) {
            char c = stringToProcess.charAt(i);
            if (c == ' ') {
                if (!lastCharWasSpace) {
                    result.append(c);
                    lastCharWasSpace = true;
                }
            } else {
                result.append(c);
                lastCharWasSpace = false;
            }
        }

        return result.toString().replace(" ", "_");
    }
}
