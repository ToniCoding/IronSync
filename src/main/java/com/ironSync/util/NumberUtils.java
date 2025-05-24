package main.java.com.ironSync.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Utility class for number-related helper methods.
 */
public class NumberUtils {

    /**
     * Generates a list of integers starting from 1 up to and including the specified limit.
     *
     * @param finalNumberLimit The upper bound of the numbers to generate (inclusive).
     * @return A {@link List} of integers from 1 to finalNumberLimit.
     */
    public List<Integer> generateNumbersUntilLimit(int finalNumberLimit) {
        return IntStream.rangeClosed(1, finalNumberLimit)
                .boxed()
                .collect(Collectors.toList());
    }
}
