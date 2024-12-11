package com.mycompany.javaservice;

import java.io.IOException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws IOException {
        int maxAttempts = 5;
        int status;
        Connection conn;
        DB_Manager manager = new DB_Manager(
                System.getenv("POSTGRES_USER"),
                System.getenv("POSTGRES_PASSWORD"),
                System.getenv("POSTGRES_HOST"),
                System.getenv("POSTGRES_DB"),
                Integer.parseInt(System.getenv("POSTGRES_PORT")));
        WebServer server = new WebServer(Integer.parseInt(System.getenv("BACKEND_PORT")));

        // Boot Jetty HTTP Server.
        try {
            server.boot();
            status = server.getStatus();
            if (status == 200) {
                System.out.println("Status OK: " + status);
            } else {
                System.out.println("Failed: " + status);
                server.shutdown();
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Check connection to database.
        conn = manager.connectToDatabase(maxAttempts);
        if (conn != null) {
            System.out.println("Connection to " + System.getenv("POSTGRES_DB") + " was successful");
            manager.closeConnection(conn);
        } else {
            System.out.println("Connection to " + System.getenv("POSTGRES_DB") + " failed");
        }

    }
}
