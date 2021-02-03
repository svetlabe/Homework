package no.dnb.OnlineRetailer;

import java.util.ArrayList;

// A collection of Products and operations with the inventory

public class Inventory {

    private  ArrayList<Product> products = new ArrayList<>();

// getters and setters

    public int getProductsAmount(){
        return products.size();
    }

    private Product getProduct() {
        System.out.printf("Products' id from 1 to %d", getProductsAmount());
        if (checkCollection() ){
            int productId = User.getInt("\nType product id ", 1,products.size());
            return products.get(productId-1);
        }
        return null;
    }

    public void addProduct(){
        String name = User.getString("Name of the product: \n");
        Product newProduct = new Product(name, User.getString("Category: \n"), User.getDouble("Price: \n"), User.getInt("Stock Reorder Theshhold: \n"));
        products.add(newProduct);
        System.out.println("This product has been added: " + newProduct);
        System.out.println("------------------------------------------");
    }

// other methods needed in the menu

    private boolean checkCollection(){  // use in other methods to check if the ArrayList not empty
        return products.size() > 0;
    }

    // use in menu 2
    public void productToShow() {
        if(checkCollection() == false){
            System.out.println("Nothing to show.");
        } else{
            System.out.println(getProduct());
        }

        System.out.println("---------------------------------------------");
    }

    // menu 3 check stock
    public void checkStock(){
        Product product2;
        if (checkCollection() == false){
            System.out.println("Nothing to check. Add products.");
            return;
        } else {
            product2 = getProduct();
        }

        if (product2.chekStock()){

            System.out.printf("We have %d unit in stock of this product. \n", product2.getUnitsInStock());
        } else{
            System.out.println("You need to reorder this product");
            product2.reorderProduct(User.getInt("How many units you want to order?"));
        }
        System.out.println("---------------------------------------------");
    }

    // menu 4 see tax rate
    public void seeTaxRate(){
        if (checkCollection()){
            Product pr3 = getProduct();
            System.out.println("The tax rate is " + Product.getTaxRate());
            System.out.printf("The tax for this product is %.2f kroner\n", pr3.getSalesTax());
        } else {
            System.out.println("The tax rate is " + Product.getTaxRate() + ". There are no products yet to show tax for a product.");
        }
        System.out.println("---------------------------------------------");
    }


}
