package com.kodilla.patterns.factory.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuit {

    private final TaskFactory taskFactory = new TaskFactory();

    @Test
    void testFactoryShoppingTask() {
        //Given
        //When
        Task shopping = taskFactory.makeShape(TaskFactory.SHOPPING);
        assert shopping != null;
        shopping.executeTask();
        //Then
        assertEquals("Buy vegetables", shopping.getTaskName());
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        //When
        Task painting = taskFactory.makeShape(TaskFactory.PAINTING);
        assert painting != null;
        painting.executeTask();
        //Then
        assertEquals("Paint the wall", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }

    @Test
    void testFactoryDriving() {
        //Given
        //When
        Task driving = taskFactory.makeShape(TaskFactory.DRIVING);
        assert driving != null;
        driving.executeTask();
        //Then
        assertEquals("Drive to Warsaw", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }
}