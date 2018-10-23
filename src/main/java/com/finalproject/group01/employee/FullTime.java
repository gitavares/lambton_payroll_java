package com.finalproject.group01.employee;

import com.finalproject.group01.exceptions.InvalidEarningsException;
import com.finalproject.group01.utils.Formatting;
import com.finalproject.group01.vehicle.Vehicle;

public class FullTime extends Employee {

    private double salary;
    private double bonus;
    private FullTime fullTime;

    public FullTime() {

    }

    public FullTime(int id, String name, int age, Vehicle vehicle, double salary, double bonus) {
        super(id, name, age, vehicle);
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

    public FullTime getFullTime() {
        return fullTime;
    }

    @Override
    public double calcEarnings() {
        double earnings = this.salary + this.bonus;
        try {
            if(earnings < 1000) {
                throw new InvalidEarningsException("The employee " + this.getName() + " has Earnings less than $1,000. Adjust his/her earnings before continue.");
            }
        } catch (InvalidEarningsException e) {
            System.out.println(e.getErrorMessage());
        }
        return earnings;
    }

    @Override
    public String printMyData() {
        Formatting format = new Formatting();

        String message = super.printMyData();
        message += "Employee is FullTime\n";
        message += "- Salary: " + format.getCurrencyFormatter(this.salary) + "\n";
        message += "- Bonus: " + format.getCurrencyFormatter(this.bonus) + "\n";
        message += "- Earnings: " + format.getCurrencyFormatter(calcEarnings()) + " (" + format.getCurrencyFormatter(this.salary) + " + " + format.getCurrencyFormatter(this.bonus) + ")" + "\n";
        message += "************************************\n";
        return message;
    }
}
