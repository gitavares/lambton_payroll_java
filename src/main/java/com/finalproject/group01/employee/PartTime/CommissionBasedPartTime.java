package com.finalproject.group01.employee.PartTime;

import com.finalproject.group01.utils.Formatting;
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
        try {
            rateTimesHoursWorked = super.calcEarnings();
        } catch (Exception e) {
            System.out.println(e);
        }
        return (rateTimesHoursWorked * this.commisionPerc/100) + rateTimesHoursWorked;
    }

    @Override
    public String printMyData() {
        Formatting format = new Formatting();

        String message = super.printMyData();
        message += "Commissioned\n";
        message += "- Rate: " + format.getCurrencyFormatter(this.getRate()) + "\n";
        message += "- Hours Worked: " + this.getHoursWorked()+ " \n";
        message += "- Commission: " + format.getPercentageFormatter(this.commisionPerc) + " \n";
        message += "- Earnings: " + format.getCurrencyFormatter(calcEarnings()) + " (" + format.getCurrencyFormatter(this.rateTimesHoursWorked) + " + " + format.getPercentageFormatter(this.commisionPerc) + " of " + format.getCurrencyFormatter(this.rateTimesHoursWorked) + ")\n";
        message += "************************************\n";
        return message;

    }
}
