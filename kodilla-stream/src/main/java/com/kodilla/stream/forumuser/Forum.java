package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {

    private static final List<ForumUser> usersList = new ArrayList<>();

    static {
        usersList.add(new ForumUser(1111, "Vito Andolini", 'M', LocalDate.of(1891, 12, 7), 44));
        usersList.add(new ForumUser(2222, "Michael Corleone", 'M', LocalDate.of(1920, 10, 15), 35));
        usersList.add(new ForumUser(3333, "Kay Adams", 'F', LocalDate.of(1924, 3, 20), 63));
        usersList.add(new ForumUser(4444, "Connie Corleone", 'F', LocalDate.of(1922, 12, 12), 53));
        usersList.add(new ForumUser(5555, "Peter Clemenza", 'M', LocalDate.of(1887, 1, 14), 12));
        usersList.add(new ForumUser(6666, "Tom Hagen", 'M', LocalDate.of(1910, 5, 23), 48));
    }

    public static List<ForumUser> getUsersList() {
        return new ArrayList<>(usersList);
    }
}
