/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.javaservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Caleb
 */
public class DB_Manager {

    private final String user;
    private final String pw;
    private final String host;
    private final String database;
    private final int port;

    public DB_Manager(String user, String pw, String host, String database, int port) {
        this.user = user;
        this.pw = pw;
        this.host = host;
        this.database = database;
        this.port = port;
    }

    protected Connection connectToDatabase() {
        String jdbcUrl = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Postgres Driver Not Found.");
            return conn;
        }
        try {
            conn = DriverManager.getConnection(jdbcUrl, user, pw);
        } catch (SQLException ex) {
            return conn;
        }
        return conn;
    }

    protected void closeConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
        }
    }
}
