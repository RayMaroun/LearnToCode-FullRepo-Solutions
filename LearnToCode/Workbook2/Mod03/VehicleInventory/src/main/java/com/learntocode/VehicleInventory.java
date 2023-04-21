package com.learntocode;

import java.util.Scanner;

public class VehicleInventory {
    private static Vehicle[] vehicles = new Vehicle[20];
    private static int numVehicles = 6;

    public static void main(String[] args) {
        // preloading the array with some vehicles

        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 32775, 12250.00f);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Silver", 42000, 14999.99f);
        vehicles[2] = new Vehicle(101123, "Honda Civic", "Black", 25000, 15999.99f);
        vehicles[3] = new Vehicle(101124, "Jeep Wrangler", "Green", 38000, 25999.99f);
        vehicles[4] = new Vehicle(101125, "Nissan Altima", "White", 30000, 12999.99f);
        vehicles[5] = new Vehicle(101126, "Chevy Tahoe", "Blue", 42000, 28999.99f);

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("  1 - Find vehicles that match make/model");
            System.out.println("  2 - Find vehicles that fall within a price range");
            System.out.println("  3 - Find vehicles that match a color");
            System.out.println("  4 - List all vehicles");
            System.out.println("  5 - Add a vehicle");
            System.out.println("  6 - Quit");
            System.out.println("Enter your command:");

            int command = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (command) {
                case 1:
                    findVehiclesByMakeModel(scanner);
                    break;
                case 2:
                    findVehiclesByPrice(scanner);
                    break;
                case 3:
                    findVehiclesByColor(scanner);
                    break;
                case 4:
                    listAllVehicles();
                    break;
                case 5:
                    addVehicle(scanner);
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    public static void addVehicle(Scanner scanner) {
        if (numVehicles < 20) {
            System.out.print("Enter vehicle ID: ");
            long id = scanner.nextLong();
            scanner.nextLine(); // Consume new line character

            System.out.print("Enter make and model: ");
            String makeModel = scanner.nextLine();

            System.out.print("Enter color: ");
            String color = scanner.nextLine();

            System.out.print("Enter odometer reading: ");
            int odometerReading = scanner.nextInt();

            System.out.print("Enter price: ");
            float price = scanner.nextFloat();

            Vehicle newVehicle = new Vehicle(id, makeModel, color, odometerReading, price);
            vehicles[numVehicles] = newVehicle;
            numVehicles++;
            System.out.println("Vehicle added.");
        } else {
            System.out.println("Vehicle inventory is full");
        }
    }

    public static void listAllVehicles() {
        System.out.println("Vehicle inventory:");
        for (int i = 0; i < numVehicles; i++) {
            System.out.println(vehicles[i].getVehicleId() + " | " + vehicles[i].getMakeModel() + " | " + vehicles[i].getColor() + " | " + vehicles[i].getOdometerReading() + " miles | $" + vehicles[i].getPrice());
        }
    }

    public static void findVehiclesByMakeModel(Scanner scanner) {
        System.out.print("Enter make and model: ");
        String makeModel = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < numVehicles; i++) {
            if (vehicles[i].getMakeModel().equalsIgnoreCase(makeModel)) {
                System.out.println(vehicles[i].getVehicleId() + " | " + vehicles[i].getMakeModel() + " | " + vehicles[i].getColor() + " | " + vehicles[i].getOdometerReading() + " miles | $" + vehicles[i].getPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found");
        }
    }

    public static void findVehiclesByPrice(Scanner scanner) {
        System.out.print("Enter minimum price: ");
        float minPrice = scanner.nextFloat();

        System.out.print("Enter maximum price: ");
        float maxPrice = scanner.nextFloat();

        boolean found = false;
        for (int i = 0; i < numVehicles; i++) {
            if (vehicles[i].getPrice() >= minPrice && vehicles[i].getPrice() <= maxPrice) {
                System.out.println(vehicles[i].getVehicleId() + " | " + vehicles[i].getMakeModel() + " | " + vehicles[i].getColor() + " | " + vehicles[i].getOdometerReading() + " miles | $" + vehicles[i].getPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found");
        }
    }

    public static void findVehiclesByColor(Scanner scanner) {
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < numVehicles; i++) {
            if (vehicles[i].getColor().equalsIgnoreCase(color)) {
                System.out.println(vehicles[i].getVehicleId() + " | " + vehicles[i].getMakeModel() + " | " + vehicles[i].getColor() + " | " + vehicles[i].getOdometerReading() + " miles | $" + vehicles[i].getPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found");
        }
    }
}

