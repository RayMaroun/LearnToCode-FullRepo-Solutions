package Main;

import db.ProductDao;
import db.ShipperDao;
import models.CustomerOrderHistory;
import models.Product;
import models.Shipper;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Retrieve username and password from command-line arguments
        String username = args[0];
        String password = args[1];

        // Create a connection pool using BasicDataSource
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        Scanner scanner = new Scanner(System.in);

        // Create a ProductDao instance with the connection pool
        ProductDao productDao = new ProductDao(basicDataSource);

        // Get all products from the database
        List<Product> productList = productDao.getAllProducts();

        System.out.println("Products:");
        System.out.println("===============================================");
        // Display information for each product
        for(Product product : productList){
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Unit Price: " + product.getUnitPrice());
            System.out.println("Units In Stock: " + product.getUnitsInStock());
            System.out.println("===============================================");
        }

        System.out.println();
        System.out.println("Please enter a product ID to search:");
        int productIDFromUser = scanner.nextInt();
        scanner.nextLine();

        // Get a specific product based on the entered product ID
        Product product = productDao.getProduct(productIDFromUser);
        System.out.println("===============================================");
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Unit Price: " + product.getUnitPrice());
        System.out.println("Units In Stock: " + product.getUnitsInStock());
        System.out.println("===============================================");

        System.out.println("Please enter a Company Name:");
        String companyName = scanner.nextLine();

        System.out.println("Please enter a Phone Number:");
        String phone = scanner.nextLine();

        // Create a new Shipper instance with the entered company name and phone number
        Shipper shipper = new Shipper(companyName,phone);
        ShipperDao shipperDao = new ShipperDao(basicDataSource);

        // Add the shipper to the database and get the generated ID
        int generatedID = shipperDao.addShipper(shipper);
        System.out.println("The id that is generated is: " + generatedID);

        System.out.println("===============================================");

        System.out.println("Please enter the ID of the shipper you want to update:");
        int shipperIDToUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter an updated Company Name:");
        String updatedCompanyName = scanner.nextLine();

        System.out.println("Please enter an updated Phone Number:");
        String updatedPhoneNumber = scanner.nextLine();

        // Create an updated Shipper instance with the entered information
        Shipper updatedShipper = new Shipper(shipperIDToUpdate,updatedCompanyName,updatedPhoneNumber);
        shipperDao.updateShipper(updatedShipper);

        System.out.println("===============================================");

        System.out.println("Please enter a shipper id to delete:");
        int shipperIDToDelete = scanner.nextInt();
        scanner.nextLine();

        // Delete the shipper from the database based on the entered ID
        shipperDao.deleteShipper(shipperIDToDelete);

        System.out.println("===============================================");

        System.out.println("Please enter a Customer ID to search for the order history:");
        String customerID = scanner.nextLine();

        // Get the order histories for a specific customer from the database
        List<CustomerOrderHistory> orderHistories =  productDao.getCustomerOrderHistory(customerID);

        System.out.println("Order Histories:");
        System.out.println("===============================================");
        // Display information for each order history
        for(CustomerOrderHistory customerOrderHistory : orderHistories){
            System.out.println("Product Name: " + customerOrderHistory.getProductName());
            System.out.println("Total: " + customerOrderHistory.getTotal());
            System.out.println("===============================================");
        }
    }
}
