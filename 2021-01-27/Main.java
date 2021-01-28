package no.dnb.OnlineRetailer;


public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Milk","Contains lactose", "Basis products",14.56,25);
        Product product2 = new Product("Bread","Contains gluten", "Basis products",32,50);
        Product product3 = new Product("Butter","Contains lactose", "Basis products",28,15);

        System.out.println(product1.toString());
        System.out.printf("The required amount of the product is available: %b\n",product1.isAvailable(5));
        System.out.println("The sales price is: " + product1.getGrossPrice());
        product1.buyProduct(5);
        System.out.println(product1);
        product1.buyProduct(20);
        product1.chekStock();
        product1.reorderProduct(25);
        System.out.println(product1);


        System.out.println("-------------------------------");

        System.out.println(product2);
        System.out.printf("The required amount of the product is available: %b\n",product2.isAvailable(5));
        System.out.println("The sales price is: " + product2.getGrossPrice());
        product2.buyProduct(5);
        System.out.println(product2);
        System.out.println(product2.chekStock());
        System.out.println("The sales tax for this product is: " + product2.getSalesTax());

        System.out.println("-------------------------------");
        System.out.println(product3);
        product3.buyProduct(30);
        product3.buyProduct(15);
        product3.chekStock();
        product3.reorderProduct(20);
    }

}
