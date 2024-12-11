package com.mycompany.javaservice;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        int maxAttempts = 5;
        Connection conn;

        DB_Manager manager = new DB_Manager(
                System.getenv("POSTGRES_USER"),
                System.getenv("POSTGRES_PASSWORD"),
                System.getenv("POSTGRES_HOST"),
                System.getenv("POSTGRES_DB"),
                Integer.parseInt(System.getenv("POSTGRES_PORT")));
        conn = manager.connectToDatabase(maxAttempts);
        if (conn != null) {
            System.out.println("Connection to " + System.getenv("POSTGRES_DB") + " was successful");
        } else {
            System.out.println("Connection to " + System.getenv("POSTGRES_DB") + " failed");
        }
    }
}
