package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {
        //Given
        //When
        double addResult = calculator.add(2.5, 2);
        double subResult = calculator.sub(2, 2.5);
        double mulResult = calculator.mul(2.5, 2);
        double divResult = calculator.div(2.5, 2);

        //Then
        assertAll(
                () -> assertEquals(4.5, addResult),
                () -> assertEquals(-0.5, subResult),
                () -> assertEquals(5, mulResult),
                () -> assertEquals(1.25, divResult)
        );
    }
}