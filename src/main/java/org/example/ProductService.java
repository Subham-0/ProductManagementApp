package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {

    @Autowired
    ProductDB db;

    public void addProduct(Product p) {
        db.save(p);
    }

    public List<Product> getAllProduct() {
        return db.findAll();
    }

    public Product getProductByName(String s) {
        return db.findProductByName(s);
    }

    public List<Product> getProductByText(String s) {
        return db.findByNameContainingIgnoreCaseOrTypeContainingIgnoreCaseOrPlaceContainingIgnoreCase(s, s, s);
    }


    public List<Product> getProductWithPlace(String place) {
        return db.findByPlaceIgnoreCase(place);
    }

    public List<Product> getProductOutOfWarranty(int year) {
        return db.findOutOfWarranty(year);
    }
}
