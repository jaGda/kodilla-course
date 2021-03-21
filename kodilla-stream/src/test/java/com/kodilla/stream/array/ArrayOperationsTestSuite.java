package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {

        //Given
        Exception exception = assertThrows(NoSuchElementException.class,
                () -> ArrayOperations.getAverage(new int[0]));
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //When
        double result = ArrayOperations.getAverage(ints);

        //Then
        assertEquals(5.5, result);
        assertEquals("No value present", exception.getMessage());

    }

}