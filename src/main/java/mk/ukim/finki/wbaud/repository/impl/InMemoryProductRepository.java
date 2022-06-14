package mk.ukim.finki.wbaud.repository.impl;

import mk.ukim.finki.wbaud.bootstrap.DataHolder;
import mk.ukim.finki.wbaud.model.Category;
import mk.ukim.finki.wbaud.model.Manufacturer;
import mk.ukim.finki.wbaud.model.Product;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryProductRepository {

    public List<Product> findAll(){
        return DataHolder.products;
    }

    public Optional<Product> findById(Long id){
        return DataHolder.products.stream().filter(i -> i.getId().equals(id)).findFirst();
    }
    public Optional<Product> findByName(String name){
        return DataHolder.products.stream().filter(i -> i.getName().equals(name)).findFirst();
    }

    public  Optional<Product> save(String name, Double price, Integer quantity, Category category, Manufacturer manufacturer){

        DataHolder.products.removeIf(i -> i.getName().equals(name));
        Product product = new Product(name, price, quantity, category, manufacturer);
        DataHolder.products.add(product);
        return Optional.of(product);
    }

    public void deleteById(Long id){
        DataHolder.products.removeIf(i -> i.getId().equals(id));
    }

}
