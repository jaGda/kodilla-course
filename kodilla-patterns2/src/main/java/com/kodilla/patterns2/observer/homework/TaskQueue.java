package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.forum.Observable;
import com.kodilla.patterns2.observer.forum.Observer;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue implements Observable<TaskQueue> {

    private final List<Observer<TaskQueue>> observers;
    private final List<String> tasks;
    private final String name;

    public TaskQueue(String name) {
        this.observers = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.name = name;
    }

    public void addTask(String task) {
        tasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer<TaskQueue> observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer<TaskQueue> observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer<TaskQueue> observer) {
        observers.remove(observer);
    }

    public List<Observer<TaskQueue>> getObservers() {
        return observers;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public String getName() {
        return name;
    }
}
