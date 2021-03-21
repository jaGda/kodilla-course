package com.kodilla.stream.forum;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ForumUser {

    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(String username, String realName, String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public Set<String> getLocationsOfFriends() {
        return friends.stream()
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }

    public Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream()
                .flatMap(friend -> friend.getFriends().stream())
                .filter(friend -> friend != this)
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }

    public void addFriend(ForumUser user) {
        friends.add(user);
    }

    public boolean removeFriend(ForumUser user) {
        return friends.remove(user);
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        if (getUsername() != null ? !getUsername().equals(forumUser.getUsername()) : forumUser.getUsername() != null)
            return false;
        if (getRealName() != null ? !getRealName().equals(forumUser.getRealName()) : forumUser.getRealName() != null)
            return false;
        if (getLocation() != null ? !getLocation().equals(forumUser.getLocation()) : forumUser.getLocation() != null)
            return false;
        return getFriends() != null ? getFriends().equals(forumUser.getFriends()) : forumUser.getFriends() == null;
    }

    @Override
    public int hashCode() {
        int result = getUsername() != null ? getUsername().hashCode() : 0;
        result = 31 * result + (getRealName() != null ? getRealName().hashCode() : 0);
        result = 31 * result + (getLocation() != null ? getLocation().hashCode() : 0);
        return result;
    }
}
