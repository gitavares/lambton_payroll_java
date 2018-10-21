package com.finalproject.group01.employee;

import com.finalproject.group01.utils.IPrintable;
import com.finalproject.group01.vehicle.Vehicle;

import java.time.Year;

public abstract class Employee implements IPrintable {

    private String name;
    private int age;
    private Vehicle vehicle;

    // constructors
    public Employee(String name, int age, Vehicle vehicle) {
        this.name = name;
        this.age = age;
        this.vehicle = vehicle;
    }

    // gets and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    // methods
    public int calcBirthYear() {
        return Year.now().getValue() - this.age;
    }

    public double calcEarnings() {
        try {

        } catch (Exception e) {
            System.out.println(e);
        }
        return 1000;
    }

    @Override
    public String printMyData() {

        String message = "Name: " + this.name + "\n";
        message += "Year of Birth: " + calcBirthYear() + "\n";

        if(this.vehicle == null) {
            message += "Employee has no Vehicle registered\n";
        } else {
            message += this.vehicle.printMyData();
        }

        return message;

    }
}
