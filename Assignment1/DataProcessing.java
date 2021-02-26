package reskillAssignmentOne;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;




public class DataProcessing {

    private long orderId;
    private Date orderDate;
    private Date shipDate;
    private char orderPriority;
    private String country;
    private String channel;
    private String itemType;
    private double unitPrice;
    private double unitCost;
    private int unitsSold;
    private String region;
    private double revenue;

    public void parseStrings(String[] csvValues) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        region = csvValues[0];
        country = csvValues[1];
        itemType = csvValues[2];
        channel = csvValues[3];
        orderPriority = csvValues[4].charAt(0);
        orderDate = format.parse(csvValues[5]);
        orderId = parseLong(csvValues[6]);
        shipDate = format.parse(csvValues[7]);
        unitsSold = parseInt(csvValues[8]);
        unitPrice = parseDouble(csvValues[9]);
        unitCost = parseDouble(csvValues[10]);
        revenue = parseDouble(csvValues[11]);
    }

    public void populateObjects(String[] csvValues, ServiceSales myServiceSales){
        Item newItem = new Item(itemType,unitPrice,unitCost);
        Order newOrder = new Order(orderId,orderDate,shipDate,orderPriority,newItem,unitsSold,region,country,channel, revenue);
        myServiceSales.addItem(newItem);
        myServiceSales.addOrder(newOrder);
        myServiceSales.setItemIntoHashMap(itemType, newItem);
        myServiceSales.addOrderToRegion(region, newOrder);

    }
}
