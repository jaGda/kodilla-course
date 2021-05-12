package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTestSuite {

    private static final Logger logger1 = Logger.SINGLETON;
    private static final Logger logger2 = Logger.SINGLETON;

    @Test
    public void testGetLastLog_1() {
        //Given
        //When
        logger1.log("log123");
        //Then
        assertAll(
                () -> assertEquals("log123", logger1.getLastLog()),
                () -> assertEquals("log123", logger2.getLastLog())
        );

        //When
        logger1.log("log233");
        //Then
        assertEquals("log233", logger1.getLastLog());

        //When
        logger1.log("log400");
        //Then
        assertAll(
                () -> assertEquals("log400", logger1.getLastLog()),
                () -> assertEquals("log400", logger2.getLastLog())
        );
    }
}