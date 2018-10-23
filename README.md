# Group: #01
- Antonio
- Giselle
- Gurjeet

# What we did:
- Abstract classes:
    - a) Vehicle, with the subclasses Car and Motorcycle;
    - b) Employee, with the subclass PartTime, Intern and FullTime;
    - c) PartTime with the subclass CommissionBasedPartTime and FixedBasedPartTime.
- Every one of these classes implements the IPrintable interface , directly or by inheritance;
- Two objects of each one of the classes to test the output;
- A package named utils containing the  classes:
    - a) Formatting, with the methods to format the numbers (currency, percentage) according with the Local (Locale object);
    - b) Generate PDF, to generate the output file of type .PDF;
    - c) Generate QRCode, to generate an .png image file containing the QRCode with the informations of an Employee;
    - d) The IPrintable interface;
    - e) ReadJSON to get the input data from a JSON File.
- A class named Payroll (Singleton), inside the package payroll, that implements the IPrintable interface, stores the employees data in one dictionary, calculates the total of the payroll and exports the output to a PDF file and generate an image with the QRCode of an Emplyoee;
- A package named exceptions with the classes InvalidEarninsgException and InvalidFieldException for Error Handling purposes.


# References:
- iTextPDF: http://www.vogella.com/tutorials/JavaPDF/article.html
- Currency format: https://stackoverflow.com/questions/2379221/java-currency-number-format
- Locale Class: https://docs.oracle.com/javase/7/docs/api/java/util/Locale.html
- To exit the program in a Exception: https://stackoverflow.com/questions/10964821/exception-caught-but-program-keeps-running
- To read a JSON file: https://stackoverflow.com/questions/6068197/utils-to-read-resource-text-file-to-string-java
- To generate QR Code in java using zxing: https://www.callicoder.com/generate-qr-code-in-java-using-zxing/
- Mr. Patel references given through Slack

