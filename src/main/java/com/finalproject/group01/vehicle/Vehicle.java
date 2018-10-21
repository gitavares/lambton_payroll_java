package com.finalproject.group01.vehicle;

import com.finalproject.group01.exceptions.InvalidFieldException;
import com.finalproject.group01.utils.IPrintable;

public abstract class Vehicle implements IPrintable {

    private String make;
    private String plate;

    public Vehicle(String make, String plate) {
        this.make = make;
        this.plate = plate;
        checkUnset();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
        checkUnset();
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
        checkUnset();
    }

    public void checkUnset(){
        try {
            if (this.getMake() == null) {
                throw new InvalidFieldException("The vehicle must have a Make. Please, adjust this before continue.");
            }
            if (this.getPlate() == null) {
                throw new InvalidFieldException("The vehicle must have a Plate. Please, adjust this before continue.");
            }
        } catch (InvalidFieldException e) {
            System.out.println(e.getErrorMessage());
            System.exit(0);
        }
    }

    @Override
    public String printMyData() {
        return "";
    }
}
