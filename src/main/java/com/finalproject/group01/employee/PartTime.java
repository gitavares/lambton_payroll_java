package com.finalproject.group01.employee;

import com.finalproject.group01.vehicle.Vehicle;

public abstract class PartTime extends Employee {

    private double rate;
    private double hoursWorked;

    public PartTime(String name, int age, Vehicle vehicle, double rate, double hoursWorked) {
        super(name, age, vehicle);
        this.rate = rate;
        this.hoursWorked = hoursWorked;
    }
}
