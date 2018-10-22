package com.finalproject.group01.utils;

import com.finalproject.group01.employee.FullTime;
import com.finalproject.group01.employee.Intern;
import com.finalproject.group01.employee.PartTime.CommissionBasedPartTime;
import com.finalproject.group01.employee.PartTime.FixedBasedPartTime;
import com.finalproject.group01.payroll.Payroll;
import com.finalproject.group01.vehicle.Car;
import com.finalproject.group01.vehicle.Motorcycle;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReadJSON {

    public void readJson() throws IOException
    {
        try {
            String fileName = "./Employees.json";
//        ClassLoader classLoader = getClass().getClassLoader();



//        content = IOUtils.toString(classLoader.getResourceAsStream(fileName));
//        content = IOUtils.toString(classLoader.getResourceAsStream(fileName), StandardCharsets.UTF_8);

//        URL url = Resources.getResource("foo.txt");
//        String content = Resources.toString(url, Charsets.UTF_8);
//        String content = IOUtils.toString(this.getClass().getResourceAsStream("Employees.json"),
//                "UTF-8");

//            String content = new String(Files.readAllBytes(
//                    Paths.get(getClass().getClassLoader().getResource(fileName).toURI())));

//        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
//        if (is != null) {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//            content = reader.lines().collect(Collectors.joining(System.lineSeparator()));
//        }

            String content = null;
            content = IOUtils.toString(getClass().getClassLoader().getResourceAsStream(fileName), StandardCharsets.UTF_8);

//            System.out.println(content);
            getData(content);

        } catch(IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
//        } catch (URISyntaxException e) {
//            System.out.println("URISyntaxException");
//            e.printStackTrace();
        }


    }

    public void getData(String jsonString)
    {
//        GenerateUserDetailsPDF generateUserDetailsPDF = new GenerateUserDetailsPDF();
//        ArrayList<BIConversion.User> userArrayList = new ArrayList<>();
        JSONArray employeeJsonArray = new JSONArray(jsonString);

//        ExcelWriter mExcelWriter = new ExcelWriter();

        for (int i = 0; i < employeeJsonArray.length(); i++)
        {
            JSONObject employee = new JSONObject(employeeJsonArray.get(i).toString());
            int id = employee.getInt("id");
            String name = employee.getString("name");
            int age = employee.getInt("age");

            JSONObject employment = new JSONObject(employee.getJSONObject("employment").toString());
            String employmentType = employment.getString("type");

            FullTime fullTime = new FullTime();
            Intern intern = new Intern();
            FixedBasedPartTime partTimeFixedAmount = new FixedBasedPartTime();
            CommissionBasedPartTime partTimeCommission = new CommissionBasedPartTime();

            if(employmentType.equals("FullTime")) {
                Double salary = employment.getDouble("salary");
                Double bonus = employee.getDouble("bonus");

                fullTime = new FullTime(id, name, age, null, salary, bonus);

            } else if(employmentType.equals("Intern")) {
                String schoolName = employment.getString("schoolName");
                Double salary = employment.getDouble("salary");

                intern = new Intern(id, name, age, null, schoolName);

            } else if(employmentType.equals("CommissionBasedPartTime")) {
                Double rate = employee.getDouble("rate");
                Double hoursWorked = employee.getDouble("hoursWorked");
                Double commisionPerc = employee.getDouble("commisionPerc");

                partTimeCommission = new CommissionBasedPartTime(id, name, age, null, rate, hoursWorked, commisionPerc);

            } else if(employmentType.equals("FixedAmountPartTime")) {
                Double rate = employee.getDouble("rate");
                Double hoursWorked = employee.getDouble("hoursWorked");
                Double fixedAmount = employee.getDouble("fixedAmount");

                partTimeFixedAmount = new FixedBasedPartTime(id, name, age, null, rate, hoursWorked, fixedAmount);
            }

            if(employee.getString("vehicle") != null) {
                JSONObject vehicle = new JSONObject(employee.getJSONObject("vehicle").toString());
                String vehicleType = vehicle.getString("type");
                String make = vehicle.getString("make");
                String plate = vehicle.getString("plate");
                if(vehicleType.equals("Car")) {
                    int doorsQuantity = vehicle.getInt("doorsQuantity");
                    boolean hasSunroof = vehicle.getBoolean("hasSunroof");

                    Car car = new Car(make, plate, doorsQuantity, hasSunroof);

                    if(fullTime != null) {
                        fullTime.setVehicle(car);
                    } else if(intern != null) {
                        intern.setVehicle(car);
                    } else if(partTimeCommission != null) {
                        partTimeCommission.setVehicle(car);
                    } else if(partTimeFixedAmount != null) {
                        partTimeFixedAmount.setVehicle(car);
                    }

                } else if(vehicleType.equals("Motorcycle")) {
                    int powerCC = vehicle.getInt("powerCC");
                    boolean hasLuggageRack = vehicle.getBoolean("hasLuggageRack");

                    Motorcycle motorcycle = new Motorcycle(make, plate, powerCC, hasLuggageRack);

                    if(fullTime != null) {
                        fullTime.setVehicle(motorcycle);
                    } else if(intern != null) {
                        intern.setVehicle(motorcycle);
                    } else if(partTimeCommission != null) {
                        partTimeCommission.setVehicle(motorcycle);
                    } else if(partTimeFixedAmount != null) {
                        partTimeFixedAmount.setVehicle(motorcycle);
                    }
                }
            }

            // Payroll itself - singleton class
            Payroll payrollSingleton = Payroll.getInstance();
            if(fullTime != null) {
                payrollSingleton.saveEmployeeOnPayroll(fullTime);
            } else if(intern != null) {
                payrollSingleton.saveEmployeeOnPayroll(intern);
            } else if(partTimeCommission != null) {
                payrollSingleton.saveEmployeeOnPayroll(partTimeCommission);
            } else if(partTimeFixedAmount != null) {
                payrollSingleton.saveEmployeeOnPayroll(partTimeFixedAmount);
            }
            System.out.println("==== START FROM JSON =======");
            System.out.println(payrollSingleton.printMyData());
            System.out.println("==== END FROM JSON =========");



//
//            userArrayList.add(mUser);
//            generateUserDetailsPDF.generateUserDetailsPDF(mUser);
//            //System.out.println(mUser.toString());
//            mExcelWriter.writeDataToExcel(mUser);
        }
//        mExcelWriter.saveExcelFile();
//        generateUserDetailsPDF.setBackToTopLink();
    }
}
