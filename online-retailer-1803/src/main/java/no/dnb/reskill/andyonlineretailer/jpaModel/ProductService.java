package no.dnb.reskill.andyonlineretailer.jpaModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;


@Service
public class ProductService {

    private ProductRepositoryDatabase repository;
    private Scanner scanner;
    private VatBean vat;


    @Autowired
    public ProductService(@Qualifier("productRepositoryDatabase") ProductRepositoryDatabase repository, @Qualifier("vatSpec") VatBean vat){
        this.repository = repository;
        this.vat = vat;
        scanner = new Scanner(System.in);
    }


// Maybe it is better to move this to another class
    public void doService() {

        try {
            displayProducts("All products registered in the database:");

            long count = repository.getProductCounter();
            System.out.printf("Number of products: %d\n", count);

            long id = promptForId("Enter id of product to get: ");
            Product productToGet = repository.getProductById(id);
            System.out.printf("Product %d: %s\n", id, productToGet);


            System.out.println("-------------------Insert a new product------------------------");
            Product newProduct = new Product( "Nissan Leaf", 35000.0, 20);
            repository.insertProduct(newProduct);
            displayProducts("All employees after insert: ");




            id = promptForId("Enter id of product to update: ");
            Product productToUpdate = repository.getProductById(id);
            productToUpdate.setInStock(promptForInt("You are to about to change amount in stock. Enter amount:"));
            repository.updateProduct(productToUpdate);
            displayProducts("All employees after update: ");


            id = promptForId("Enter id of employee to delete: ");
            repository.deleteProduct(id);
            displayProducts("All employees after delete: ");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
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
        return repository.getAllProducts()
                         .stream()
                         .mapToDouble(p -> p.getPrice() * p.getInStock())
                         .sum();

    }


    public Collection<Product> getLowStockProducts(long threshold) {
        return repository.getAllProducts()
                         .stream()
                         .filter(p -> p.getInStock() < threshold)
                         .collect(Collectors.toList());

    }


    public double getAveragePrice() {
        return repository.getAllProducts()
                         .stream()
                         .mapToDouble(p -> p.getPrice() * p.getInStock())
                         .average()
                         .orElse(0.0);
    }


    public void adjustPriceByPercent(long id, double byPercent) {
        Product theProduct = repository.getProductById(id);
        if(theProduct == null){
            return;
        } else{
            theProduct.adjustPriceByPercent(byPercent);
            repository.updateProduct(theProduct);
        }

    }


    public double findTheMostExpensiveProduct(){
        return repository.getAllProducts()
                        .stream()
                        .mapToDouble(Product::getPrice)
                        .max()
                        .orElse(0.0);
    }


    public double findTheLeastExpensiveProduct(){
        return repository.getAllProducts()
                         .stream()
                         .mapToDouble(Product::getPrice)
                        .min()
                        .orElse(0.0);
    }


    public void displayProducts(String message){
        System.out.printf("\n%s\n", message);
        repository.getAllProducts().stream()
                                   .sorted()
                                   .forEach(p -> System.out.println(p));

    }


    public double getPriceWithVat(long productId){
        Product product = repository.getProductById(productId);
        System.out.println("Found product: " + product);
        double price = product.getPrice();
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
