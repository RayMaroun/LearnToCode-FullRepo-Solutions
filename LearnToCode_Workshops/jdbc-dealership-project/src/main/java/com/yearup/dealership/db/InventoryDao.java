package com.yearup.dealership.db;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        String query = "INSERT INTO inventory (dealership_id,vin) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, dealershipId);
            statement.setString(2, vin);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding vehicle to inventory: " + e.getMessage());
        }
    }

    public void removeVehicleFromInventory(String vin) {
        String query = "DELETE FROM inventory WHERE vin = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, vin);

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error removing vehicle from inventory: " + e.getMessage());
        }
    }
}