package com.finalproject.group01.payroll;

import com.finalproject.group01.employee.Employee;
import com.finalproject.group01.utils.Formatting;
import com.finalproject.group01.utils.GeneratePDF;
import com.finalproject.group01.utils.IPrintable;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Payroll implements IPrintable {

    private Map<Integer, Employee> listOfEmployeesOnPayroll = new HashMap<>();
    private double totalPayroll;

    public Payroll() {
    }

    public Payroll(Map<Integer, Employee> listOfEmployeesOnPayroll, double totalPayroll) {
        this.listOfEmployeesOnPayroll = listOfEmployeesOnPayroll;
        this.totalPayroll = totalPayroll;
    }

    public void saveEmployeeOnPayroll(Employee employee) {
        int id = listOfEmployeesOnPayroll.size();
        listOfEmployeesOnPayroll.put(id, employee);
    }

    public Double calcTotalPayroll() {

        for(Employee employee: listOfEmployeesOnPayroll.values()){
            this.totalPayroll += employee.calcEarnings();
        }
        return totalPayroll;
    }

    @Override
    public String printMyData() {
        String payrollData = "";
        GeneratePDF generatePDF = new GeneratePDF();

        for(Employee employee: listOfEmployeesOnPayroll.values()){
            System.out.println(employee.printMyData());
            payrollData += employee.printMyData();
            generatePDF.generateEmployeeDetailsPDF(employee);
        }

        Formatting format = new Formatting();

        String message = "Total of employees: " + listOfEmployeesOnPayroll.size() + "\n";
        message += "TOTAL PAYROLL: " + format.getCurrencyFormatter(calcTotalPayroll()) + " Canadian Dollars";
        message += "";
        generatePDF.generateTotalPayrollDetailsPDF(message);
        generatePDF.closeDocument();





//        for employee in listOfEmployeesOnPayroll {
//            print(employee.value.printMyData())
//            payrollData += employee.value.printMyData()
//        }

//        String message = "Total of employees: \(listOfEmployeesOnPayroll.count)\n"
//        message += "TOTAL PAYROLL: \(calcTotalPayroll().currency) Canadian Dollars"
//        message += ""

        // --------------------------
        // saving results on TXT file
//        let fileName = "payrollTotal"
//        let DocumentDirURL = try! FileManager.default.url(for: .documentDirectory, in: .userDomainMask, appropriateFor: nil, create: true)
//        let fileURL = DocumentDirURL.appendingPathComponent(fileName).appendingPathExtension("txt")
//        payrollData += message
//        do {
//            // Write to the file
//            try payrollData.write(to: fileURL, atomically: true, encoding: String.Encoding.utf8)
//        } catch let error as NSError {
//            print("Failed writing to URL: \(fileURL), Error: " + error.localizedDescription)
//        }

//        message += "\n\nThe Payroll was saved on: \(DocumentDirURL)\(fileName).txt"

        return message;
    }
}
