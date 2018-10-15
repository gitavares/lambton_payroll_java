package com.finalproject.group01.vehicle;

public class Motorcycle extends Vehicle {

    private int powerCC;
    private boolean hasLuggageRack;

    public Motorcycle(String make, String plate, int powerCC, boolean hasLuggageRack) {
        super(make, plate);
        this.powerCC = powerCC;
        this.hasLuggageRack = hasLuggageRack;
    }

    public int getPowerCC() {
        return powerCC;
    }

    public void setPowerCC(int powerCC) {
        this.powerCC = powerCC;
    }

    public boolean isHasLuggageRack() {
        return hasLuggageRack;
    }

    public void setHasLuggageRack(boolean hasLuggageRack) {
        this.hasLuggageRack = hasLuggageRack;
    }

    @Override
    public String printMyData() {
        String message = "Employee has a Motorcycle\n";
        message += "- Make: " + this.getMake() + " \n";
        message += "- Plate: " + this.getPlate() + "\n";
        message += "- Power CC: " + this.powerCC + "\n";
        if (this.hasLuggageRack) {
                message += "- The motorcycle has Luggage Rack\n";
        }
        return message;
    }
}
