package org.example;

import java.util.ArrayList;
import java.util.List;


public class ProductService {
    List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public List<Product> getAllProduct() {
        return products;
    }

    public Product getProductByName(String s) {
        for (Product p : products) {
            if (p.getName().equals(s)) {
                return p;
            }
        }
        return null;
    }

    public List<Product> getProductByText(String s) {
        String str = s.toLowerCase();
        List<Product> list_products = new ArrayList<>();
        for (Product p : products) {

            String  name = p.getName().toLowerCase();
            String type = p.getType().toLowerCase();
            String place = p.getPlace().toLowerCase();

            if (name.contains(str) || type.contains(str) || place.contains(str)) {
                list_products.add(p);
            }
        }
        return list_products;
    }

    public List<Product> getProductWithText(String pro) {
        String str = pro.toLowerCase();
        return products.stream().filter(product -> {
                    String name = product.getName().toLowerCase();
                    String type = product.getType().toLowerCase();
                    String place = product.getPlace().toLowerCase();
                    return name.contains(str) || type.contains(str) || place.contains(str);
                })
                .toList();
    }

    public List<Product> getProductWithPlace(String s) {
        String place = s.toLowerCase();
        return products.stream()
                .filter(product -> {
                    String p = product.getPlace().toLowerCase();
                    return p.contains(place);
                })
                .toList();
    }

    public List<Product> getProductOutOfWarranty(int year) {
        return products.stream()
                .filter(product -> product.getWarranty() < year)
                .toList();
    }
}
