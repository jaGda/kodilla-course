package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test spring configuration vis class")
class BoardTestSuit {

    @Nested
    @SpringBootTest
    class BoardConfigTests {
        @Autowired
        Board board;

        @Test
        void addTasksToToDoList() {
            //Given
            //When & Then
            assertAll(
                    () -> assertTrue(board.getToDoList().addTask("Read a book.")),
                    () -> assertEquals(1, board.displayToDoList())
            );
        }

        @Test
        void addTasksToInProgressList() {
            //Given
            //When & Then
            assertAll(
                    () -> assertTrue(board.getInProgressList().addTask("PIT settlement.")),
                    () -> assertEquals(1, board.displayInProgressList())
            );
        }

        @Test
        void addTasksToDoneList() {
            //Given
            //When & Then
            assertAll(
                    () -> assertTrue(board.getDoneList().addTask("To sweep the floor.")),
                    () -> assertEquals(1, board.displayDoneList())
            );
        }
    }

    @Nested
    @SpringBootTest
    class LoadContext {
        @Test
        void contextLoad() {
            //Given
            ApplicationContext context =
                    new AnnotationConfigApplicationContext(BoardConfig.class);
            //When & Then
            System.out.println("===== Beans list: ===>>");
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
            System.out.println("<<=== Beans list: =====");
        }
    }
}