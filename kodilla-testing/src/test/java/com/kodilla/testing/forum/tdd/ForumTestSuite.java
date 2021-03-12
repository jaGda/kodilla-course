package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestsPosts {
        @Test
        void testAddPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");

            //When
            forumUser.addPost("mrSmith",
                    "Hello everyone, this is my first contribution here!");

            //Then
            assertEquals(1, forumUser.getPostsQuantity());
        }

        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrSmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);

            //Then
            assertEquals(thePost, retrievedPost);
        }

        @Test
        void testRemovePostNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrSmith");

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            assertFalse(result);
        }

        @Test
        void testRemovePost() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrSmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            Assertions.assertTrue(result);
            assertEquals(0, forumUser.getPostsQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for comments")
    class TestsComments {
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrSmith");

            //When
            forumUser.addComment(thePost, "mrSmith", "Thank you for all good words!");

            //Then
            assertEquals(1, forumUser.getCommentsQuantity());
        }

        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrSmith");
            ForumComment theComment = new ForumComment(thePost, "mrSmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());

            //When
            ForumComment retrievedComment = forumUser.getComment(0);

            //Then
            assertEquals(theComment, retrievedComment);
        }

        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrSmith");
            ForumComment theComment = new ForumComment(thePost, "mrSmith",
                    "Thank you for all good words!");

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            assertFalse(result);
        }

        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrSmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, " +
                    "this is my first contribution here!", "mrSmith");
            ForumComment theComment = new ForumComment(thePost, "mrSmith",
                    "Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(),
                    theComment.getCommentBody());

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertTrue(result);
            assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}
