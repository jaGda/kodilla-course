package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(1985, 12, 9);

        System.out.println(Period.between(date, LocalDate.now()).getYears());

        Forum.getUsersList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> Period.between(forumUser.getDateOfBirth(), LocalDate.now()).getYears() > 100)
                .filter(forumUser -> forumUser.getPostedPosts() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser))
                .entrySet().stream()
                .map(entry -> "userID = " + entry.getKey() + " : " + entry.getValue())
                .forEach(System.out::println);
    }
}
