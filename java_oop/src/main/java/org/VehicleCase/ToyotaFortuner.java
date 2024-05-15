package org.VehicleCase;

public class ToyotaFortuner extends Car {
    private boolean fourWheelDrive;

    // Constructor
    public ToyotaFortuner(String color, double speed, double fuelCapacity, String transmissionType, boolean fourWheelDrive) {
        super(color, speed, fuelCapacity, transmissionType);
        this.fourWheelDrive = fourWheelDrive;
    }

    // Getters and Setters
    public boolean isFourWheelDrive() {
        return fourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        this.fourWheelDrive = fourWheelDrive;
    }

    // Specific Methods for ToyotaFortuner
    public void toggleFourWheelDrive() {
        fourWheelDrive = !fourWheelDrive;
        System.out.println("Four-wheel drive is now " + (fourWheelDrive ? "ENGAGED" : "DISENGAGED"));
    }

    @Override
    public void turn(String direction) {
        System.out.println("The Toyota Fortuner is turning " + direction + " with " + (fourWheelDrive ? "four-wheel drive" : "two-wheel drive") + ".");
    }
}

