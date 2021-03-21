package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum.getUsersList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> ChronoUnit.YEARS.between(forumUser.getDateOfBirth(), LocalDate.now()) >= 100)
                .filter(forumUser -> forumUser.getPostedPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser))
                .entrySet().stream()
                .map(entry -> "userID = " + entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);
    }
}
