package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Tests methods returning forum statistics.")
public class StatisticsTestSuite {

    @Mock
    Statistics statistics;

    private final CalculateStatistics calculateStatistics = new CalculateStatistics();
    private final List<String> users = generateListUsers(20);

    private List<String> generateListUsers(int number) {
        return Stream.iterate(2, n -> ++n)
                .limit(number)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    @BeforeEach
    void beforeEach() {
    }

    @Test
    @DisplayName("Test method calculateAdvStatistics when zero posts.")
    void testCalculateAdvStatisticsWhenZeroPosts() {
        //Given
        when(statistics.usersName()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(0);
        when(statistics.commentsCount()).thenReturn(20);

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        double resultAvrNumOfPostsPerUser = calculateStatistics.getAverageNumberOfPostsPerUser();
        double resultAvrNumOfCommentsPerUser = calculateStatistics.getAverageNumberOfCommentsPerUser();
        double resultAvrNumOfCommentsPerPost = calculateStatistics.getAverageNumberOfCommentsPerPost();
        double expectedAvrNumOfPostsPerUser = 0;
        double expectedAvrNumOfCommentsPerUser = 0;
        double expectedAvrNumOfCommentsPerPost = 0;

        //Then
        assertAll(
                () -> assertEquals(expectedAvrNumOfPostsPerUser, resultAvrNumOfPostsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerUser, resultAvrNumOfCommentsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerPost, resultAvrNumOfCommentsPerPost)
        );
    }

    @Test
    @DisplayName("Test method calculateAdvStatistics.")
    void testCalculateAdvStatistics() {
        //Given
        when(statistics.usersName()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.commentsCount()).thenReturn(2000);

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        double resultAvrNumOfPostsPerUser = calculateStatistics.getAverageNumberOfPostsPerUser();
        double resultAvrNumOfCommentsPerUser = calculateStatistics.getAverageNumberOfCommentsPerUser();
        double resultAvrNumOfCommentsPerPost = calculateStatistics.getAverageNumberOfCommentsPerPost();
        double expectedAvrNumOfPostsPerUser = (double) 1000 / 20;
        double expectedAvrNumOfCommentsPerUser = (double) 2000 / 20;
        double expectedAvrNumOfCommentsPerPost = (double) 2000 / 1000;

        //Then
        assertAll(
                () -> assertEquals(expectedAvrNumOfPostsPerUser, resultAvrNumOfPostsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerUser, resultAvrNumOfCommentsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerPost, resultAvrNumOfCommentsPerPost)
        );
    }

    @Test
    @DisplayName("Test method calculateAdvStatistics when zero comments.")
    void testCalculateAdvStatisticsWhenZeroComments() {
        //Given
        when(statistics.usersName()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.commentsCount()).thenReturn(0);

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        double resultAvrNumOfPostsPerUser = calculateStatistics.getAverageNumberOfPostsPerUser();
        double resultAvrNumOfCommentsPerUser = calculateStatistics.getAverageNumberOfCommentsPerUser();
        double resultAvrNumOfCommentsPerPost = calculateStatistics.getAverageNumberOfCommentsPerPost();
        double expectedAvrNumOfPostsPerUser = (double) 1000 / 20;
        double expectedAvrNumOfCommentsPerUser = 0;
        double expectedAvrNumOfCommentsPerPost = 0;

        //Then
        assertAll(
                () -> assertEquals(expectedAvrNumOfPostsPerUser, resultAvrNumOfPostsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerUser, resultAvrNumOfCommentsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerPost, resultAvrNumOfCommentsPerPost)
        );
    }

    @Test
    @DisplayName("Test method calculateAdvStatistics when less comments than posts.")
    void testCalculateAdvStatisticsWhenCommentsLessThanPosts() {
        //Given
        when(statistics.usersName()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(1000);
        when(statistics.commentsCount()).thenReturn(20);

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        double resultAvrNumOfPostsPerUser = calculateStatistics.getAverageNumberOfPostsPerUser();
        double resultAvrNumOfCommentsPerUser = calculateStatistics.getAverageNumberOfCommentsPerUser();
        double resultAvrNumOfCommentsPerPost = calculateStatistics.getAverageNumberOfCommentsPerPost();
        double expectedAvrNumOfPostsPerUser = (double) 1000 / 20;
        double expectedAvrNumOfCommentsPerUser = (double) 20 / 20;
        double expectedAvrNumOfCommentsPerPost = 1;

        //Then
        assertAll(
                () -> assertEquals(expectedAvrNumOfPostsPerUser, resultAvrNumOfPostsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerUser, resultAvrNumOfCommentsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerPost, resultAvrNumOfCommentsPerPost)
        );
    }

    @Test
    @DisplayName("Test method calculateAdvStatistics when less posts than comments.")
    void testCalculateAdvStatisticsWhenPostsLessThanComments() {
        //Given
        when(statistics.usersName()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(20);
        when(statistics.commentsCount()).thenReturn(1000);

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        double resultAvrNumOfPostsPerUser = calculateStatistics.getAverageNumberOfPostsPerUser();
        double resultAvrNumOfCommentsPerUser = calculateStatistics.getAverageNumberOfCommentsPerUser();
        double resultAvrNumOfCommentsPerPost = calculateStatistics.getAverageNumberOfCommentsPerPost();
        double expectedAvrNumOfPostsPerUser = (double) 20 / 20;
        double expectedAvrNumOfCommentsPerUser = (double) 1000 / 20;
        double expectedAvrNumOfCommentsPerPost = (double) 1000 / 20;

        //Then
        assertAll(
                () -> assertEquals(expectedAvrNumOfPostsPerUser, resultAvrNumOfPostsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerUser, resultAvrNumOfCommentsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerPost, resultAvrNumOfCommentsPerPost)
        );
    }

    @Test
    @DisplayName("Test method calculateAdvStatistics when zero users.")
    void testCalculateAdvStatisticsWhenZeroUsers() {
        //Given
        when(statistics.usersName()).thenReturn(generateListUsers(0));
        when(statistics.postsCount()).thenReturn(20);
        when(statistics.commentsCount()).thenReturn(1000);

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        double resultAvrNumOfPostsPerUser = calculateStatistics.getAverageNumberOfPostsPerUser();
        double resultAvrNumOfCommentsPerUser = calculateStatistics.getAverageNumberOfCommentsPerUser();
        double resultAvrNumOfCommentsPerPost = calculateStatistics.getAverageNumberOfCommentsPerPost();
        double expectedAvrNumOfPostsPerUser = 0;
        double expectedAvrNumOfCommentsPerUser = 0;
        double expectedAvrNumOfCommentsPerPost = 0;

        //Then
        assertAll(
                () -> assertEquals(expectedAvrNumOfPostsPerUser, resultAvrNumOfPostsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerUser, resultAvrNumOfCommentsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerPost, resultAvrNumOfCommentsPerPost)
        );
    }

    @Test
    @DisplayName("Test method calculateAdvStatistics when 1000 users.")
    void testCalculateAdvStatisticsWhen1000Users() {
        //Given
        List<String> users = generateListUsers(1000);
        when(statistics.usersName()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(20000);
        when(statistics.commentsCount()).thenReturn(100000);

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        double resultAvrNumOfPostsPerUser = calculateStatistics.getAverageNumberOfPostsPerUser();
        double resultAvrNumOfCommentsPerUser = calculateStatistics.getAverageNumberOfCommentsPerUser();
        double resultAvrNumOfCommentsPerPost = calculateStatistics.getAverageNumberOfCommentsPerPost();
        double expectedAvrNumOfPostsPerUser = (double) 20000 / 1000;
        double expectedAvrNumOfCommentsPerUser = (double) 100000 / 1000;
        double expectedAvrNumOfCommentsPerPost = (double) 100000 / 20000;

        //Then
        assertAll(
                () -> assertEquals(expectedAvrNumOfPostsPerUser, resultAvrNumOfPostsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerUser, resultAvrNumOfCommentsPerUser),
                () -> assertEquals(expectedAvrNumOfCommentsPerPost, resultAvrNumOfCommentsPerPost)
        );
    }

    @Test
    @DisplayName("Test method sets field class that represents users quantity.")
    void testSettingVarNumberOfUsers() {
        //Given
        when(statistics.usersName()).thenReturn(users);

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        int numberOfUsers = calculateStatistics.getNumberOfUsers();
        int expectedNumberOfUsers = users.size();

        //Then
        assertEquals(expectedNumberOfUsers, numberOfUsers);
    }

    @Test
    @DisplayName("Test method sets field class that represents posts quantity.")
    void testSettingVarNumberOfPosts() {
        //Given
        int numberOfPosts = 100;
        when(statistics.postsCount()).thenReturn(numberOfPosts);

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        int resultNumberOfPosts = calculateStatistics.getNumberOfPosts();

        //Then
        assertEquals(numberOfPosts, resultNumberOfPosts);
    }

    @Test
    @DisplayName("Test method sets field class that represents comments quantity.")
    void testSettingVarNumberOfComments() {
        //Given
        int numberOfComments = 431;
        when(statistics.commentsCount()).thenReturn(numberOfComments);

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        int resultNumberOfComments = calculateStatistics.getNumberOfComments();

        //Then
        assertEquals(numberOfComments, resultNumberOfComments);
    }

    @Test
    @DisplayName("Test method sets field class that represents all stats as String.")
    void testShowingStats() {
        //Given
        when(statistics.usersName()).thenReturn(users);
        when(statistics.postsCount()).thenReturn(80);
        when(statistics.commentsCount()).thenReturn(160);

        String stats = "\nCurrent stats:" +
                "\nnumber of users " + 20 +
                "\nnumber of posts " + 80 +
                "\nnumber of comments " + 160 +
                "\naverage number of posts per user " + 4.0 +
                "\naverage number of comments per user " + 8.0 +
                "\naverage number of comments per post " + 2.0;

        //When
        calculateStatistics.calculateAdvStatistics(statistics);
        calculateStatistics.showStatistics();
        String resultStatistics = calculateStatistics.getStatistics();

        //Then
        assertEquals(stats, resultStatistics);
    }
}
