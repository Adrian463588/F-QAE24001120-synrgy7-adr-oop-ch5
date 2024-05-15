package org.VehicleCase;

public class Vehicle {
    private int numberOfWheels;
    private String color;
    private double speed;

    // Constructor
    public Vehicle(int numberOfWheels, String color, double speed) {
        this.numberOfWheels = numberOfWheels;
        this.color = color;
        this.speed = speed;
    }

    // Getters and Setters
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    // Methods
    public void moveForward() {
        System.out.println("The vehicle is moving forward.");
    }

    public void turn(String direction) {
        System.out.println("The vehicle is turning " + direction + ".");
    }
}

