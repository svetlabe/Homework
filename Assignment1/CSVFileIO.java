
package reskillAssignmentOne;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class CSVFileIO implements FileIO {
    private  String[] csvValues;
    private List<String[]> orderlist = new ArrayList<>();
    private ServiceSales myServiceSales = new ServiceSales();

    private DataProcessing myDataProcessing = new DataProcessing();

    public List readFile(String filePath) throws FileNotFoundException,IOException,ParseException{
        //int counterForSkippingFirstEntry=0;
        boolean firstEntry = true;
        BufferedReader br;
        {
            readBuffer(filePath, firstEntry);
        }
        return orderlist;
    }
    public void saveReport(String reportFilePath,ServiceSales myServiceSales) throws IOException{
        ReportContent myReportContent = new ReportContent(myServiceSales);
        FileWriter fileWriter = new FileWriter(reportFilePath);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("" + myReportContent.toString());
        //printWriter.printf("test of formatted tesxt is %s and number %d ", "format", 1000);
        printWriter.close();
    }

    private void readBuffer(String filePath, boolean firstEntry) throws ParseException, IOException {
        String line="";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                csvValues = line.split(",");
                if(!firstEntry) {
                    myDataProcessing.parseStrings(csvValues);
                    myDataProcessing.populateObjects(csvValues,myServiceSales);
                }
                firstEntry =false;
                 orderlist.add(csvValues);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException ioe) {
            throw new IOException();
        }
    }
    public ServiceSales getMyServiceSales() {
        return myServiceSales;
    }
}


