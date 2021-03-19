package no.dnb.reskill.andyonlineretailer.jpaModel;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "PRODUCTS")

public class Product implements Comparable<Product>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id =-1; // if we put -1 here, .persist(Product p) works ; otherwise use .merge(Product p)

    private String description;

    private double price;
    @Column(name = "instock")
    private long inStock;

    public Product(){}

    public Product (String description, double price, long inStock){
        this(-1, description, price, inStock);

    }

    public Product(long id, String description, double price, long inStock) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

    public void adjustPriceByPercent(double percent){
        price *= 1 + percent / 100;
    }

    public int compareTo(Product other) {
        if (this.price < other.price)
            return 1;
        else if (this.price > other.price)
            return -1;
        else
            return 0;
    }
}
