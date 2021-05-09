package com.kodilla.spring.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Autowired
    private Board board;

    @Bean(name = "Board")
    public Board getBoard() {
        return new Board(getToDoList(), getInProgressList(), getDoneList());
    }

    @Bean(name = "DoneList")
    public TaskList getDoneList() {
        return new TaskList();
    }

    @Bean(name = "InProgressList")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "ToDoList")
    public TaskList getToDoList() {
        return new TaskList();
    }
}
