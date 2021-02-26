package reskillAssignmentOne;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Menu {


    private CSVFileIO newFile;
    private String filePath;
    //private final String SAVED_REPORT_PATH = "C:\\Reskill\\Report.txt";
    private final String SAVED_REPORT_PATH = "/Users/svetlanahaugland/Desktop/Report.txt";
    private Scanner scanner = new Scanner(System.in);
    private ConsoleIO user = new ConsoleIO(scanner);

    ServiceSales service;

    public Menu()  {
        newFile = new CSVFileIO();
        filePath = user.getString("Give me path:");
        //filePath ="/Users/svetlanahaugland/Desktop/SalesRecords.csv" ;
        //filePath ="C:\\Reskill\\salesrecords.txt" ;//scanner.next();

    }

    public void menuStart() {
        try{
            newFile.readFile(filePath);
        } catch (FileNotFoundException e){
            user.logMessage("File not found!");
            return;
        } catch (IOException e){
            user.logMessage("Something went wrong!");
            return;
        } catch (ParseException e){
            user.logMessage("Parsing error.");
            return;
        }
        service = newFile.getMyServiceSales();

        int userChoice;
        System.out.println("\n WELCOME\n -------------------------");

        do {
            userChoice = user.getInt("\n What do you want to do? \n 1: Statics per Region \n 2: Statistics per Country\n 3: Order info \n " +
                    "4: Item Type info\n 5: Create a report \n 6: Exit \n");
            switch (userChoice) {

                case 1:
                    submenuRegion();
                    break;

                case 2:
                    submenuCountry();
                    break;
                case 3:
                    submenuOrder();

                    break;

                case 4:
                    submenuItem();

                    break;

                case 5:
                    CSVFileIO reportIO = new CSVFileIO();
                    try {

                        reportIO.saveReport(SAVED_REPORT_PATH, service);
                        user.logMessage("Report Saved: " + SAVED_REPORT_PATH );

                    }
                    catch (IOException IO){
                        user.logMessage("Error when generating report");
                    }
                    break;
            }
        }
        while (userChoice != 6);
    }

    private void submenuRegion(){
        int userChoice;
        do {
            userChoice = user.getInt("\n 1: Total revenue for a region \n 2: Total cost for a region\n 3: Total profit for a region \n " +
                    "4: Most sold items in a region \n 5: Most used sale channel in a region \n 6: Exit \n");
            switch (userChoice) {

                case 1:

                    break;

                case 2:

                    break;

                case 3:


                    break;

                case 4:


                    break;

                case 5:


                    break;
            }
        }
        while (userChoice != 6);
    }

    private void submenuCountry(){
        int userChoice;
        do {
            userChoice = user.getInt("\n 1: Total revenue for a country \n 2: Total cost for a country\n 3: Total profit for a country \n " +
                    "4: Most sold items in a country \n 5: Most used sale channel in a country \n 6: Exit \n");
            switch (userChoice) {

                case 1:

                    break;

                case 2:

                    break;

                case 3:


                    break;

                case 4:


                    break;

                case 5:
                    service.displayRegionInfo();


                    break;
            }
        }
        while (userChoice != 6);

    }

    private void submenuOrder(){
        int userChoice;
        do {
            userChoice = user.getInt("\n 1: See order details \n 2: Find the most profitable order \n 3: See Total Revenue \n 4: See total units sold \n 5: see average units sold per order \n 6: Exit \n");
            switch (userChoice) {

                case 1:
                    service.displayOrder();

                    break;

                case 2:

                    service.displayMostProfitableOrder();
                    break;

                case 3:

                    service.displayTotalRevenueForOrders();
                    break;
                case 4:
                    service.displayTotalUnitsSold();
                    break;
                case 5:
                    service.displayAverageUnitsSoldPerOrder();

            }
        }
        while (userChoice != 6);
    }

    private void submenuItem(){
        int userChoice;
        do {
            userChoice = user.getInt("\n 1: See all the item types ordered \n 2: Most sold item in all regions \n 3: Display sales statistics for item types \n 4: Exit \n");
            switch (userChoice) {

                case 1:
                    service.getItemTypeInfo();

                    break;

                case 2:
                    service.displayMostSoldItemType();

                    break;
                case 3:
                    service.displaySoldItems();

                    break;
            }
        }
        while (userChoice != 4);
    }

}


