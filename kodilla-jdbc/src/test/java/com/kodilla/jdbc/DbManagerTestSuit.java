package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.kodilla.jdbc.DbManager.DB_MANAGER;
import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuit {

    @Test
    void testSelectUsersAndPosts() throws SQLException {
        //Given
        //When
        String sqlQuery = "SELECT kodilla_course.USERS.FIRSTNAME, kodilla_course.USERS.LASTNAME, COUNT(*) as POSTS_NUMBER " +
                "from kodilla_course.USERS " +
                "         join kodilla_course.posts on kodilla_course.USERS.ID = kodilla_course.POSTS.USER_ID " +
                "GROUP BY kodilla_course.USERS.FIRSTNAME, kodilla_course.USERS.LASTNAME " +
                "having POSTS_NUMBER >= 2;";
        Statement statement = DB_MANAGER.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FIRSTNAME") + "|" +
                    resultSet.getString("LASTNAME") + "|" +
                    resultSet.getInt("POSTS_NUMBER"));
            counter++;
        }
        assertEquals(5, counter);
    }

    @Test
    void testConnection() throws SQLException {
        //Given
        //When
        //Then
        assertNotNull(DB_MANAGER.getConnection());
    }

    @Test
    void testSelectUsers() throws SQLException {
        //Given
        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = DB_MANAGER.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + "|" +
                    rs.getString("FIRSTNAME") + "|" +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        assertEquals(5, counter);
    }
}