package com.finalproject.group01.employee.PartTime;

import com.finalproject.group01.vehicle.Vehicle;

public class FixedBasedPartTime extends PartTime {

    private double fixedAmount;
    private double rateTimesHoursWorked;

    public FixedBasedPartTime(String name, int age, Vehicle vehicle, double rate, double hoursWorked) {
        super(name, age, vehicle, rate, hoursWorked);
    }


//    rateTimesHoursWorked = PartTime().calcEarnings()

}
