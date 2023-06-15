package db;

import models.CustomerOrderHistory;
import models.Product;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private DataSource dataSource;

    public ProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        // SQL query to retrieve all products from the database
        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet results = preparedStatement.executeQuery();) {

            // Iterate over the results and create Product objects
            while (results.next()) {
                int productId = results.getInt("ProductID");
                String productName = results.getString("ProductName");
                double unitPrice = results.getDouble("UnitPrice");
                int unitsInStock = results.getInt("UnitsInStock");

                // Create a Product object and add it to the list
                Product product = new Product(productId, productName, unitPrice, unitsInStock);
                products.add(product);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public Product getProduct(int productID) {

        // SQL query to retrieve a specific product based on the product ID
        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products WHERE ProductID = ?;";
        Product product = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setInt(1, productID);

            try (ResultSet results = preparedStatement.executeQuery()) {
                while (results.next()) {
                    int productId = results.getInt("ProductID");
                    String productName = results.getString("ProductName");
                    double unitPrice = results.getDouble("UnitPrice");
                    int unitsInStock = results.getInt("UnitsInStock");

                    // Create a Product object for the retrieved product
                    product = new Product(productId, productName, unitPrice, unitsInStock);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }

    public List<CustomerOrderHistory> getCustomerOrderHistory(String customerID) {

        List<CustomerOrderHistory> customerOrderHistories = new ArrayList<>();

        // SQL query to call a stored procedure for retrieving customer order history
        String query = "{CALL CustOrderHist(?)}";

        try (Connection connection = dataSource.getConnection();
             CallableStatement callableStatement = connection.prepareCall(query)) {

            callableStatement.setString(1, customerID);

            try (ResultSet results = callableStatement.executeQuery()) {

                // Iterate over the results and create CustomerOrderHistory objects
                while (results.next()) {
                    String productName = results.getString("ProductName");
                    int total = results.getInt("Total");

                    // Create a CustomerOrderHistory object and add it to the list
                    CustomerOrderHistory customerOrderHistory = new CustomerOrderHistory(productName, total);
                    customerOrderHistories.add(customerOrderHistory);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return customerOrderHistories;
    }
}
