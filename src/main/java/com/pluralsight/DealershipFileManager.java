package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    private static final String DEALERSHIP_FILE_PATH = "src/main/resources/inventory.csv";

    public Dealership getDealership() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DEALERSHIP_FILE_PATH))) {
            // Read dealership information from the first line
            String[] dealershipInfo = reader.readLine().split("\\|");
            String name = dealershipInfo[0];
            String address = dealershipInfo[1];
            String phone = dealershipInfo[2];

            // Create a new Dealership object
            Dealership dealership = new Dealership(name, address, phone);

            // Read vehicle information from the remaining lines
            String line;
            while ((line = reader.readLine()) != null) {
                String[] vehicleInfo = line.split("\\|");
                int vin = Integer.parseInt(vehicleInfo[0]);
                int year = Integer.parseInt(vehicleInfo[1]);
                String make = vehicleInfo[2];
                String model = vehicleInfo[3];
                String vehicleType = vehicleInfo[4];
                String color = vehicleInfo[5];
                int odometer = Integer.parseInt(vehicleInfo[6]);
                double price = Double.parseDouble(vehicleInfo[7]);

                // Create a new Vehicle object and add it to the dealership's inventory
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }

            return dealership;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DEALERSHIP_FILE_PATH))) {
            // Write dealership information to the first line
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            // Write vehicle information for each vehicle in the inventory
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|"
                        + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|"
                        + vehicle.getOdometer() + "|" + vehicle.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
