package com.kodilla.testing.forum.statistics;

public class CalculateStatistics {
    private int numberOfUsers;
    private int numberOfPosts;
    private int numberOfComments;
    double averageNumberOfPostsPerUser;
    double averageNumberOfCommentsPerUser;
    double averageNumberOfCommentsPerPost;
    private String statistics;

    public void calculateAdvStatistics(Statistics statistics) {
        this.numberOfUsers = statistics.usersName().size();
        this.numberOfPosts = statistics.postsCount();
        this.numberOfComments = statistics.commentsCount();
        if (this.numberOfUsers == 0 || numberOfPosts == 0) {
            this.averageNumberOfPostsPerUser = 0;
            this.averageNumberOfCommentsPerUser = 0;
            this.averageNumberOfCommentsPerPost = 0;
        } else if (this.numberOfComments < this.numberOfPosts && this.numberOfComments != 0) {
            this.averageNumberOfPostsPerUser = (double) this.numberOfPosts / this.numberOfUsers;
            this.averageNumberOfCommentsPerUser = (double) this.numberOfComments / this.numberOfUsers;
            this.averageNumberOfCommentsPerPost = 1;
        } else {
            this.averageNumberOfPostsPerUser = (double) this.numberOfPosts / this.numberOfUsers;
            this.averageNumberOfCommentsPerUser = (double) this.numberOfComments / this.numberOfUsers;
            this.averageNumberOfCommentsPerPost = (double) this.numberOfComments / this.numberOfPosts;
        }
    }

    public void showStatistics() {
        this.statistics = "\nCurrent stats:" +
                "\nnumber of users " + getNumberOfUsers() +
                "\nnumber of posts " + getNumberOfPosts() +
                "\nnumber of comments " + getNumberOfComments() +
                "\naverage number of posts per user " + getAverageNumberOfPostsPerUser() +
                "\naverage number of comments per user " + getAverageNumberOfCommentsPerUser() +
                "\naverage number of comments per post " + getAverageNumberOfCommentsPerPost();
        System.out.println(getStatistics());
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }

    public String getStatistics() {
        return statistics;
    }
}
