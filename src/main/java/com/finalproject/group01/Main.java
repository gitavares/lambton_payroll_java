package com.finalproject.group01;

import com.finalproject.group01.utils.ReadJSON;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        // Search by Name
//        System.out.println("\n\n======================================");
//        System.out.println("Search employee by name");
//        System.out.println("======================================");
//        System.out.println(payrollSingleton.getEmployeeByName("michael"));


//         JSON
        ReadJSON jsonFile = new ReadJSON();
        jsonFile.readJson();
    }
}
