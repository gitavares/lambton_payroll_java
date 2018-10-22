package com.finalproject.group01;

import com.finalproject.group01.employee.FullTime;
import com.finalproject.group01.employee.Intern;
import com.finalproject.group01.employee.PartTime.CommissionBasedPartTime;
import com.finalproject.group01.employee.PartTime.FixedBasedPartTime;
import com.finalproject.group01.payroll.Payroll;
import com.finalproject.group01.utils.GenerateQRCode;
import com.finalproject.group01.vehicle.Car;
import com.finalproject.group01.vehicle.Motorcycle;
import com.google.zxing.WriterException;

import java.io.File;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {

        // tasks:
        // 1. pdf - OK
        // 2. formatting currency - OK
        // 3. create try catch - OK
        // 4. create a singleton class
        // 5. bar code OR qrcode


        // Vehicle - Car
        Car vehicleCar1 = new Car("BMW", "FHH6786", 4, true);
        Car vehicleCar2 = new Car("Mercedez", "YYT8978", 2,false);
        Car vehicleCar3 = new Car("Jeep", "GGT6578", 4, true);
        vehicleCar1.setMake("Ferrari");

        // Vehicle - Motorcycle
        Motorcycle vehicleMotorcycle1 = new Motorcycle("Harley-Davidson", "TG55RF", 600, true);
        Motorcycle vehicleMotorcycle2 = new Motorcycle("BMW", "YYT8765", 250, false);
        Motorcycle vehicleMotorcycle3 = new Motorcycle("Harley-Davidson", "BPT8711", 600, false);

        // FT
        FullTime fullTimeEmployee1 = new FullTime("Michael Jackson", 53, vehicleCar1, 5000, 300);
        FullTime fullTimeEmployee2 = new FullTime("Brad Pitt", 30, vehicleMotorcycle3, 4000, 700);

        // Intern
        Intern internEmployee1 = new Intern("Sandra de Sa", 60, vehicleMotorcycle1, "Lambton College");
        Intern internEmployee2 = new Intern("Lisa Simpson", 60, null, "Lambton College Sarnia");

        // Part Time commission based
        CommissionBasedPartTime partTimeCommissionEmployee1 = new CommissionBasedPartTime("John",35, vehicleCar2, 30, 35, 20);
        CommissionBasedPartTime partTimeCommissionEmployee2 = new CommissionBasedPartTime("Wonder Woman",37, vehicleMotorcycle2, 65, 80, 15);

        // Part Time fixed amount
        FixedBasedPartTime partTimeFixedAmountEmployee1 = new FixedBasedPartTime("Cindy", 40, null, 30, 15, 600);
        FixedBasedPartTime partTimeFixedAmountEmployee2 = new FixedBasedPartTime("Peter Parker", 40, vehicleCar3, 20, 40, 600);

        // Payroll itself - singleton class
        Payroll payrollSingleton = Payroll.getInstance();
        payrollSingleton.saveEmployeeOnPayroll(fullTimeEmployee1);
        payrollSingleton.saveEmployeeOnPayroll(internEmployee1);
        payrollSingleton.saveEmployeeOnPayroll(partTimeCommissionEmployee1);
        payrollSingleton.saveEmployeeOnPayroll(partTimeFixedAmountEmployee1);
        payrollSingleton.saveEmployeeOnPayroll(fullTimeEmployee2);
        payrollSingleton.saveEmployeeOnPayroll(internEmployee2);
        payrollSingleton.saveEmployeeOnPayroll(partTimeCommissionEmployee2);
        payrollSingleton.saveEmployeeOnPayroll(partTimeFixedAmountEmployee2);
        System.out.println(payrollSingleton.printMyData());

        // Search by Name
        System.out.println("\n\n======================================");
        System.out.println("Search employee by name");
        System.out.println("======================================");
        System.out.println(payrollSingleton.getEmployeeByName("michael"));

       //Generating a QRCode with the informtaions of an Employee
        String emp = "sandra";
        System.out.println("Generating the QRCode for " + emp);
        try {
            GenerateQRCode.generateQRCodeImage(payrollSingleton.getEmployeeByName(emp), 350, 350, "./QRCodeEmployee.png");
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }

        System.out.println("...done!");
    }
}
