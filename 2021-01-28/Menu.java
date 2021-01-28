package no.dnb.OnlineRetailer;

import java.util.ArrayList;

public class Menu {

    // It is better to make a separate class for collection of products. Made a temporary collection here.
    public static ArrayList<Product> products = new ArrayList<Product>();

    public void menuStart() {
        int userChoice;
        System.out.println("\n WELCOME\n -------------------------");

        do {
            //System.out.println("\n What do you want to do? \n 1: Add product\n 2: Show product\n 3: Check stock\n 4: Reorder product\n 5: See the tax\n 6: Exit");

            userChoice = User.getInt("\n What do you want to do? \n 1: Add product\n 2: Show product\n 3: Check stock \n 4: See the tax\n 5: Exit \n");
            switch (userChoice) {
                case 1:
                    Product product = createProduct();
                    addProduct(product);
                    System.out.println("This product has been added: " + product);
                    System.out.println("------------------------------------------");
                    break;
                case 2:
                    System.out.printf("We have %d products. ", products.size());
                    if (checkCollection()){
                        System.out.println(getProduct());
                    } else {
                        System.out.println("Nothing to show.");
                    }
                    System.out.println("---------------------------------------------");

                    break;
                case 3:
                    Product product2;
                    if (checkCollection() == false){
                        System.out.println("Nothing to check. Add products.");
                        break;
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
                    break;
                case 4:
                    if (checkCollection()){
                        Product pr3 = getProduct();
                        System.out.println("The tax rate is " + Product.getTaxRate());
                        System.out.printf("The tax for this product is %.2f kroner\n", pr3.getSalesTax());
                    } else {
                        System.out.println("The tax rate is " + Product.getTaxRate() + ". There are no products yet to show tax for a product.");
                    }
                    System.out.println("---------------------------------------------");
                    break;


            }

        }
        while (userChoice != 5);
    }

    private Product createProduct(){
        Product newProduct = new Product(User.getString("Name of the product: \n"), User.getString("Category: \n"), User.getDouble("Price: \n"), User.getInt("Stock Reorder Theshhold: \n"));
        return newProduct;
    }


    private void addProduct(Product productToAdd){
        products.add(productToAdd);
    }

    private Product getProduct() {

        Product productToShow = null;
        System.out.printf("Products' id from 1 to %d", products.size());


        if (checkCollection() ){
           int productId = User.getInt("\nType product id ", 0,products.size());
            productToShow = products.get(productId-1);
        }

        return productToShow;
    }

    private boolean checkCollection(){
        if (products.size()> 0){
            return true;
        } else {
            return false;
        }
    }
}
