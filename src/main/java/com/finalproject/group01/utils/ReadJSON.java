package com.finalproject.group01.utils;

import com.finalproject.group01.employee.Employee;
import com.finalproject.group01.employee.FullTime;
import com.finalproject.group01.employee.Intern;
import com.finalproject.group01.employee.PartTime.CommissionBasedPartTime;
import com.finalproject.group01.employee.PartTime.FixedBasedPartTime;
import com.finalproject.group01.payroll.Payroll;
import com.finalproject.group01.vehicle.Car;
import com.finalproject.group01.vehicle.Motorcycle;
import com.finalproject.group01.vehicle.Vehicle;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class ReadJSON {

    public void readJson() throws IOException {
        String fileName = "Employees.json";

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            String content = IOUtils.toString(classLoader.getResourceAsStream(fileName));

            getData(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getData(String jsonString)
    {
        JSONArray employeeJsonArray = new JSONArray(jsonString);
        Payroll payrollSingleton = Payroll.getInstance();


        for (int i = 0; i < employeeJsonArray.length(); i++) {
            JSONObject employee = new JSONObject(employeeJsonArray.get(i).toString());
            int id = employee.getInt("id");
            String name = employee.getString("name");
            int age = employee.getInt("age");

            JSONObject employment = new JSONObject(employee.getJSONObject("employment").toString());
            String employmentType = employment.getString("type");
            Employee myEmployee = null;
            Vehicle myVehicle = null;


            if (employee.has("vehicle") && employee.getJSONObject("vehicle") != null) {
                JSONObject vehicle = new JSONObject(employee.getJSONObject("vehicle").toString());
                String vehicleType = vehicle.getString("type");
                String make = vehicle.getString("make");
                String plate = vehicle.getString("plate");
                if (vehicleType.equals("Car")) {
                    int doorsQuantity = vehicle.getInt("doorsQuantity");
                    boolean hasSunroof = vehicle.getBoolean("hasSunroof");

                    myVehicle = new Car(make, plate, doorsQuantity, hasSunroof);


                } else if (vehicleType.equals("Motorcycle")) {
                    int powerCC = vehicle.getInt("powerCC");
                    boolean hasLuggageRack = vehicle.getBoolean("hasLuggageRack");

                    myVehicle = new Motorcycle(make, plate, powerCC, hasLuggageRack);

                }


                if (employmentType.equals("FullTime")) {
                    Double salary = employment.getDouble("salary");

                    Double bonus = 0.0;
                    if (employment.has("bonus")) {
                        bonus = employment.getDouble("bonus");
                    }

                    myEmployee = new FullTime(id, name, age, myVehicle, salary, bonus);


                } else if (employmentType.equals("Intern")) {
                    String schoolName = employment.getString("schoolName");

                    myEmployee = new Intern(id, name, age, myVehicle, schoolName);

                } else if (employmentType.equals("CommissionBasedPartTime")) {
                    Double rate = employment.getDouble("rate");
                    Double hoursWorked = employment.getDouble("hoursWorked");
                    Double commisionPerc = employment.getDouble("commisionPerc");

                    myEmployee = new CommissionBasedPartTime(id, name, age, myVehicle, rate, hoursWorked, commisionPerc);

                } else if (employmentType.equals("FixedAmountPartTime")) {
                    Double rate = employment.getDouble("rate");
                    Double hoursWorked = employment.getDouble("hoursWorked");
                    Double fixedAmount = employment.getDouble("fixedAmount");

                    myEmployee = new FixedBasedPartTime(id, name, age, myVehicle, rate, hoursWorked, fixedAmount);
                }

                payrollSingleton.saveEmployeeOnPayroll(myEmployee);
            }

        }

        System.out.println("==== START FROM JSON =======");
        System.out.println(payrollSingleton.printMyData());
        System.out.println("==== END FROM JSON =========");

    }
}
