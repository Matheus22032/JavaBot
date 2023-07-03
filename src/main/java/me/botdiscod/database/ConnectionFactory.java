package me.botdiscod.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String url = "jdbc:postgresql://localhost/javabot";
    private static final String user = "postgres";
    private static final String password = System.getenv("PASSWORD_DB");

    public static Connection connect(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
