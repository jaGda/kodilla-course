package com.kodilla.stream.forum;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForumUserTestSuite {

    private static ForumUser user1;

    @BeforeAll
    static void beforeAll() {
        user1 = new ForumUser("alan01", "Alan Kosovsky", "Krakow");
        ForumUser user2 = new ForumUser("ethanreard", "Ethan Reard", "Miami");
        ForumUser user3 = new ForumUser("eRiK", "Erik Hull", "Key West");
        ForumUser user7 = new ForumUser("bigmac", "Robert Macdonald", "Warsaw");
        ForumUser user9 = new ForumUser("user121212", "Marisa Frank", "Krakow");
        ForumUser user10 = new ForumUser("lawyer", "Lexie John", "Miami");

        user1.addFriend(user3);
        user1.addFriend(user7);
        user1.addFriend(user10);
        user3.addFriend(user1);
        user3.addFriend(user7);
        user3.addFriend(user2);
        user3.addFriend(user9);
        user7.addFriend(user1);
        user7.addFriend(user3);
        user10.addFriend(user1);
        user2.addFriend(user3);
        user9.addFriend(user3);
    }

    @Test
    void testGetLocationsOfFriends() {
        //Given
        //When
        //Then
        assertEquals(3, user1.getLocationsOfFriends().size());
        assertTrue(user1.getLocationsOfFriends().contains("Key West"));
        assertTrue(user1.getLocationsOfFriends().contains("Warsaw"));
        assertTrue(user1.getLocationsOfFriends().contains("Miami"));
        assertFalse(user1.getLocationsOfFriends().contains("Orlando"));
    }

    @Test
    void testGetLocationsOfFriendsOfFriends() {
        //Given
        //When
        //Then
        assertEquals(4, user1.getLocationsOfFriendsOfFriends().size());
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Key West"));
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Miami"));
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Warsaw"));
        assertTrue(user1.getLocationsOfFriendsOfFriends().contains("Krakow"));
        assertFalse(user1.getLocationsOfFriendsOfFriends().contains("Orlando"));

    }
}