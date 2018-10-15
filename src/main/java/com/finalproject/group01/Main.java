package com.finalproject.group01;

import com.finalproject.group01.employee.FullTime;
import com.finalproject.group01.employee.Intern;
import com.finalproject.group01.vehicle.Car;
import com.finalproject.group01.vehicle.Motorcycle;

public class Main {

    public static void main(String[] args) {


        // Vehicle - Car
        Car car1 = new Car("BMW", "GT7689", 4, true);
        car1.setMake("Mercedez");

        // Vehicle - Motorcycle
        Motorcycle motorcycle1 = new Motorcycle("Harley Davidson", "DFR432", 300, true);


        // FT
        FullTime ft1 = new FullTime("Peter", 30, car1, 10000, 1000);
        ft1.calcEarnings();
        ft1.calcBirthYear();
        System.out.println(ft1.printMyData());

        // Intern
        Intern i1 = new Intern("Jesse", 21, motorcycle1, "Lambton");
        i1.calcEarnings();
        System.out.println(i1.printMyData());

    }
}
