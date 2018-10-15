package com.finalproject.group01.employee;

import com.finalproject.group01.vehicle.Vehicle;

public class Intern extends Employee {

    private String schoolName;

    public Intern(String name, int age, Vehicle vehicle, String schoolName) {
        super(name, age, vehicle);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public double calcEarnings() {
        return super.calcEarnings();
    }

    @Override
    public String printMyData() {
        String message = super.printMyData();
        message += "Employee is Intern\n";
        message += "- School Name: " + this.schoolName + "\n";
        message += "- Earnings: " + calcEarnings() + "\n";
        message += "************************************\n";
        return message;
    }
}
