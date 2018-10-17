package com.finalproject.group01.employee.PartTime;

import com.finalproject.group01.vehicle.Vehicle;

public class FixedBasedPartTime extends PartTime {

    private double fixedAmount;
    private double rateTimesHoursWorked;

    public FixedBasedPartTime(String name, int age, Vehicle vehicle, double rate, double hoursWorked, double fixedAmount) {
        super(name, age, vehicle, rate, hoursWorked);
        this.fixedAmount = fixedAmount;
    }

    public double getFixedAmount() {
        return fixedAmount;
    }

    public void setFixedAmount(double fixedAmount) {
        this.fixedAmount = fixedAmount;
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
        return rateTimesHoursWorked + this.fixedAmount;
    }

    @Override
    public String printMyData() {
        String message = super.printMyData();
        message += "Fixed Amount\n";
        message += "- Rate: " + this.getRate() + "\n";
        message += "- Hours Worked: " + this.getHoursWorked()+ " \n";
        message += "- Fixed Amount: " + this.fixedAmount + "\n";
        message += "- Earnings: " + calcEarnings() + "(" + this.rateTimesHoursWorked + " + " + this.fixedAmount + ")\n";
        message += "************************************\n";
        return message;

    }

}
