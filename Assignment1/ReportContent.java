package reskillAssignmentOne;

import java.util.Set;

public class ReportContent {
    private ServiceSales reportService;
    private String mostProfitableOrder;
    private String totalRevenueForAllOrders;
    private String totalUnitsSold;
    private String averageUnitsSoldPerOrder;
    private String theMostSoldItem;
    //displayMostProfitableOrder
    private Order order;

    public ReportContent(ServiceSales reportService) {
        this.order = reportService.findMaxOrder();
        this.mostProfitableOrder = ("\nMost Profitable order, OrderID:" + order.getOrderId() +" with profit:" + order.getProfitForOrder());
        this.totalRevenueForAllOrders = " \nTotal revenue for all orders " + reportService.getTotalOrderRevenue();
        this.totalUnitsSold = " \nTotal units sold:" + reportService.getTotalUnitsSold();
        this.averageUnitsSoldPerOrder =  "\nAverage units sold per order:" + reportService.getAverageUnitsSoldPerOrder();
        this.theMostSoldItem = "The most sold item type: " + reportService.getMostSoldItemToDisplay();
    }

    public String getMostProfitableOrder() {
        return mostProfitableOrder;
    }

    @Override
    public String toString() {
        return "ReportContent\n" +
                "" + mostProfitableOrder + " "  +
                "\n" + totalRevenueForAllOrders  +
                "\n" + totalUnitsSold +
                "\n" + averageUnitsSoldPerOrder + "\n" +
                "\n" + theMostSoldItem;
    }
}