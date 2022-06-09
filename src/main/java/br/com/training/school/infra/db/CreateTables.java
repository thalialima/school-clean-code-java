package br.com.training.school.infra.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    Connection conn;

    public CreateTables(Connection connection) {
        this.conn = connection;
    }

    public void creatStudent() {
        // Open a connection
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE STUDENT " +
                    "(cpf VARCHAR(15) not NULL, " +
                    " name VARCHAR(70), " +
                    " email VARCHAR(50), " +
                    " PRIMARY KEY ( cpf ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void creatPhone() {
        // Open a connection
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE PHONE " +
                    "(ddd VARCHAR(2), " +
                    " number VARCHAR(10), " +
                    " PRIMARY KEY ( ddd ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

