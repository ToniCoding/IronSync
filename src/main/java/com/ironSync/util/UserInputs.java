package main.java.com.ironSync.util;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class UserInputs {
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
}
