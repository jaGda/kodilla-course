package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public enum DbManager {
    DB_MANAGER;

    private Connection connection;

    DbManager() {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "D@niel1985D");
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
                            "&useSSL=False", connectionProps);
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    /**
     private Connection connection;
     private static DbManager dbManagerInstance;

     private DbManager() throws SQLException {
     Properties connectionProps = new Properties();
     connectionProps.put("user", "root");
     connectionProps.put("password", "D@niel1985D");
     connection = DriverManager.getConnection(
     "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
     "&useSSL=False", connectionProps);
     }

     public static DbManager getInstance() throws SQLException {
     if (dbManagerInstance == null) {
     dbManagerInstance = new DbManager();
     }
     return dbManagerInstance;
     }

     public Connection getConnection() {
     return connection;
     }
     */
}
