package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Testing SimpleUser class : ");
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error1");
        }

        System.out.println("\nTesting SimpleUser class : ");

        int addResult = 4;

        System.out.println(Calculator.add(2, 2) == addResult ? "test OK" : "Error!");
        System.out.println(Calculator.add(2, 3) != addResult ? "test OK" : "Error!");

        int subtractResult = -2;

        System.out.println(Calculator.subtract(2, 4) == subtractResult ? "test OK" : "Error!");
        System.out.println(Calculator.subtract(2, 6) != subtractResult ? "test OK" : "Error!");

    }
}
