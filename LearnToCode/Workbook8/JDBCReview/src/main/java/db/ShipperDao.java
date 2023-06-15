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
        String query = "insert into shippers (CompanyName, Phone) values (?,?);";
        int keyReturned = 0;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, shipper.getCompanyName());
            preparedStatement.setString(2, shipper.getPhone());

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows affected!");

            try (ResultSet keys = preparedStatement.getGeneratedKeys();) {
                while (keys.next()) {
                    keyReturned = keys.getInt(1);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return keyReturned;
    }

    public void updateShipper(Shipper updatedShipper) {

        String query = "UPDATE shippers SET CompanyName = ?, Phone = ? WHERE shipperID = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);) {

            preparedStatement.setString(1, updatedShipper.getCompanyName());
            preparedStatement.setString(2, updatedShipper.getPhone());
            preparedStatement.setInt(3, updatedShipper.getShipperID());

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows affected!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void deleteShipper(int shipperID) {

        String query = "DELETE FROM shippers WHERE shipperID = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, shipperID);

            int rows = preparedStatement.executeUpdate();
            System.out.println(rows + " rows affected!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
