package be.intecbrussel.repositoreis;


import be.intecbrussel.ConnectionDb;
import be.intecbrussel.models.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository  {

    ConnectionDb connectionDb = new ConnectionDb();
    Statement statement =connectionDb.createStatement();

    public List<Category> read() throws SQLException {

        // Polymorphism
        List<Category> results = new ArrayList<>();
        try {
            // if this query returns multiple results, then read() method must return either an array or a list.
            String query = "SELECT Id,Category FROM categories";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("Id"));
            }
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
        return results;
    }

    public void create() {
        try {
            String insert = "INSERT IGNORE INTO Categories VALUES (66, 'LastCategory')";
            statement.executeUpdate(insert);
            System.out.println("Data inserted");
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
    }

    public void update() {
        try {
            String update = "UPDATE Categories SET Category = 'NOCategory' WHERE ID IN(66)";
            statement.executeUpdate(update);
            System.out.println("Data updated");
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
    }

    public void delete() {
        try {
            String delete = "DELETE From Categories WHERE Id = 66";
            statement.executeUpdate(delete);
            System.out.println("Data deleted");
        } catch (SQLException sqlException) {
            System.err.println("SQL Exception: " + sqlException.getMessage());
        }
    }

}
