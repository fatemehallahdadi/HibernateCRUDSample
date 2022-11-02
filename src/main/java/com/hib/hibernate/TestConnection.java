package com.hib.hibernate;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {


    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/unii";
        String username = "uniuser";
        String password = "123456fa";
        try {
            System.out.println("connecting to database : " + jdbcUrl);
            DriverManager.getConnection(jdbcUrl, username, password);
            System.out.println("Successfully connected...");
        } catch (SQLException e) {
            System.out.println("failed to connect to database");
            e.printStackTrace();

        }

    }
}
