package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

@DisplayName("Forum Test Suite")
public class ForumTestSuite {

    @BeforeEach
    void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    void after() {
        System.out.println("Test Case: end\n");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Test Suite: begin\n");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("When created SimpleUser with name, " +
            "then getRealName should return real user name"
    )
    @Test
    void testCaseRealName() {
        //Given
        SimpleUser simpleUser = new SimpleUser("Kazik", "Kazimierz Wielki");
        //When
        String result = simpleUser.getRealName();
        System.out.println("Testing " + result);
        //Then
        Assertions.assertEquals("Kazimierz Wielki", result);
    }

    @DisplayName("When created SimpleUser with name, " +
            "then getUsername should return correct name"
    )
    @Test
    void testCaseUsername() {
        //Given
        SimpleUser simpleUser = new SimpleUser("Daniel");
        //When
        String result = simpleUser.getUsername();
        String expectedResult = "Daniel";
        System.out.println("Testing " + result);
        //Then
        Assertions.assertEquals(expectedResult, result);
    }
}
