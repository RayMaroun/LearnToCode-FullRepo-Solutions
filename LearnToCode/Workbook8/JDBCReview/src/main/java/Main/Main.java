package Main;

import db.ProductDao;
import db.ShipperDao;
import models.Product;
import models.Shipper;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        ProductDao productDao = new ProductDao(basicDataSource);

        List<Product> productList = productDao.getAllProducts();

        System.out.println("Products:");
        System.out.println("===============================================");
        for(Product product : productList){
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Unit Price: " + product.getUnitPrice());
            System.out.println("Units In Stock: " + product.getUnitsInStock());
            System.out.println("===============================================");
        }

        System.out.println();
        System.out.println("Please enter a product ID to search:");
        Scanner scanner = new Scanner(System.in);
        int productIDFromUser = scanner.nextInt();
        scanner.nextLine();

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

        Shipper shipper = new Shipper(companyName,phone);
        ShipperDao shipperDao = new ShipperDao(basicDataSource);

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

        Shipper updatedShipper = new Shipper(shipperIDToUpdate,updatedCompanyName,updatedPhoneNumber);
        shipperDao.updateShipper(updatedShipper);

        System.out.println("===============================================");

        System.out.println("Please enter a shipper id to delete:");
        int shipperIDToDelete = scanner.nextInt();

        shipperDao.deleteShipper(shipperIDToDelete);


    }
}
