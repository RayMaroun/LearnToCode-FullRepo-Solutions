package db;

import models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private DataSource dataSource;

    public ProductDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAllProducts() {

        List<Product> products = new ArrayList<>();

        String query = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM Products;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet results = preparedStatement.executeQuery();) {

            while (results.next()) {
                int productId = results.getInt("ProductID");
                String productName = results.getString("ProductName");
                double unitPrice = results.getDouble("UnitPrice");
                int unitsInStock = results.getInt("UnitsInStock");

                Product product = new Product(productId, productName, unitPrice, unitsInStock);
                products.add(product);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public Product getProduct(int productID) {

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

                    product = new Product(productId, productName, unitPrice, unitsInStock);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return product;
    }
}
