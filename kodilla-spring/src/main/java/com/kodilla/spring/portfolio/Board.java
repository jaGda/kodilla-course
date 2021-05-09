package com.kodilla.spring.portfolio;

public class Board {
    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public int displayToDoList() {
        System.out.println("To do tasks: ");
        toDoList.getTasks().forEach(System.out::println);
        System.out.println();
        return toDoList.getTasks().size();
    }

    public int displayInProgressList() {
        System.out.println("Tasks in progress: ");
        inProgressList.getTasks().forEach(System.out::println);
        System.out.println();
        return inProgressList.getTasks().size();
    }

    public int displayDoneList() {
        System.out.println("Done tasks: ");
        doneList.getTasks().forEach(System.out::println);
        System.out.println();
        return doneList.getTasks().size();
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}
