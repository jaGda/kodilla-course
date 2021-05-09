package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

        @Autowired
        @Qualifier("ToDoList")
        TaskList toDoList;

        @Autowired
        @Qualifier("InProgressList")
        TaskList inProgressList;

        @Autowired
        @Qualifier("DoneList")
        TaskList doneList;

        @Test
        void addTasksToToDoList() {
            //Given
            //When & Then
            assertAll(
                    () -> assertTrue(toDoList.addTask("Read a book.")),
                    () -> assertEquals(1, board.displayToDoList())
            );
        }

        @Test
        void addTasksToInProgressList() {
            //Given
            //When & Then
            assertAll(
                    () -> assertTrue(inProgressList.addTask("PIT settlement.")),
                    () -> assertEquals(1, board.displayInProgressList())
            );
        }

        @Test
        void addTasksToDoneList() {
            //Given
            //When & Then
            assertAll(
                    () -> assertTrue(doneList.addTask("To sweep the floor.")),
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