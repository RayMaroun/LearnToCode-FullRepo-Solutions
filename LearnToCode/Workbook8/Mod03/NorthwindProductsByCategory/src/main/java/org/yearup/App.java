package org.yearup;

import java.sql.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/northwind",
                "root",
                "P@ssw0rd");
             PreparedStatement statement = connection.prepareStatement("SELECT CategoryID, CategoryName FROM Categories ORDER BY CategoryID");
             ResultSet resultSet = statement.executeQuery()) {

            // Display categories
            System.out.println("Categories:");
            while (resultSet.next()) {
                int categoryId = resultSet.getInt("CategoryID");
                String categoryName = resultSet.getString("CategoryName");
                System.out.println(categoryId + ": " + categoryName);
            }

            // Prompt the user for category ID
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the category ID: ");
            int categoryId = scanner.nextInt();

            // Query products by category ID
            String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products WHERE CategoryID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, categoryId);
                ResultSet productResultSet = preparedStatement.executeQuery();

                // Display products
                System.out.println("\nProducts in the selected category:");
                while (productResultSet.next()) {
                    int productId = productResultSet.getInt("ProductID");
                    String productName = productResultSet.getString("ProductName");
                    double unitPrice = productResultSet.getDouble("UnitPrice");
                    int unitsInStock = productResultSet.getInt("UnitsInStock");

                    System.out.println("Product ID: " + productId);
                    System.out.println("Product Name: " + productName);
                    System.out.println("Unit Price: " + unitPrice);
                    System.out.println("Units In Stock: " + unitsInStock);
                    System.out.println("-----------------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
