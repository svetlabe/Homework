package no.dnb.reskill.andyonlineretailer.jpaModel;



import no.dnb.reskill.andyonlineretailer.jpaModel.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collection;

@Repository
public class ProductRepositoryDatabase {

    @PersistenceContext
    private EntityManager entityManager;

    public long getProductCounter(){
        String jpql = "select count (p) from Product p";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        return query.getSingleResult();
    }

    public Product getProductById(long productId){
        return entityManager.find(Product.class, productId);
    }

    public Collection<Product> getAllProducts(){
        String jpql = "select p from Product p";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        return query.getResultList();
    }

    @Transactional
    public void insertProduct(Product p){

        entityManager.persist(p);
    }

    @Transactional
    public void updateProduct(Product p){
        Product product = entityManager.find(Product.class, p.getId());
        product.setDescription(p.getDescription());
        product.setPrice(p.getPrice());
        product.setInStock(p.getInStock());
    }

    @Transactional
    public void deleteProduct(long productId){
        Product p = entityManager.find(Product.class, productId);
        entityManager.remove(p);
    }







}
