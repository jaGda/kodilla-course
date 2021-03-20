package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int userID;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int postedPosts;

    public ForumUser(int userID, String userName, char sex, LocalDate dateOfBirth, int postedPosts) {
        this.userID = userID;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.postedPosts = postedPosts;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPostedPosts() {
        return postedPosts;
    }

    @Override
    public String toString() {
        return "{userName = " + userName +
                ", sex = " + sex +
                ", dateOfBirth = " + dateOfBirth +
                ", postedPosts = " + postedPosts +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumUser forumUser = (ForumUser) o;

        if (getUserID() != forumUser.getUserID()) return false;
        if (getSex() != forumUser.getSex()) return false;
        if (getPostedPosts() != forumUser.getPostedPosts()) return false;
        if (getUserName() != null ? !getUserName().equals(forumUser.getUserName()) : forumUser.getUserName() != null)
            return false;
        return getDateOfBirth() != null ? getDateOfBirth().equals(forumUser.getDateOfBirth()) : forumUser.getDateOfBirth() == null;
    }

    @Override
    public int hashCode() {
        int result = getUserID();
        result = 31 * result + (getUserName() != null ? getUserName().hashCode() : 0);
        result = 31 * result + (int) getSex();
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + getPostedPosts();
        return result;
    }
}
