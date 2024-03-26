package be.intecbrussel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionDb {

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thebelgianbrewerydb", "mausam", "mausam2024");
            System.out.println("Connection to database is made");
        } catch (SQLException sqlException) {
            System.err.println("SQL EXCEPTION: " + sqlException.getMessage());
        }
        return connection;
    }

    public Statement createStatement() {
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
        } catch (SQLException sqlException) {
            System.err.println("SQL EXCEPTION: " + sqlException.getMessage());
        }
        return statement;
    }

}
