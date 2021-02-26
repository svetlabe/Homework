package reskillAssignmentOne;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface FileIO {
    List readFile(String filePath) throws FileNotFoundException, IOException, ParseException;
    void saveReport(String reportFilePath, ServiceSales myServiceSales) throws IOException;

}
