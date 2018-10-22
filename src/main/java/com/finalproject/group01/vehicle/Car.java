package com.finalproject.group01.vehicle;

import com.finalproject.group01.exceptions.InvalidFieldException;

public class Car extends Vehicle {

    private int doorsQuantity;
    private boolean hasSunroof;


    public Car(String make, String plate, int doorsQuantity, boolean hasSunroof) {
        super(make, plate);
        this.doorsQuantity = doorsQuantity;
        this.hasSunroof = hasSunroof;
    }

    public int getDoorsQuantity() {
        return doorsQuantity;
    }

    public void setDoorsQuantity(int doorsQuantity) {
        this.doorsQuantity = doorsQuantity;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    @Override
    public String printMyData() {
        String message = "Employee has a Car\n";
        message += "- Make: " + this.getMake() + "\n";
        message += "- Plate: " + this.getPlate() + " \n";
        message += "- Doors Quantity: " + this.doorsQuantity + " \n";

        if (this.hasSunroof) {
            message += "- The car has Sunroof\n";
        }

        return message;
    }
}
