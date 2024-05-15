package org.VehicleCase;

public class HondaJazz extends Car {
    private boolean ecoMode;

    // Constructor
    public HondaJazz(String color, double speed, double fuelCapacity, String transmissionType, boolean ecoMode) {
        super(color, speed, fuelCapacity, transmissionType);
        this.ecoMode = ecoMode;
    }

    // Getters and Setters
    public boolean isEcoMode() {
        return ecoMode;
    }

    public void setEcoMode(boolean ecoMode) {
        this.ecoMode = ecoMode;
    }

    // Specific Methods for HondaJazz
    public void toggleEcoMode() {
        ecoMode = !ecoMode;
        System.out.println("Eco mode is now " + (ecoMode ? "ON" : "OFF"));
    }

    @Override
    public void moveForward() {
        System.out.println("The Honda Jazz is moving forward in " + (ecoMode ? "eco" : "normal") + " mode.");
    }
}

