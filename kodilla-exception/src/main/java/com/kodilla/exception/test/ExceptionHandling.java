package com.kodilla.exception.test;

import java.time.LocalDate;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            secondChallenge.probablyIWillThrowException(2, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(
                    "Today is - " + LocalDate.now().getDayOfWeek() + " "
                            + LocalDate.now().getDayOfMonth() + " day of "
                            + LocalDate.now().getMonth() + " "
                            + LocalDate.now().getYear()
            );
        }
    }
}
