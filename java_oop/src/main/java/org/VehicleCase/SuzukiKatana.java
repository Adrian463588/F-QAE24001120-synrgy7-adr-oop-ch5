package org.VehicleCase;

public class SuzukiKatana extends Car {
    private boolean roofRack;

    // Constructor
    public SuzukiKatana(String color, double speed, double fuelCapacity, String transmissionType, boolean roofRack) {
        super(color, speed, fuelCapacity, transmissionType);
        this.roofRack = roofRack;
    }

    // Getters and Setters
    public boolean hasRoofRack() {
        return roofRack;
    }

    public void setRoofRack(boolean roofRack) {
        this.roofRack = roofRack;
    }

    // Specific Methods for SuzukiKatana
    public void toggleRoofRack() {
        roofRack = !roofRack;
        System.out.println("Roof rack is now " + (roofRack ? "INSTALLED" : "REMOVED"));
    }

    @Override
    public void refuel(double amount) {
        if (amount > 0 && amount <= getFuelCapacity()) {
            System.out.println("The Suzuki Katana is refueled with " + amount + " liters of fuel.");
        } else {
            System.out.println("Invalid fuel amount. Please enter a value between 0 and " + getFuelCapacity() + ".");
        }
    }
}

