package com.finalproject.group01.employee;

import com.finalproject.group01.vehicle.Vehicle;

public class CommissionBasedPartTime extends PartTime {

    private double commisionPerc;
    private double rateTimesHoursWorked;

    public CommissionBasedPartTime(String name, int age, Vehicle vehicle, double rate, double hoursWorked) {
        super(name, age, vehicle, rate, hoursWorked);
    }

//    rateTimesHoursWorked = PartTime().calcEarnings()

}
