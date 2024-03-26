package be.intecbrussel.repositoreis;


import be.intecbrussel.ConnectionDb;
import be.intecbrussel.models.Beer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BeerRepository {
    ConnectionDb connectionDb = new ConnectionDb();
    Statement statement = connectionDb.createStatement();

    public List<Beer> read() {
        List<Beer> results = new ArrayList<>();
        try {
            String query = "SELECT * FROM Beers";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println(resultSet.getRow() + " | " +
                        resultSet.getInt("Id") + " | " +
                        resultSet.getString("Name") + " | " +
                        resultSet.getInt("BrewerId") + " | " +
                        resultSet.getInt("CategoryId") + " | " +
                        resultSet.getInt("Price") + " | " +
                        resultSet.getInt("Stock") + " | " +
                        resultSet.getInt("Alcohol") + " | " +
                        resultSet.getInt("Version") + " | " +
                        resultSet.getBlob("Image")
                );
            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
        return results;
    }

    public void create() {
        try {
            String insert = "INSERT IGNORE INTO Beers VALUES (1558,'AnotherBeer',99,13,2.5,200,13,1,NULL)";
            statement.executeUpdate(insert);
            System.out.println("Data inserted.");
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }

    }

    public void update() {
        try {
            String update = "UPDATE Beers SET Name = 'TheLastBeer' WHERE Id = 1558";
            statement.executeUpdate(update);
            System.out.println("Data updated.");
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }

    }

    public void delete() {
        try {
            String delete = "DELETE FROM Beers WHERE Id = 1558";
            statement.executeUpdate(delete);
            System.out.println("Data deleted.");
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }

    }
}
