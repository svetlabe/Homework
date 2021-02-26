package reskillAssignmentOne;

import lombok.Getter;


import java.util.Date;
import java.util.HashMap;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Order {
    private long orderId;
    private String region;
    private String country;
    private String channel;
    private Date orderDate;
    private Date shipDate;
    private char orderPriority;
    private int unitsSold;
    private Item itemtype;
    double revenue;
    //private HashMap<Item, Integer> itemsOnOrder; //((HashMap (Item, Unitssolgt)))




    public Order(long orderId, Date orderDate, Date shipDate, char orderPriority, Item itemType, int unitsSold, String region, String country, String channel, double revenue) {
        this.orderId = orderId; //
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.orderPriority = orderPriority;
        this.country = country;
        this.channel = channel;
        this.unitsSold = unitsSold;
        this.itemtype = itemType;
        this.region = region;
        this.revenue = revenue;

    }


    // Getters

    public long getOrderId() {
        return orderId;
    }

    public double getRevenuePerOrder(){
        return revenue;

    }
    public Item getItemType(){return itemtype;}


    public double getProfitForOrder(){
        return unitsSold * itemtype.getProfitPerItemType();
    }
    public int getUnitsSold() {
        return unitsSold;
    }


    @Override
    public String toString() {
        return
                "OrderId=" + orderId +
                ", region='" + region +
                ", country='" + country +
                ", channel='" + channel +
                ", orderDate=" + orderDate +
                ", shipDate=" + shipDate +
                ", orderPriority=" + orderPriority +
                ", unitsSold=" + unitsSold +
                ", itemtype=" + itemtype.getType() +
                ", revenue=" + revenue
               ;
    }
}
