package com.finalproject.group01.employee;

import com.finalproject.group01.vehicle.Vehicle;

public class FullTime extends Employee {

    private double salary;
    private double bonus;


    public FullTime(String name, int age, Vehicle vehicle, double salary, double bonus) {
        super(name, age, vehicle);
        this.salary = salary;
        this.bonus = bonus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calcEarnings() {
        return this.salary + this.bonus;
    }

    @Override
    public String printMyData() {
        String message = super.printMyData();
        message += "Employee is FullTime\n";
        message += "- Salary: " + this.salary + "\n";
        message += "- Bonus: " + this.bonus + "\n";
        message += "- Earnings: " + calcEarnings() + "\n";
        message += "************************************\n";
        return message;
    }
}
