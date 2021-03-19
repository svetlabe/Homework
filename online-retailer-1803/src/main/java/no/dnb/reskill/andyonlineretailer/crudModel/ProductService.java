package no.dnb.reskill.andyonlineretailer.crudModel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;


@Component
public class ProductService {


    private ProductRepository repository;
    private Scanner scanner;
    private VatBean vat;

    @Autowired
    public ProductService(ProductRepository repository, VatBean vat){
        this.repository = repository;
        this.vat = vat;
        scanner = new Scanner(System.in);
    }






// Maybe it is better to move this to another class
    public void doService() {
        displayProducts("All products registered in the db: ");
        long id = promptForId("Enter id of the product to show:");
        System.out.println("Found product: " + repository.findById(id));
        System.out.println("Delete product.");
        id = promptForId("Choose id of the product to delete");
        Optional<Product> productToDelete = repository.findById(id);
        repository.deleteById(id);
        displayProducts("Products in db after you deleted product : " + productToDelete.get());
        System.out.println("Insert a product");
        Product productToAdd = new Product("Nissan Leaf", 35000, 20);
        repository.save(productToAdd);
        displayProducts("All products after you added new product " + productToAdd);

        System.out.println("Statistics:");
        System.out.println("------------------------------------------------");
        System.out.println("Total value: " + calculateTotalValue());
        System.out.println("Low stock products: " + getLowStockProducts(10));
        System.out.println("Average price: " + getAveragePrice());
        System.out.println("The most expensive product: " + findTheMostExpensiveProduct());
        System.out.println("The least expensive product: " + findTheLeastExpensiveProduct());



    }


    // Help method
    private long promptForId(String message) {
        System.out.printf("\n%s\n", message);
        return scanner.nextLong();
    }

    private int promptForInt(String message) {
        System.out.printf("\n%s\n", message);
        return scanner.nextInt();
    }


    public double calculateTotalValue() {
        Collection<Product> allProducts = (Collection<Product>) repository.findAll();
        return allProducts.stream()
                          .mapToDouble(p -> p.getPrice() * p.getInStock())
                          .sum();

    }


    public List<Product> getLowStockProducts(long threshold) {
        Collection<Product> allProducts = (Collection<Product>) repository.findAll();
        return allProducts.stream()

                         .filter(p -> p.getInStock() < threshold)
                         .collect(Collectors.toList());

    }


    public double getAveragePrice() {
        Collection<Product> allProducts = (Collection<Product>) repository.findAll();
        return allProducts

                         .stream()
                         .mapToDouble(p -> p.getPrice() * p.getInStock())
                         .average()
                         .orElse(0.0);
    }


    public void adjustPriceByPercent(long id, double byPercent) {
        Optional<Product> theProduct = repository.findById(id);
        if(theProduct == null){
            return;
        } else{
            theProduct.get().adjustPriceByPercent(byPercent);
            repository.save(theProduct.get());
        }

    }


    public double findTheMostExpensiveProduct(){
        Collection<Product> allProducts = (Collection<Product>) repository.findAll();
        return allProducts

                        .stream()
                        .mapToDouble(Product::getPrice)
                        .max()
                        .orElse(0.0);
    }


    public double findTheLeastExpensiveProduct(){
        Collection<Product> allProducts = (Collection<Product>) repository.findAll();
        return allProducts
                         .stream()
                         .mapToDouble(Product::getPrice)
                        .min()
                        .orElse(0.0);
    }


    public void displayProducts(String message){
        Collection<Product> allProducts = (Collection<Product>) repository.findAll();
        System.out.printf("\n%s\n", message);
        allProducts.stream()
                    .sorted()
                    .forEach(p -> System.out.println(p));

    }


    public double getPriceWithVat(long productId){
       if(!repository.existsById(productId)){
           System.out.println("Product id not found");
           return 0.0;
       } else{
           Optional<Product> product = repository.findById(productId);

           System.out.println("Found product: " + product);

           double price = product.get().getPrice();

           double vatSpec = 0;
           if(product == null){
               System.out.println("Do not have product with such ID");

           } else{

               vatSpec = vat.vatSpecification(price);
               System.out.println("I got here.Vat of product: "+ product + " is " + vatSpec) ;
           }
           return price + vatSpec;
       }

    }
    private void displayProducts(String message, Iterable<Product> products) {
        System.out.printf("\n%s\n", message);
        for (Product p: products) {
            System.out.println(p);
        }
    }



}
