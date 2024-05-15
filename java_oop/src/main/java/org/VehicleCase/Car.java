package org.VehicleCase;

public class Car extends Vehicle {
    private double fuelCapacity;
    private String transmissionType;

    // Constructor
    public Car(String color, double speed, double fuelCapacity, String transmissionType) {
        super(4, color, speed); // A car typically has 4 wheels
        this.fuelCapacity = fuelCapacity;
        this.transmissionType = transmissionType;
    }

    // Getters and Setters
    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    // Specific Methods for Car
    public void refuel(double amount) {
        if (amount > 0 && amount <= fuelCapacity) {
            System.out.println("The car is refueled with " + amount + " liters of fuel.");
        } else {
            System.out.println("Invalid fuel amount. Please enter a value between 0 and " + fuelCapacity + ".");
        }
    }

    public void changeGear(String gear) {
        System.out.println("The car is changing to " + gear + " gear.");
    }

    @Override
    public void moveForward() {
        System.out.println("The car is moving forward.");
    }

    @Override
    public void turn(String direction) {
        System.out.println("The car is turning " + direction + ".");
    }
}

