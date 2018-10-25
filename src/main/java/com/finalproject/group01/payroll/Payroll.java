package com.finalproject.group01.payroll;

import com.finalproject.group01.employee.Employee;
import com.finalproject.group01.utils.Formatting;
import com.finalproject.group01.utils.GeneratePDF;
import com.finalproject.group01.utils.GenerateQRCode;
import com.finalproject.group01.utils.IPrintable;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Payroll implements IPrintable {

    private static Payroll payrollSingleton;
    private Map<Integer, Employee> listOfEmployeesOnPayroll;
    private double totalPayroll;

    private Payroll() {
        listOfEmployeesOnPayroll = new HashMap<>();
    }

    public static Payroll getInstance(){
        if(payrollSingleton == null) {
            payrollSingleton = new Payroll();
        }
        return payrollSingleton;
    }

    public void saveEmployeeOnPayroll(Employee employee) {
        int id = listOfEmployeesOnPayroll.size();
        listOfEmployeesOnPayroll.put(id, employee);
    }

    public Double calcTotalPayroll() {

        for(Employee employee: listOfEmployeesOnPayroll.values()){
            if(employee !=null) {
                this.totalPayroll += employee.calcEarnings();
            }
        }
        return totalPayroll;
    }

    public String getEmployeeByName(String name) {
        for(Employee employee: listOfEmployeesOnPayroll.values()) {
            if(employee.getName().toLowerCase().contains(name.toLowerCase())) {
                return employee.printMyData();
            }
        }
        return "Employee not found";
    }

    @Override
    public String printMyData() {
        String payrollData = "";
        GeneratePDF generatePDF = new GeneratePDF();

        for(Employee employee: listOfEmployeesOnPayroll.values()){
            if(employee != null) {
                System.out.println(employee.printMyData());
                payrollData += employee.printMyData();
                generatePDF.generateEmployeeDetailsPDF(employee);
                try {
                    GenerateQRCode.generateQRCodeImage(employee.printMyData(), 350, 350, "./" +  employee.getId() +".png");
                } catch (WriterException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Formatting format = new Formatting();

        String message = "Total of employees: " + listOfEmployeesOnPayroll.size() + "\n";
        message += "TOTAL PAYROLL: " + format.getCurrencyFormatter(calcTotalPayroll()) + " Canadian Dollars";
        message += "";
        generatePDF.generateTotalPayrollDetailsPDF(message);
        generatePDF.closeDocument();

        return message;
    }
}
