package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuit {

    private static final String TO_DO = "To do list.";
    private static final String IN_PROGRESS = "In progress list.";

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given & When
        for (int i = 1; i < 11; i++) {
            TaskList taskList;
            if (i % 2 != 0) {
                taskList = new TaskList(TO_DO, "To do task - number " + i + ".");
            } else {
                taskList = new TaskList(IN_PROGRESS, "In progress task - number " + i + ".");
            }
            taskListDao.save(taskList);
        }
        List<TaskList> toDo = taskListDao.findByListName(TO_DO);
        List<TaskList> inProgress = taskListDao.findByListName(IN_PROGRESS);
        //Then
        assertAll(
                () -> assertEquals(5, toDo.size()),
                () -> assertEquals(5, inProgress.size())
        );

        //CleanUp
        taskListDao.deleteAll();
    }

}