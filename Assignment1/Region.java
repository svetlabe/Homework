package reskillAssignmentOne;

import java.util.Collection;
import java.util.HashMap;

public class Region {
    String name;
    HashMap<Long, Order> ordersPerRegion;

    public Region(String navn){
        this.name = navn;
        ordersPerRegion = new HashMap<>();
    }

    public void addOrder(Order order){
        if(!ordersPerRegion.containsKey(order.getOrderId())){
            ordersPerRegion.put(order.getOrderId(),order);
        }
    }


    public String getName() {
        return name;
    }

    public double getRevenue(){
        double revenuePerOrder = 0;
        Collection<Order> orders = ordersPerRegion.values();
        for(Order order: orders){
            revenuePerOrder += order.getRevenuePerOrder();
        }
        return revenuePerOrder;
    }


    public boolean equals(Region other){
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        return name.equals(other.getName());
    }

    public int getAmountOfOrders(){
        return ordersPerRegion.size();
    }

    public Order findOrderInRegion(long orderID){
        return ordersPerRegion.get(orderID);
    }

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", ordersPerRegion=" + ordersPerRegion +
                '}';
    }
}
