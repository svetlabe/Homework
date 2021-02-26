package reskillAssignmentOne;


import lombok.Data;


@Data
public class Item {

    private String type; // nummer 2
    private double unitPrice; // nummer 9
    private double unitCost; // nummer 10
    //private int id;
    //private static int nextId = 0;

    public Item(String type, double unitPrice, double unitCost){
        //id = nextId++;
        this.type = type;
        this.unitPrice = unitPrice;
        this.unitCost = unitCost;
    }

    public String getType() {
        return type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getUnitCost() {
        return unitCost;
    }


    public double getProfitPerItemType(){
        return unitPrice - unitCost;
    }

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Item item = (Item) o;
        // field comparison
        boolean b = type.equals(item.getType())
                ;
        return b;
    }


    @Override
    public String toString() {
        return "Item type: " + type +
                ", unitPrice = " + unitPrice +
                ", unitCost = " + unitCost;
    }


}
