package be.intecbrussel.repositoreis;

import be.intecbrussel.ConnectionDb;
import be.intecbrussel.models.Brewer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrewerRepository {
    ConnectionDb connectionDb = new ConnectionDb();
    Statement statement = connectionDb.createStatement();

    public List<Brewer> read() {
        List<Brewer> results = new ArrayList<>();
        try {
            String query = "SELECT * FROM Brewers";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getRow() + " | " +
                        resultSet.getInt("Id") + " | " +
                        resultSet.getString("Name") + " | " +
                        resultSet.getString("Address") + " | " +
                        resultSet.getString("ZipCode") + " | " +
                        resultSet.getString("City") + " | " +
                        resultSet.getInt("Turnover")
                );
            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
        return results;
    }


    public void create() {
        try {
            String insert = " INSERT IGNORE INTO Brewers VALUES(127,'MausamBrewery','Nestor de Tierestraat','9300','Aalst',25000) ";
            statement.executeUpdate(insert);
            System.out.println("Data inserted.");
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
    }

    public void update() {
        try {
            String update = "UPDATE Brewers SET Name = 'Mausam´sBrewery' WHERE Id = 127";
            statement.executeUpdate(update);
            System.out.println("Data updated.");
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
    }

    public void delete() {
        try {
            String delete = "DELETE FROM Brewers WHERE Id = 127";
            statement.executeUpdate(delete);
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }

    }

}
