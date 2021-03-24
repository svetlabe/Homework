package no.dnb.reskill.andyonlineretailer.crudModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/full")
@CrossOrigin
public class FullController {

    @Autowired
    ProductRepository repository;

    @GetMapping(value="/products/{id}", produces={"application/json","application/xml"})
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable long id) {
        Optional<Product> p = repository.findById(id);

        if (!p.isPresent())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(p);
    }

    @GetMapping(value="/products", produces={"application/json","application/xml"})
    public ResponseEntity<Collection<Product>> getProductsMoreThan(@RequestParam(value="min", required=false, defaultValue="0.0") double min) {

        Collection<Product> allProducts = (Collection<Product>) repository.findAll();
                allProducts.stream()
                .filter(p -> p.getPrice() > min)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(allProducts);
    }

    @PostMapping(
            value="/products",
            consumes={"application/json","application/xml"},
            produces={"application/json","application/xml"})
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        repository.save(product);
        URI uri = URI.create("/full/products/" + product.getId());
        return ResponseEntity.created(uri).body(product);
    }

    @PutMapping(value="/products/{id}", consumes={"application/json","application/xml"})
    public ResponseEntity<Void> updateProduct(@PathVariable long id, @RequestBody Product product) {
        if (!repository.existsById(product.getId()))
            return ResponseEntity.notFound().build();
        else
            repository.save(product);
            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        if (!repository.existsById(id))
            return ResponseEntity.notFound().build();
        else
            repository.deleteById(id);
            return ResponseEntity.ok().build();
    }
}
