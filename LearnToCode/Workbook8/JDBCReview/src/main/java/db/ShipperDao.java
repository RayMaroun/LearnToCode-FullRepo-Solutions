package db;

import models.Shipper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShipperDao {

    private DataSource dataSource;

    public ShipperDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int addShipper(Shipper shipper) {
        // SQL query to insert a new shipper into the shippers table
        String query = "insert into shippers (CompanyName, Phone) values (?,?);";
        int keyReturned = 0;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

            // Set the parameter values for the insert query
            preparedStatement.setString(1, shipper.getCompanyName());
            preparedStatement.setString(2, shipper.getPhone());

            // Execute the insert query
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows affected!");

            try (ResultSet keys = preparedStatement.getGeneratedKeys();) {
                while (keys.next()) {
                    // Retrieve the generated key (shipper ID)
                    keyReturned = keys.getInt(1);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return keyReturned;
    }

    public void updateShipper(Shipper updatedShipper) {

        // SQL query to update an existing shipper in the shippers table
        String query = "UPDATE shippers SET CompanyName = ?, Phone = ? WHERE shipperID = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            // Set the parameter values for the update query
            preparedStatement.setString(1, updatedShipper.getCompanyName());
            preparedStatement.setString(2, updatedShipper.getPhone());
            preparedStatement.setInt(3, updatedShipper.getShipperID());

            // Execute the update query
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows affected!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteShipper(int shipperID) {

        // SQL query to delete a shipper from the shippers table based on the shipper ID
        String query = "DELETE FROM shippers WHERE shipperID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the parameter value for the delete query
            preparedStatement.setInt(1, shipperID);

            // Execute the delete query
            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows affected!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
