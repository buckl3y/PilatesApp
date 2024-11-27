package com.mycompany.javaservice;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        int attemptCount = 0;
        int maxAttemptCount = 5;
        Connection conn;

        DB_Manager manager = new DB_Manager(
        "postgres",
        "postgres",
        "postgres",
        "postgres",
        5432);

        while(attemptCount < maxAttemptCount) {
            conn = manager.connectToDatabase();
            if(conn != null) {
                System.out.println("Connection Successful");
                break;
            } else {
                System.out.println("Connection Failed");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
            attemptCount++;
        }
    }
}
