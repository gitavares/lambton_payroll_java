Group: #01
- Antonio
- Giselle
- Gurjeet

# What we did:
1 - Abstract classes:
    a)  Vehicle, with the subclasses Car and Motorcycle.
    b) Abstract class Employee, with the children PartTime, Intern and FullTime.
    c) Abstract classe PartTime with the children commissionBasedPartTime and FixedBased PartTime
2 - Every one of these classes implements the IPrintable interface , directly or by inheritance
3 - Two objects of each one of the classes to test the output
4 - A package named Utils containing the  classes:
    a) Formatting with the methods to format the numbers (currency, percentage) according with the Local (Locale object).
    b) Generate PDF, to generate the output file of type .PDF;
    c) Generate QRCode, to generate an .png image file containing the QRCode with the informations of an Employee;
    d) The IPrintable interface;
    e) ReadJSON to get the input data from a JSON File.
5 - A class named Payroll, inside the package payroll, that implements the IPrintable interface, stores the employees data in one dictionary, calculates the total of the payroll and exports the output to a PDF file.
6 - A package named exceptions with the classes InvalidEarninsgException and InvalidFieldException for Error Handling purposes.

References:

- iTextPDF: http://www.vogella.com/tutorials/JavaPDF/article.html
- Currency format: https://stackoverflow.com/questions/2379221/java-currency-number-format
- Locale Class: https://docs.oracle.com/javase/7/docs/api/java/util/Locale.html
- To exit the program in a Exception: https://stackoverflow.com/questions/10964821/exception-caught-but-program-keeps-running
- To read a JSON file: https://stackoverflow.com/questions/6068197/utils-to-read-resource-text-file-to-string-java
- To generate QR Code in java using zxing: https://www.callicoder.com/generate-qr-code-in-java-using-zxing/
- Mr. Patel references given through Slack

