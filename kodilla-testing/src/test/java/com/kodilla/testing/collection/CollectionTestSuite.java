package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Collection Test Suite")
class CollectionTestSuite {

    @BeforeEach
    void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    void after() {
        System.out.println("Test Case: end\n");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Test Suite: begin\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("When empty list is given, " +
            "then empty list should be returned")
    @Test
    void testOddNumbersExterminatorEmptyList() {
        //Given
        List<Integer> emptyList = Collections.emptyList();
        //When
        int result = OddNumbersExterminator.exterminate(emptyList).size();
        int expectedResult = 0;
        //Then
        assertEquals(expectedResult, result);
    }

    @DisplayName("When list is given, " +
            "then method should only returned list with odd numbers")
    @Test
    void testOddNumbersExterminatorNormalList() {
        //Given
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10);
        List<Integer> evens = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> odds = Arrays.asList(0, 2, 4, 6, 8, 10);
        //When
        int result1 = OddNumbersExterminator.exterminate(list).size();
        int result2 = OddNumbersExterminator.exterminate(list).size();
        int result3 = OddNumbersExterminator.exterminate(list).size();
        //Then
        assertAll(
                () -> assertEquals(6, result1),
                () -> assertEquals(evens.size(), result2),
                () -> assertEquals(odds.size(), result3)
        );
    }
}