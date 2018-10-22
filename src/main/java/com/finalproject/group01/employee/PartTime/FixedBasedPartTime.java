package com.finalproject.group01.employee.PartTime;

import com.finalproject.group01.exceptions.InvalidEarningsException;
import com.finalproject.group01.utils.Formatting;
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
        double earnings = rateTimesHoursWorked + this.fixedAmount;

        try {
            if(earnings < 1000) {
                throw new InvalidEarningsException("The employee " + this.getName() + " has Earnings less than $1,000. Adjust his/her earnings before continue.");
            }
        } catch (InvalidEarningsException e) {
            System.out.println(e.getErrorMessage());
            System.exit(0);
        }
        return earnings;
    }

    @Override
    public String printMyData() {
        Formatting format = new Formatting();

        String message = super.printMyData();
        message += "Fixed Amount\n";
        message += "- Rate: " + format.getCurrencyFormatter(this.getRate()) + "\n";
        message += "- Hours Worked: " + this.getHoursWorked()+ " \n";
        message += "- Fixed Amount: " + format.getCurrencyFormatter(this.fixedAmount) + "\n";
        message += "- Earnings: " + format.getCurrencyFormatter(calcEarnings()) + " (" + format.getCurrencyFormatter(this.rateTimesHoursWorked) + " + " + format.getCurrencyFormatter(this.fixedAmount) + ")\n";
        message += "************************************\n";
        return message;

    }

}
