package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskQueueTestSuit {


    @Test
    void testUpdate() {
        // Given
        TaskQueue student1 = new TaskQueue("Daniel_queue");
        TaskQueue student2 = new TaskQueue("Marta_queue");
        TaskQueue student3 = new TaskQueue("Jan_queue");
        Mentor mentor1 = new Mentor("Andrzej");
        Mentor mentor2 = new Mentor("Kuba");
        student1.registerObserver(mentor1);
        student2.registerObserver(mentor1);
        student2.registerObserver(mentor2);
        student3.registerObserver(mentor2);
        // When
        student1.addTask("Module 3 - task 3.2 - collections");
        student2.addTask("Module 24 - task 24.1 - Observe pattern");
        student3.addTask("Module 8 - task 8.3 - spring web");
        // Then
        assertEquals(2, mentor1.getUpdateCount());
        assertEquals(2, mentor2.getUpdateCount());
    }
}