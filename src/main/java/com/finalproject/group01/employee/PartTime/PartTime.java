package com.finalproject.group01.employee.PartTime;

import com.finalproject.group01.employee.Employee;
import com.finalproject.group01.vehicle.Vehicle;

public abstract class PartTime extends Employee {

    private double rate;
    private double hoursWorked;

    public PartTime(String name, int age, Vehicle vehicle, double rate, double hoursWorked) {
        super(name, age, vehicle);
        this.rate = rate;
        this.hoursWorked = hoursWorked;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calcEarnings() {
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
        return this.rate * this.hoursWorked;
    }

    @Override
    public String printMyData() {

        String message = super.printMyData();
        message += "Employee is PartTime / ";
        return message;
    }
}
