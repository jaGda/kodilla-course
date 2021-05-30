package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuit {

    private static final String TO_DO = "TO_DO";
    private static final String IN_PROGRESS = "IN_PROGRESS";

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task1 = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);

        TaskList taskList = new TaskList(TO_DO, "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
//        taskListDao.deleteById(id);

    }

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