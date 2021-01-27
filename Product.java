package no.dnb.OnlineRetailer;


public class Product {
    String name;
    String description; // describes characteristics of the product
    String category;
    double netPrice;
    int unitsInStock;
    int stockReorderTheshhold = 1;  // asigning 1 for all the objects of this class. It is also possible to take it as a parameter ig products have different demand.
    double salesTax = 0.25;


    public Product(String n, String d,String c, double np, int u){
        name = n;
        description = d;
        category = c;
        netPrice = np;
        unitsInStock = u;
    }

    public boolean isAvailable(int amount){
        // checks if there enough units on stock
        if (unitsInStock >= amount){
            return true;
        }else {
            System.out.printf("The are only %d units in stock.\n", unitsInStock);
            return false;
        }
    }

    public double getSalesTax(){
        return salesTax;
    }

    public double getGrossPrice(){
        // returns sales price

        return netPrice * 1.25;
    }

    public void chekStock(){
        if (unitsInStock <= stockReorderTheshhold){
            System.out.println("You need to reorder this product.\n");
        } else {
            System.out.printf("There are %d units in stock. You do not need to reorder this product yet.\n", unitsInStock);
        }
    }

    public void buyProduct(int amount){
        if (isAvailable(amount)){
            unitsInStock -= amount;
            System.out.printf("You have bought %d items of %s.\n ", amount, this.name);
        } else{
            System.out.println("We do  ot have so many items of this product now.");
        }

    }

    public void reorderProduct(int amount){
        unitsInStock += amount;
        System.out.printf("%d items of %s were ordered.\n", amount, this.name);
    }

    public String toString(){
        return String.format("Product: %s, Category: %s, %s, number in stock %d, Sales Price: %2f kroner.\n", name, category, description, unitsInStock, getGrossPrice());
    }


}
