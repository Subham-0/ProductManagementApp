package org.example;

import java.util.List;


public class ProductService {

    ProductDB productDB = new ProductDB();

    public void addProduct(Product p) {
        productDB.addProduct(p);
    }

    public List<Product> getAllProduct() {
        return productDB.getAllProducts();
    }

    public Product getProductByName(String s) {
        return productDB.productByName(s);
    }

    public List<Product> getProductByText(String s) {
        return productDB.productByText(s);
    }


    public List<Product> getProductWithPlace(String s) {
        return productDB.productByPlace(s);
    }

    public List<Product> getProductOutOfWarranty(int year) {
        return productDB.productsOutOfWarranty(year);
    }
}
