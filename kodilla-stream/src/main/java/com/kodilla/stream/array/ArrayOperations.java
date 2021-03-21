package com.kodilla.stream.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        System.out.println(Arrays.toString(numbers));
        IntStream.range(0, numbers.length)
                .forEach(i -> System.out.println(numbers[i]));
        return IntStream.of(numbers).average().orElseThrow();
    }
}
