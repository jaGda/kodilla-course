package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.kodilla.jdbc.DbManager.DB_MANAGER;
import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuit {

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