package br.com.training.school.domain.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:file:/home/thalia/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";
    Connection conn = null;

    public Connection getConn() {
        Statement stmt = null;

        // STEP 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conn;

    }

}



