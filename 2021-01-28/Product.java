
package no.dnb.OnlineRetailer;


import java.util.ArrayList;

public class Product {
    private String name;
    private String description; // describes characteristics of the product
    private String category;
    private double netPrice;
    private int unitsInStock;
    private int stockReorderTheshhold;

    private final int id;

    private final  static double SALES_TAX = 0.25;
    private static int nextId = 1;



    public Product(String name, String category, double netPrice,  int stockReorderTheshhold) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.netPrice = netPrice;
        this.stockReorderTheshhold = stockReorderTheshhold;
        this.id = nextId ++;

    }

    public boolean isAvailable(int amount){
        // checks if there enough units in stock
        if (unitsInStock >= amount){
            return true;
        }else {
            System.out.printf("The are %d units in stock.\n", unitsInStock);
            return false;
        }
    }

    public double getSalesTax(){
        return SALES_TAX * netPrice;
    }
    public static double getTaxRate(){
        return SALES_TAX;
    }

    public double getGrossPrice(){
        // returns sales price
        return netPrice +getSalesTax();
    }

    public int getUnitsInStock(){

        return unitsInStock;
    }

    public boolean chekStock(){
        return unitsInStock > stockReorderTheshhold;

    }

    public void buyProduct(int amount){
        if (isAvailable(amount)){
            unitsInStock -= amount;
            System.out.printf("You have bought %d items of %s.\n ", amount, this.name);
        } else{
            System.out.println("We do  ot have so many items of this product now.\n");
        }

    }

    public void reorderProduct(int amount){
        unitsInStock += amount;
        System.out.printf("%d items of %s were ordered.\n", amount, this.name);
    }

    public int getID(){
        return id;
    }



    @Override
    public String toString(){
        return String.format("Name: %s, Category: %s, number in stock %d, Sales Price: %.2f kroner.\n", name, category,  unitsInStock, getGrossPrice());
}


}
