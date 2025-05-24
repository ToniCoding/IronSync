package main.java.com.ironSync.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberUtils {
    public List<Integer> generateNumbersUntilLimit(int finalNumberLimit){
        return IntStream.rangeClosed(1, finalNumberLimit)
                .boxed()
                .collect(Collectors.toList());
    }
}
