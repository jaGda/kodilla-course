package com.kodilla.exception.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondChallengeTestsUITE {

    @Test
    @DisplayName("When input is out of boundary condition method should throw" +
            "Exception, otherwise should return \"Done!\"")
    void testBoundaryConditions() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        Exception firstConditionIsTruForUpperBound = assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 4));
        Exception firstConditionIsTrueForBottomBound = assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 1));
        Exception secondConditionIsTrue = assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.2, 1.5));

        //When & Then
        assertAll(
                () -> assertEquals("Incorrect value of input parameters ...", firstConditionIsTruForUpperBound.getMessage()),
                () -> assertEquals("Incorrect value of input parameters ...", firstConditionIsTrueForBottomBound.getMessage()),
                () -> assertEquals("Incorrect value of input parameters ...", secondConditionIsTrue.getMessage()),
                () -> assertEquals("Done!", secondChallenge.probablyIWillThrowException(1, 2)),
                () -> assertEquals("Done!", secondChallenge.probablyIWillThrowException(1.99, 1)),
                () -> assertEquals("Done!", secondChallenge.probablyIWillThrowException(1.5, 1.49))
        );
    }
}