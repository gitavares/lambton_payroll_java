package com.finalproject.group01.employee;

import com.finalproject.group01.exceptions.InvalidFieldException;
import com.finalproject.group01.utils.Formatting;
import com.finalproject.group01.vehicle.Vehicle;

public class Intern extends Employee {

    private String schoolName;

    public Intern() {

    }

    public Intern(int id, String name, int age, Vehicle vehicle, String schoolName) {
        super(id, name, age, vehicle);
        this.schoolName = schoolName;
        checkUnsetSchool();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
        checkUnsetSchool();
    }

    @Override
    public double calcEarnings() {
        return super.calcEarnings();
    }

    public void checkUnsetSchool(){
        try {
            if (this.getSchoolName() == null) {
                throw new InvalidFieldException("The school must have a name. Adjust this before continue.");
            }
        } catch (InvalidFieldException e) {
            System.out.println(e.getErrorMessage());
        }
    }

    @Override
    public String printMyData() {
        Formatting format = new Formatting();

        String message = super.printMyData();
        message += "Employee is Intern\n";
        message += "- School Name: " + this.schoolName + "\n";
        message += "- Earnings: " + format.getCurrencyFormatter(calcEarnings()) + "\n";
        message += "************************************\n";
        return message;
    }
}
