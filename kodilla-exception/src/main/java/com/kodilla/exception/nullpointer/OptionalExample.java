package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        User user = new User("user1");
        Optional<User> optionalUser = Optional.ofNullable(user);
        String userName = optionalUser.orElse(new User("")).getName();
        System.out.println(userName);
        optionalUser.ifPresent(u -> System.out.println(u.getName()));
    }
}
