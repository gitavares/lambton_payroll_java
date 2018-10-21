package com.finalproject.group01.utils;

import com.finalproject.group01.employee.Employee;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import static com.itextpdf.text.FontFactory.*;
import static com.itextpdf.text.html.WebColors.getRGBColor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;



public class GeneratePDF {
    private static String FILE = "PayrollPdf.pdf";
    BaseColor myBackgroundColor;
    BaseColor fontColorDefault;
    BaseColor fontColorHighlight;
    private Document document;
    private Font tableHeaderFont;
    private Font titleFont;
    private Font dateFont;
    private Font defaultFont;
    private Font footerFont;

    public GeneratePDF() {
        myBackgroundColor = getRGBColor("#b1e9ff");
        fontColorDefault = getRGBColor("#000000");
        fontColorHighlight = getRGBColor("#21637c");
        dateFont = getFont(HELVETICA, 8, Font.NORMAL, fontColorDefault);
        titleFont = getFont(HELVETICA, 16, Font.BOLD, fontColorHighlight);
        defaultFont = getFont(HELVETICA, 10, Font.NORMAL, fontColorDefault);
        tableHeaderFont = getFont(HELVETICA, 10, Font.BOLD, fontColorHighlight);
        footerFont = getFont(HELVETICA, 12, Font.BOLD, fontColorHighlight);

        document = new Document(PageSize.A4, 50, 50, 50, 50);
        try {

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();

            addMetaData(document);

            Paragraph title = new Paragraph("Java Term Project - Payroll System", titleFont);
            title.setSpacingBefore(20);
            document.add(title);

            document.add(new Paragraph("Payroll generated in: " + new Date().toString(), dateFont));

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void addMetaData(Document document) {
        document.addTitle("Java Term Project - Payroll System");
        document.addCreationDate();
        document.addSubject("Term Project - 2018F_MAD 3463_4 - Programming Java");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Antonio, Giselle, Gurjeet");
        document.addCreator("Antonio, Giselle, Gurjeet");
    }

    public void generateEmployeeDetailsPDF(Employee employee) {

        try {

            PdfPTable t = new PdfPTable(2);
            t.setSpacingBefore(15);
            t.setSpacingAfter(15);

            PdfPCell c1 = new PdfPCell(new Phrase("Name", tableHeaderFont));
            c1.setBackgroundColor(myBackgroundColor);
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase(String.valueOf(employee.getName()), defaultFont));
            t.addCell(c2);

            c1 = new PdfPCell(new Phrase("Year of Birth", tableHeaderFont));
            t.addCell(c1);
            c2 = new PdfPCell(new Phrase(String.valueOf(employee.calcBirthYear()), defaultFont));
            t.addCell(c2);

            c1 = new PdfPCell(new Phrase("Vehicle", tableHeaderFont));
            t.addCell(c1);
            if(employee.getVehicle() != null) {
                c2 = new PdfPCell(new Phrase(String.valueOf(employee.getVehicle().printMyData()), defaultFont));
                t.addCell(c2);
            } else {
                c2 = new PdfPCell(new Phrase("Employee has no Vehicle registered", defaultFont));
                t.addCell(c2);
            }

            c1 = new PdfPCell(new Phrase("Employment type", tableHeaderFont));
            t.addCell(c1);
            c2 = new PdfPCell(new Phrase(String.valueOf(employee
                    .printMyData()
                    .substring(employee.printMyData().indexOf("Employee is"))
                    .replace("*", "")), defaultFont));
            t.addCell(c2);

            document.add(t);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void generateTotalPayrollDetailsPDF(String message) {
        try {

            Paragraph totalPayroll = new Paragraph(message, footerFont);
            totalPayroll.setSpacingBefore(20);
            document.add(totalPayroll);

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public void closeDocument() {
        document.close();
    }
}
