package com.finalproject.group01.employee.PartTime;

import com.finalproject.group01.vehicle.Vehicle;

public class CommissionBasedPartTime extends PartTime {

    private double commisionPerc;
    private double rateTimesHoursWorked;

    public CommissionBasedPartTime(String name, int age, Vehicle vehicle, double rate, double hoursWorked, double commisionPerc) {
        super(name, age, vehicle, rate, hoursWorked);
        this.commisionPerc = commisionPerc;
    }

    public double getCommisionPerc() {
        return commisionPerc;
    }

    public void setCommisionPerc(double commisionPerc) {
        this.commisionPerc = commisionPerc;
    }

    public double getRateTimesHoursWorked() {
        return rateTimesHoursWorked;
    }

    public void setRateTimesHoursWorked(double rateTimesHoursWorked) {
        this.rateTimesHoursWorked = rateTimesHoursWorked;
    }

    @Override
    public double calcEarnings() {
        rateTimesHoursWorked = super.calcEarnings();
        return (rateTimesHoursWorked * this.commisionPerc/100) + rateTimesHoursWorked;
    }

    @Override
    public String printMyData() {
        String message = super.printMyData();
        message += "Commissioned\n";
        message += "- Rate: " + this.getRate() + "\n";
        message += "- Hours Worked: " + this.getHoursWorked()+ " \n";
        message += "- Commission: " + this.commisionPerc + " \n";
        message += "- Earnings: " + calcEarnings() + "(" + this.rateTimesHoursWorked + " + " + this.commisionPerc + "  of " + this.rateTimesHoursWorked + ")\n";
        message += "************************************\n";
        return message;

    }
}
