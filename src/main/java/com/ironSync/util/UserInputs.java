package main.java.com.ironSync.util;

import main.java.com.ironSync.exceptions.Exceptions;

import java.util.List;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.Scanner;

public class UserInputs {
    private final Scanner scanner = new Scanner(System.in);
    private final NumberUtils numberUtils = new NumberUtils();

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

    public String promptText(String promptMessage) {
        while (true) {
            System.out.print(promptMessage + " ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (!input.isEmpty()) return input;

            System.out.println("Text cannot be empty, try again.");
        }
    }

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

    public String promptTextWithOptions(String questionToUser, String availableOptions) {
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

        return userVisibleOptions.toString();
    }

    public boolean processUserInputFromTwoOptions(String validOptions, String userInput) {
        List<String> validOptionsList = Arrays.stream(validOptions.split(","))
                .map(String::trim)
                .toList();

        if (validOptionsList.isEmpty()) {
            throw new Exceptions.InvalidOptionException("There were given more than two valid options.");
        }

        if (!validOptionsList.contains(userInput)) {
            throw new Exceptions.InvalidOptionException("The user input is not between the valid options.");
        } else {
            return Objects.equals(userInput, validOptionsList.get(0));
        }
    }
}
