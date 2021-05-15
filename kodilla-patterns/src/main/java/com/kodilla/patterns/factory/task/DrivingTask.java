package com.kodilla.patterns.factory.task;

public class DrivingTask implements Task {
    private final String taskName;
    private final String where;
    private final String using;
    private boolean flag = false;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("Driving task is done: driving to " + where + " using " + using + ".");
        flag = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return flag;
    }
}
